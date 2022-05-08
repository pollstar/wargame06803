package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.Army;

import ua.pollstar.softserve.eventhandling.Event;
import ua.pollstar.softserve.eventhandling.EventsType;
import ua.pollstar.softserve.weapons.Weapon;

public class Warrior{
    private int maxHealth;
    private int maxAttack;

    private int health;
    private int attack;

    private Army army = null;

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
        if (this.getArmy() != null) {
            army.handler(new Event(this, EventsType.NEED_HEAL, 0));
        }
        if (enemy.getArmy() == null) {
            enemy.handler(new Event(this, EventsType.TAKE_ATTACK, getAttack()));
        } else {
            enemy.getArmy().handler(new Event(this, EventsType.TAKE_ATTACK, getAttack()));
        }
    }

    public void attackEnemyInStraightFight(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        enemy.handler(new Event(null, EventsType.TAKE_ATTACK, getAttack()));
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

    public Event handler(Event event) {
        if (event.getEvent() == EventsType.TAKE_ATTACK) {
            takeDamage(event.getValue());
            return null;
        }
        if (event.getEvent() == EventsType.TAKE_ATTACK_FOR_NEXT) {
            event.setEvent(EventsType.TAKE_ATTACK);
        } else {
            event.setOwnerEvent(this);
        }
        return event;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                getDataForPrintString() +
                '}';
    }

    protected String getDataForPrintString() {
        return  "maxHealth=" + maxHealth +
                ", health=" + health +
                ", maxAttack=" + maxAttack +
                ", attack=" + attack;
    }

}
