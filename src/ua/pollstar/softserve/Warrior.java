package ua.pollstar.softserve;

public class Warrior {
    protected int health = 50;
    protected boolean isAlive = true;
    private static int attack = 5;

    public boolean getAlive() {
        return isAlive;
    }

    public void attackEnemy(Warrior enemy) {
        enemy.setDamage(getAttack());
    }

    private void setDamage (int damage ) {
        health -= damage;
        if(health < 0) {
            isAlive = false;
        }
    }

    public int getAttack() {
        return attack;
    }
}
