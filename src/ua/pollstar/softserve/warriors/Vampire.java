package ua.pollstar.softserve.warriors;

public class Vampire extends Warrior {
    private int vampirism;

    Vampire() {
        setHealth(40);
        setAttack(4);
        setVampirism(50);
    }

    private void setVampirism(int i) {
        this.vampirism = i;
    }

    private int getVampirism() {
        return vampirism;
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        int healthEnemyBeforeAttack = enemy.getHealth();
        enemy.takeDamage(getAttack());
        final int percent = 100;
        setHealth(getHealth() + (healthEnemyBeforeAttack - enemy.getHealth()) * getVampirism() / percent);
    }
}
