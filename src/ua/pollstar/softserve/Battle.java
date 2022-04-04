package ua.pollstar.softserve;

public class Battle {
    private Battle() {
    }

    public static boolean fight(Warrior warrior1, Warrior warrior2) {

        while (true) {
            warrior1.attackEnemy(warrior2);
            if (!warrior2.getAlive()) {
                return true;
            }

            warrior2.attackEnemy(warrior1);
            if (!warrior1.getAlive()) {
                return false;
            }
        }
    }
}
