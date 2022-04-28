package ua.pollstar.softserve;

import ua.pollstar.softserve.warriors.Warrior;

import java.util.Iterator;

public class Battle {
    public static boolean fight(Army army1, Army army2) {
        while (army1.isAlive() && army2.isAlive()) {
            army1.moveUnits();
            army2.moveUnits();
            fight(army1.getWarrior(), army2.getWarrior());
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

    public static boolean straightFight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive()) {
            warrior1.attackEnemyInStraightFight(warrior2);
            if (warrior2.isAlive()) {
                warrior2.attackEnemyInStraightFight(warrior1);
            }
            if (!warrior2.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public static boolean straightFight(Army army1, Army army2) {
        while (army1.isAlive() && army2.isAlive()) {
            Iterator<Warrior> it1 = army1.iterator();
            Iterator<Warrior> it2 = army2.iterator();
            while (it1.hasNext() && it2.hasNext()) {
                straightFight(it1.next(), it2.next());
            }
        }
        return army1.isAlive();
    }
}