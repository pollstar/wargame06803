package ua.pollstar.softserve.warriors;

public class Lancer extends Warrior {
    private static int maxHealth = 50;
    private static int maxAttack = 6;
    private static int percentNextDamage = 50;

    public Lancer() {
        setHealth(maxHealth);
        setAttack(maxAttack);
    }

    public void attackEnemy(Warrior enemy1, Warrior enemy2) {
        if (enemy1 == null) {
            return;
        }
        log.info(" - lancer attack " + getAttack() + " to " + enemy1.getClass().getSimpleName());
        int healthEnemyBeforeAttack = enemy1.getHealth();
        enemy1.takeDamage(getAttack());
        log.info("    - health " + enemy1.getClass().getSimpleName() + " is " + enemy1.getHealth());
        if (enemy2 == null) {
            return;
        }

        final int percent = 100;
        int damage = (healthEnemyBeforeAttack - enemy1.getHealth()) * percentNextDamage / percent;
        log.info(" - lancer attack " + damage + " to " + enemy2.getClass().getSimpleName());
        enemy2.takeDamage(damage);
        log.info("    - health " + enemy2.getClass().getSimpleName() + " is " + enemy2.getHealth());
    }
}
