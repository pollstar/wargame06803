package ua.pollstar.softserve;

import ua.pollstar.softserve.warriors.Warrior;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Battle {
    private static Logger log = Logger.getLogger(Battle.class.getName());

    

    public static boolean fight(Army army1, Army army2) {
        log.info("-------Fight between army1 and army2-------------- " );
        while (army1.isAlive() && army2.isAlive()) {
            log.log(Level.INFO,"army1 before move units: \n   {0}", army1);
            log.log(Level.INFO,"army2 before move units: \n   {0}", army2);
            log.log(Level.INFO,"army1 after move units: \n   {0}", army1);
            log.log(Level.INFO,"army2 after move units: \n   {0}", army2);
            fight(army1.getWarrior(), army2.getWarrior());
        }
        log.info("-------End fight. Army1 is alive = " + army1.isAlive() + "Army2 is alive = " + army2.isAlive());
        return army1.isAlive();
    }

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        log.log(Level.INFO,"-------Fight between "
                        + warrior1.getClass().getSimpleName()
                        + " and "
                        + warrior2.getClass().getSimpleName()
                        + " -------------- ");
        while (warrior1.isAlive()) {
            warrior1.attackEnemy(warrior2);
            if (warrior2.isAlive()) {
                warrior2.attackEnemy(warrior1);
            }
            if (!warrior2.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public static boolean straightFight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive()) {
            warrior1.attackEnemyInStraightFight(warrior2);
            if (warrior2.isAlive()) {
                warrior2.attackEnemyInStraightFight(warrior1);
            }
            if (!warrior2.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public static boolean straightFight(Army army1, Army army2) {
        while (army1.isAlive() && army2.isAlive()) {
            Iterator<Warrior> it1 = army1.iterator();
            Iterator<Warrior> it2 = army2.iterator();
            while (it1.hasNext() && it2.hasNext()) {
                straightFight(it1.next(), it2.next());
            }
        }
        return army1.isAlive();
    }
}