package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.Army;

public class Warrior {
    private int health;
    private int attack;
    private Army army = null;

    public Warrior() {
        setHealth(ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.HEALTH));
        setAttack(ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.ATTACK));
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        var maxAttack = ParametersWarrior.getParameter(this,
                ParametersWarrior.Parameter.ATTACK);
        if (attack < 0) {
            this.attack = 0;
        } else if (attack > maxAttack) {
            this.attack = maxAttack;
        } else {
            this.attack = attack;
        }
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

    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        if (isAlive() && army != null) {
            army.needHeal(this);
        }

    }

    protected void setHealth(int health) {
        this.health = Math.min(health, ParametersWarrior.getParameter(
                                        this.getClass(), ParametersWarrior.Parameter.HEALTH));
    }

    public int getHealth() {
        return health;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }
}
