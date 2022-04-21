package ua.pollstar.softserve.warriors;

public class Lancer extends Warrior {
    private int percentNextDamage;

    public Lancer() {
        this.percentNextDamage = ParametersWarrior.getParameter(this.getClass(),
                ParametersWarrior.Parameter.NEXT_DAMAGE);
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        int healthEnemyBeforeAttack = enemy.getHealth();
        enemy.takeDamage(getAttack());
        final int percent = 100;
        int damage = (healthEnemyBeforeAttack - enemy.getHealth()) * percentNextDamage / percent;
        if (enemy.getArmy() != null){
            enemy.getArmy().takeDamageForNext(enemy, damage);
        }
    }
}
