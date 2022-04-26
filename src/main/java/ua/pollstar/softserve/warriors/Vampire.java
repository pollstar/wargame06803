package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.weapons.Weapon;

public class Vampire extends Warrior {
    private int maxVampirism;
    private int vampirism;

    public Vampire() {
        setMaxVampirism(ParametersWarrior.getParameter(this.getClass(),
                ParametersWarrior.Parameter.VAMPIRISM));
        setVampirism(getMaxVampirism());
    }

    private void setVampirism(int vampirism) {
        this.vampirism = Math.max(0, Math.min(vampirism, getMaxVampirism()));
    }

    public int getVampirism() {
        return vampirism;
    }

    public int getMaxVampirism() {
        return maxVampirism;
    }

    public void setMaxVampirism(int maxVampirism) {
        this.maxVampirism = Math.max(maxVampirism, 0);
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        int healthEnemyBeforeAttack = enemy.getHealth();
        enemy.takeDamage(getAttack());
        final int percent = 100;
        setHealth(getHealth() + (healthEnemyBeforeAttack - enemy.getHealth()) * getVampirism()
                / percent);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setMaxVampirism(getMaxVampirism() + weapon.getVampirism());
        setVampirism(getVampirism() + weapon.getVampirism());
    }
}
