package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.weapons.Weapon;

public class Healer extends Warrior {
    private int maxHealOneTime;
    private int healOneTime;
    private int countHeals = 50;

    public Healer() {
        setMaxHeal(ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.HEAL));
        setHeal(getMaxHeal());
    }

    public void heal(Warrior warrior) {
        if ((countHeals--) > 0) {
            warrior.setHealth(warrior.getHealth() + healOneTime);
        }
    }

    public int getHeal() {
        return healOneTime;
    }

    public void setHeal(int healOneTime) {
        this.healOneTime = Math.max(0, Math.min(healOneTime, getMaxHeal()));
    }

    public int getMaxHeal() {
        return maxHealOneTime;
    }

    public void setMaxHeal(int maxHealOneTime) {
        this.maxHealOneTime = Math.max(maxHealOneTime, 0);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);

        setMaxHeal(getMaxHeal() + weapon.getHeal());
        setHeal(getHeal() + weapon.getHeal());
    }
}
