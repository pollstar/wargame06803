package ua.pollstar.softserve.warriors;

public class Lancer extends Warrior {
    private static int maxHealth = 50;
    private static int maxAttack = 6;
    private static int percentNextDamage = 50;

    public Lancer() {
        setHealth(maxHealth);
        setAttack(maxAttack);
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        if (enemy == null) {
            return;
        }

        Warrior enemy2 = null;
        if (enemy.inArmy()) {
            enemy2 = enemy.getArmy().getWarriorBehind();
        }

        int healthEnemyBeforeAttack = enemy.getHealth();
        enemy.takeDamage(getAttack());
        if (enemy.getArmy() == null)  {
            return;
        }
        if (enemy2 == null) {
            return;
        }

        final int percent = 100;
        int damage = (healthEnemyBeforeAttack - enemy.getHealth()) * percentNextDamage / percent;
        enemy2.takeDamage(damage);
    }

    public static void setHealthMax(int health) {
        maxHealth = health;
    }

    public static int getMaxHealth(){
        return maxHealth;
    }

}
