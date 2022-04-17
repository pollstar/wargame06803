package ua.pollstar.softserve;

import ua.pollstar.softserve.warriors.Warrior;
import ua.pollstar.softserve.warriors.WarriorFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Army {
    private final Queue<Warrior> troops = new LinkedList<>();

    public void addUnit(WarriorFactory.Type warrior, int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            troops.offer(WarriorFactory.createWarrior(warrior, this));
        }
    }

    public void addUnit(Class<? extends Warrior> warrior, int count) {
        for (int i = 0; i < count; i++) {
            troops.offer(WarriorFactory.createWarrior(warrior, this));
        }
    }

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive()) {
            warrior1.attackEnemy(warrior2);
            if (warrior2.isAlive()) {
                warrior2.attackEnemy(warrior1);
            }
            if (!warrior2.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public Warrior getWarrior() {
        if (isAlive()) {
            return troops.peek();
        }
        return null;
    }

    public Warrior getWarriorBehind() {
        if (isAlive()) {
            Iterator<Warrior> itr = troops.iterator();
            if (itr.hasNext()) {
                itr.next();
                while (itr.hasNext()) {
                    Warrior nextWarrior = itr.next();
                    if (nextWarrior.isAlive()) {
                        return nextWarrior;
                    }
                }
            }
        }
        return null;
    }

    public boolean isAlive() {
        while (!troops.isEmpty()) {
            if (troops.peek().isAlive()) {
                return true;
            } else {
                troops.poll();
            }
        }
        return false;
    }
}
