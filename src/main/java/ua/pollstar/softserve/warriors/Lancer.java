package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.eventhandling.Event;
import ua.pollstar.softserve.eventhandling.EventsType;

public class Lancer extends Warrior {
    protected int percentNextDamage;

    public Lancer() {
        this.percentNextDamage = ParametersWarrior.getParameter(this.getClass(),
                ParametersWarrior.Parameter.NEXT_DAMAGE);
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        int healthEnemyBeforeAttack = enemy.getHealth();
        super.attackEnemy(enemy);
        final int percent = 100;
        int healthEnemyAfterAttack = Math.max(enemy.getHealth(), 0);
        int damage = (healthEnemyBeforeAttack - healthEnemyAfterAttack) * getPercentNextDamage() / percent;
        if (enemy.getArmy() != null){
            enemy.getArmy().handler(new Event(this, EventsType.TAKE_ATTACK_FOR_NEXT, damage));
        }
    }

    public int getPercentNextDamage() {
        return percentNextDamage;
    }
}
