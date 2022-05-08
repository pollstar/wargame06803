package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.eventhandling.Event;
import ua.pollstar.softserve.eventhandling.EventsType;

public class Dragon extends Lancer{
    @Override
    public void attackEnemy(Warrior enemy) {
        int healthEnemyBeforeAttack = enemy.getHealth();
        super.attackEnemy(enemy);
        final int percent = 100;
        int healthEnemyAfterAttack = Math.max(enemy.getHealth(), 0);
        int damage = (healthEnemyBeforeAttack - healthEnemyAfterAttack) * percentNextDamage / percent;
        if (enemy.getArmy() != null){
            enemy.getArmy().handler(new Event(this, EventsType.TAKE_ATTACK_FOR_NEXT, damage));
        }
    }

}
