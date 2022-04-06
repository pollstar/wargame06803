package ua.pollstar.softserve;

import java.util.LinkedList;
import java.util.Queue;

public class Army {
    private final Queue<Warrior> troops = new LinkedList<>();

    public void addUnit(Warrior.Type warrior, int count) {
        if (count <= 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            troops.offer(Warrior.warriorFactory(warrior));
        }
    }

    public void addUnit(Class <? extends Warrior> warrior, int count) {
        for (int i = 0; i < count; i++) {
            troops.offer(Warrior.warriorFactory(warrior));
        }
    }

    public Warrior getWarrior() {
        if (isAlive()) {
                return troops.peek();
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
