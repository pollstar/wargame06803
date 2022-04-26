package ua.pollstar.softserve;

import ua.pollstar.softserve.eventhandling.Handler;
import ua.pollstar.softserve.warriors.Warrior;
import ua.pollstar.softserve.warriors.WarriorFactory;

import java.util.Iterator;
import java.util.LinkedList;

public class Army implements Iterable<Warrior> {
    private final LinkedList<Warrior> troops = new LinkedList<>();

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
            if (!troops.isEmpty()) {
                troops.peekLast().setNext(w);
            }
            troops.addLast(w);
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
}
