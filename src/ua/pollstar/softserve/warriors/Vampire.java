package ua.pollstar.softserve.warriors;

public class Vampire extends Warrior {
    private static int maxHealth = 40;
    private static int maxAttack = 4;
    private static int maxVampirism = 50;

    private int vampirism;

    Vampire() {
        setHealth(maxHealth);
        setAttack(maxAttack);
        setVampirism(maxVampirism);
    }

    private void setVampirism(int i) {
        this.vampirism = i;
    }

    private int getVampirism() {
        return vampirism;
    }

    public static int getMaxVampirism() {
        return maxVampirism;
    }

    public static void setMaxVampirism(int maxVampirism) {
        Vampire.maxVampirism = maxVampirism;
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        int healthEnemyBeforeAttack = enemy.getHealth();
        enemy.takeDamage(getAttack());
        final int percent = 100;
        setHealth(Math.min(getHealth() + (healthEnemyBeforeAttack - enemy.getHealth()) * getVampirism()
                / percent, maxHealth));
    }
}
