package ua.pollstar.softserve;

import java.lang.reflect.InvocationTargetException;

public class Warrior {
    protected int health;
    protected boolean alive = true;
    protected int attack;

    public Warrior() {
        health = 50;
        attack = 5;
    }

    public boolean isAlive() {
        return alive;
    }

    public void attackEnemy(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        enemy.setDamage(getAttack());
    }

    private void setDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            alive = false;
        }
    }

    public int getAttack() {
        return attack;
    }

    public enum Type {
        WARRIOR,
        KNIGHT
    }

    public static Warrior warriorFactory(Type type) {
        return switch (type) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
        };
    }

    public static Warrior warriorFactory(Class<? extends Warrior> warriorClass) {
        try {
            var constructor = warriorClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            return null;
        }
    }
}