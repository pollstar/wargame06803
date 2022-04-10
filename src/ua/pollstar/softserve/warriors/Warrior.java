package ua.pollstar.softserve.warriors;

import java.util.logging.Logger;

public class Warrior {
    private static int maxHealth = 50;
    private static int maxAttack = 5;

    private int health;
    private boolean alive = true;
    private int attack;

    public Warrior() {
        setHealth(maxHealth);
        setAttack(maxAttack);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean isAlive() {
        return alive;
    }

    public void attackEnemy(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        enemy.takeDamage(getAttack());
        log.info(" - " + this.getClass().getSimpleName() + " attack " + getAttack()
                + " to " + enemy.getClass().getSimpleName());
        log.info("    - health " + enemy.getClass().getSimpleName() + " is " + enemy.getHealth());
    }

    protected void takeDamage(int damage) {
        int h = getHealth();
        h -= damage;
        setHealth(h);
    }

    protected void setHealth(int health) {
        this.health = health;
        alive = this.health > 0;
    }

    protected int getHealth() {
        return health;
    }

    Logger log = Logger.getLogger(this.getClass().getName());

}