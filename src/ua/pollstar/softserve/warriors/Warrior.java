package ua.pollstar.softserve.warriors;

public class Warrior {
    private int health;
    private boolean alive = true;
    private int attack;

    public Warrior() {
        setHealth(50);
        setAttack(5);
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
    }

    protected void takeDamage(int damage) {
        int h = getHealth();
        h -= damage;
        alive = h > 0;
        setHealth(h);
    }

    protected void setHealth(int health) {
        this.health = Math.max(health, 0);
        alive = this.health>0;
    }

    protected int getHealth() {
        return health;
    }
}