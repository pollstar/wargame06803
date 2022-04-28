package ua.pollstar.softserve;

import ua.pollstar.softserve.eventhandling.Handler;
import ua.pollstar.softserve.warriors.*;

import javax.security.auth.callback.LanguageCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Army implements Iterable<Warrior> {
    private LinkedList<Warrior> troops = new LinkedList<>();

    public void addUnit(WarriorFactory.Type warrior, int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            Warrior w = WarriorFactory.createWarrior(warrior, this);
            troops.peekLast().setNext(w);
            troops.addLast(w);
        }
    }

    public void addUnit(Class<? extends Warrior> warrior, int count) {
        for (int i = 0; i < count; i++) {
            Warrior w = WarriorFactory.createWarrior(warrior, this);
            if (w.getClass() == Warlord.class && searchWarlord() != null) {
                return;
            }
            if (!troops.isEmpty()) {
                troops.peekLast().setNext(w);
            }
            troops.addLast(w);
        }
    }

    public void addUnit(Warrior warrior) {
        troops.addLast(warrior);
    }

    public void clearTroops() {
        troops.clear();
    }


    private Warlord searchWarlord() {
        for (Warrior k : troops) {
            if (k.getClass() == Warlord.class) {
                return (Warlord) k;
            }
        }
        return null;
    }

    public Warrior getWarrior() {
        if (isAlive()) {
            return troops.peek();
        }
        return null;
    }

    public boolean isAlive() {
        removeDead();
        return !troops.isEmpty();
    }

    private void removeDead() {
        var it = troops.iterator();
        var prev = troops.peekFirst();
        Handler next;
        while (it.hasNext()) {
            var warrior = it.next();
            if (!warrior.isAlive()) {
                next = warrior.getNext();
                prev.setNext(next);
                it.remove();
            } else {
                prev = warrior;
            }
        }
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
        for (Warrior w: troops) {
            warriors.add(w.getClass().getSimpleName());
        }

        return "Army{" +
                "troops=" + warriors +
                '}';
    }
}
