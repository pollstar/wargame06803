package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.Army;
import ua.pollstar.softserve.eventhandling.EventsType;
import ua.pollstar.softserve.eventhandling.Handler;
import ua.pollstar.softserve.weapons.Weapon;

public class Warrior implements Handler {
    private int maxHealth;
    private int maxAttack;

    private int health;
    private int attack;

    private Army army = null;
    Handler next = null;

    public Warrior() {
        setMaxHealth(ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.HEALTH));
        setMaxAttack(ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.ATTACK));
        setHealth(getMaxHealth());
        setAttack(getMaxAttack());
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = Math.max(0, Math.min(attack, getMaxAttack()));
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void attackEnemy(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        this.handler(this, EventsType.NEED_HEAL, 0);
        enemy.handler(this, EventsType.TAKE_ATTACK, getAttack());
    }

    public void attackEnemyInStraightFight(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        enemy.handler(this, EventsType.TAKE_ATTACK, getAttack());
    }

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    protected void setHealth(int health) {
        this.health = Math.min(health, getMaxHealth());
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = Math.max(maxHealth, 0);
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = Math.max(maxAttack, 0);
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public void equipWeapon(Weapon weapon) {
        setMaxHealth(getMaxHealth() + weapon.getHealth());
        setMaxAttack(getMaxAttack() + weapon.getAttack());

        setHealth(getHealth() + weapon.getHealth());
        setAttack(getAttack() + weapon.getAttack());
    }

    @Override
    public void setNext(Handler handler) {
        next = handler;
    }

    @Override
    public Handler getNext() {
        return next;
    }

    @Override
    public void handler(Warrior ownerEvent, EventsType event, int value) {
        if (event == EventsType.TAKE_ATTACK) {
            takeDamage(value);
        } else if(next != null) {
            if (event == EventsType.TAKE_ATTACK_FOR_NEXT) {
                next.handler(this, EventsType.TAKE_ATTACK, value);
            } else {
                next.handler(this, event, value);
            }
        }
    }
}
