package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.Army;
import ua.pollstar.softserve.eventhandling.Event;
import ua.pollstar.softserve.eventhandling.EventsType;

public class Dragon extends Lancer{
    @Override
    public void attackEnemy(Warrior enemy) {
        attackEnemyInStraightFight(enemy);
    }


    public void attackEnemyInStraightFight(Warrior enemy) {
        if (enemy == null) {
            return;
        }
        Army enemyArmy = enemy.getArmy();
        if (enemyArmy == null) {
            enemy.handler(new Event(this, EventsType.TAKE_ATTACK, getAttack()));
            return;
        }
        enemyArmy.handler(new Event(this, EventsType.TAKE_FIRE_ATTACK, getAttack()));
    }


    protected String getDataForPrintString() {
        return  super.getDataForPrintString() +
                ", percentNextDamage=" + getPercentNextDamage();
    }

}
