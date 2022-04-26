package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.weapons.Weapon;

public class Defender extends Warrior {
    private int maxDefense;
    private int defense;

    public Defender() {
        setMaxDefense(ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.DEFENSE));
        setDefense(getMaxDefense());
    }

    public void takeDamage(int damage) {
        if (damage > getDefense()) {
            super.takeDamage(damage - getDefense());
        }
    }

    public int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = Math.max(Math.min(defense, getMaxDefense()), 0);
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public void setMaxDefense(int maxDefense) {
        this.maxDefense = Math.max(maxDefense, 0);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setMaxDefense(getMaxDefense() + weapon.getDefense());
        setDefense(getDefense() + weapon.getDefense());
    }
}
