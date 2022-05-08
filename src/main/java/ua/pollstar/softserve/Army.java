package ua.pollstar.softserve;

import ua.pollstar.softserve.eventhandling.Event;
import ua.pollstar.softserve.eventhandling.EventsType;
import ua.pollstar.softserve.warriors.*;
import ua.pollstar.softserve.weapons.Weapon;

import java.util.*;

public class Army implements Iterable<Warrior> {
    private LinkedList<Warrior> troops = new LinkedList<>();

    public void addUnit(WarriorFactory.Type warrior, int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            Warrior w = WarriorFactory.createWarrior(warrior, this);
            troops.addLast(w);
        }
    }

    public void addUnit(Class<? extends Warrior> warrior, int count) {
        for (int i = 0; i < count; i++) {
            Warrior w = WarriorFactory.createWarrior(warrior, this);
            if (w.getClass() == Warlord.class && getWarlord() != null) {
                return;
            }
            troops.addLast(w);
        }
    }

    public void addUnit(Warrior warrior) {
        warrior.setArmy(this);
        troops.addLast(warrior);
    }

    public Warrior getWarrior() {
        if (isAlive()) {
            moveUnits();
            return troops.peek();
        }
        return null;
    }

    public void equipWeapon(int index, Weapon weapon) {
        if (index < troops.size()) {
            troops.get(index).equipWeapon(weapon);
        }
    }

    public boolean isAlive() {
        troops.removeIf(warrior -> !warrior.isAlive());
        return !troops.isEmpty();
    }

    @Override
    public Iterator<Warrior> iterator() {
        return troops.iterator();
    }

    public void moveUnits() {
        Warlord warlord = getWarlord();
        if (warlord != null) {
            troops = warlord.moveUnits();
        }
    }

    private Warlord getWarlord() {
        for (Warrior w : troops) {
            if (w.getClass() == Warlord.class) {
                return (Warlord) w;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        ArrayList<String> warriors = new ArrayList<>();
        for (Warrior w : troops) {
            warriors.add(w.getClass().getSimpleName());
        }

        return "Army{" +
                "troops=" + warriors +
                '}';
    }

    public void handler(Event event) {
        if (event.getEvent() == EventsType.TAKE_FIRE_ATTACK) {
            handlerEventFire(event);
        }
        var it = troops.iterator();
        Event callbackEvent;
        if (it.hasNext()) {
            callbackEvent = it.next().handler(event);
            while (it.hasNext()) {
                if (callbackEvent == null) {
                    return;
                }
                callbackEvent = it.next().handler(callbackEvent);
            }
        }
    }

    private void handlerEventFire(Event event) {
        if (event.getOwnerEvent().getClass() != Dragon.class) {
            throw new IllegalArgumentException("Owner event should be Dragon.");
        }
        Dragon dragon = ((Dragon) event.getOwnerEvent());
        int percent = 100;
        int countEnemyForDamage = Math.round(percent / dragon.getPercentNextDamage());
        int index = dragon.getArmy().troops.indexOf(dragon);

        if (troops.size() > index) {
            for (int i = index - countEnemyForDamage, j = -countEnemyForDamage;
                 i < index + countEnemyForDamage; i++, j++) {
                if (i >= 0 && i < troops.size()) {
                    int attack = dragon.getAttack() * (countEnemyForDamage - Math.abs(j)) * dragon.getPercentNextDamage()/percent;
                    troops.get(i).handler(new Event(null, EventsType.TAKE_ATTACK, attack));
                }
            }
        }
    }

    public int size() {
        return troops.size();
    }
}
