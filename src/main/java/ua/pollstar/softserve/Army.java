package ua.pollstar.softserve;

import ua.pollstar.softserve.warriors.Healer;
import ua.pollstar.softserve.warriors.Warrior;
import ua.pollstar.softserve.warriors.WarriorFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class Army implements Iterable<Warrior> {
    private final LinkedList<Warrior> troops = new LinkedList<>();
    public boolean dispatcherWork = true;

    public void addUnit(WarriorFactory.Type warrior, int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            troops.addLast(WarriorFactory.createWarrior(warrior, this));
        }
    }

    public void addUnit(Class<? extends Warrior> warrior, int count) {
        for (int i = 0; i < count; i++) {
            troops.addLast(WarriorFactory.createWarrior(warrior, this));
        }
    }

    public Warrior getWarrior() {
        if (isAlive()) {
            return troops.peek();
        }
        return null;
    }

    public boolean isAlive() {
        removeDead();
        return  !troops.isEmpty();
    }

    private void removeDead() {
        var it = troops.iterator();
        while (it.hasNext()){
            if (!it.next().isAlive()) {
                it.remove();
            }
        }
    }

    @Override
    public Iterator<Warrior> iterator() {
        return troops.iterator();
    }

    class iteratorStraightFight implements Iterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }

    public void straightFightOn() {
        dispatcherWork = true;
    }

    public void straightFightOff() {
        dispatcherWork = false;
    }

    public void needHeal(Warrior warrior) {
        if (dispatcherWork) {
            var index = troops.indexOf(warrior);
            if (index >= troops.size()-1) {
                return;
            }
            Warrior healer;
            if ((healer = troops.get(index + 1)).getClass() ==
                    Healer.class) {
                ((Healer) healer).heal(warrior);
            }
        }

    }

    public void takeDamageForNext(Warrior warrior, int damage) {
        if (dispatcherWork) {
            var index = troops.indexOf(warrior);
            if (index >= troops.size()-1) {
                return;
            }
            troops.get(index + 1).takeDamage(damage);
        }
    }


}
