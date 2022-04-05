package ua.pollstar.softserve;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private final List<Warrior> warriorsList = new ArrayList<>();
    private boolean isAlive = false;

    public void addUnit(TypeWarrior warrior, int count) {
        if (count <= 0) {
            return;
        }
        isAlive = true;
        for (int i = 0; i < count; i++) {
            switch (warrior) {
                case WARRIOR -> warriorsList.add(new Warrior());
                case KNIGHT -> warriorsList.add(new Knight());
            }
        }
    }

    public Warrior getWarrior() {
        if (warriorsList.isEmpty()) {
            return null;
        }
        for (Warrior warrior : warriorsList) {
            if (warrior.getAlive()) {
                return warrior;
            }
        }
        isAlive = false;
        return null;
    }

    public boolean getIsAlive() {
        if (isAlive) {
            for (Warrior warrior : warriorsList) {
                if (warrior.getAlive()) {
                    return true;
                }
            }
        }
        isAlive = false;
        return false;
    }
}
