package ua.pollstar.softserve;

public class Battle {
    public static boolean fight(Army army1, Army army2) {
        while (army1.isAlive() && army2.isAlive()) {
            fight(army1.getWarrior(), army2.getWarrior());
        }
        return army1.isAlive();
    }

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.getAlive()) {
            warrior1.attackEnemy(warrior2);
            if (warrior2.getAlive()) {
                warrior2.attackEnemy(warrior1);
            }
            if (!warrior2.getAlive()) {
                return true;
            }
        }
        return false;
    }
}
