package ua.pollstar.softserve.warriors;

public class Vampire extends Warrior {
    private int vampirism;

    Vampire() {
        setVampirism(ParametersWarrior.getParameter(this.getClass(),
                ParametersWarrior.Parameter.VAMPIRISM));
    }

    private void setVampirism(int i) {
        this.vampirism = i;
    }

    protected int getVampirism() {
        return vampirism;
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        int healthEnemyBeforeAttack = enemy.getHealth();
        enemy.takeDamage(getAttack());
        final int percent = 100;
        setHealth(getHealth() + (healthEnemyBeforeAttack - enemy.getHealth()) * getVampirism()
                / percent);
    }
}
