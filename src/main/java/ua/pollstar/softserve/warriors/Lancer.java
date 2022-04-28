package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.eventhandling.Event;
import ua.pollstar.softserve.eventhandling.EventsType;

public class Lancer extends Warrior {
    private int percentNextDamage;

    public Lancer() {
        this.percentNextDamage = ParametersWarrior.getParameter(this.getClass(),
                ParametersWarrior.Parameter.NEXT_DAMAGE);
    }

    @Override
    public void attackEnemy(Warrior enemy) {
        int healthEnemyBeforeAttack = enemy.getHealth();
        super.attackEnemy(enemy);
        final int percent = 100;
        int damage = (healthEnemyBeforeAttack - enemy.getHealth()) * percentNextDamage / percent;
        if (enemy.getArmy() != null){
            enemy.handler(new Event(this, EventsType.TAKE_ATTACK_FOR_NEXT, damage));
        }
    }
}
