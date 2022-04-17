package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.Army;

import java.util.logging.Logger;

public class Warrior {
    private static int maxHealth = 50;
    private static int maxAttack = 5;

    private int health;
    private int attack;

    private Army army = null;

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
        return health > 0;
    }

    public void attackEnemy(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        enemy.takeDamage(getAttack());
    }

    protected void takeDamage(int damage) {
        int h = getHealth();
        h -= damage;
        setHealth(h);
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected int getHealth() {
        return health;
    }

    Logger log = Logger.getLogger(this.getClass().getName());

    public static void setHealthMax(int health) {
        maxHealth = health;
    }

    public static int getMaxHealth(){
        return maxHealth;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army inArmy) {
        this.army = inArmy;
    }

    public boolean inArmy() {
        return getArmy() != null;
    }
}
