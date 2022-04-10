package ua.pollstar.softserve;

import ua.pollstar.softserve.warriors.Lancer;
import ua.pollstar.softserve.warriors.Warrior;

import java.util.logging.Logger;

public class Battle {
    public static boolean fight(Army army1, Army army2) {
        while (army1.isAlive() && army2.isAlive()) {
            Warrior warrior1 = army1.getWarrior();
            if (warrior1.getClass().equals(Lancer.class)) {
                fight((Lancer) warrior1, army2);
            } else {
                fight(warrior1, army2.getWarrior());
            }
        }
        return army1.isAlive();
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

    public static boolean fight(Lancer lancer, Army army) {
        Warrior enemy1 = army.getWarrior();
        Warrior enemy2 = army.getWarriorBehind();
        if (enemy1 == null) {
            return true;
        }
        if (lancer == null) {
            return false;
        }

        while (enemy1.isAlive()) {
            if (lancer.isAlive()) {
                lancer.attackEnemy(enemy1, enemy2);
            }
            if (enemy1.isAlive()) {
                enemy1.attackEnemy(lancer);
                if (!lancer.isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

    static Logger log = Logger.getLogger(Battle.class.getName());

}
