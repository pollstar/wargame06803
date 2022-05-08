package ua.pollstar.softserve.warriors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.pollstar.softserve.Army;
import ua.pollstar.softserve.Battle;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {
    Dragon dragon;
    Army armyEnemy;
    Army army;

    @BeforeEach
    void init() {
        dragon = new Dragon();
        army = new Army();
        armyEnemy = new Army();
    }

    @Test
    void addToArmy() {
        army.addUnit(Warrior.class, 3);
        army.addUnit(dragon);
        army.addUnit(Lancer.class,3);

        assertEquals(7, army.size());
        int i = 0;
        for (Warrior w: army) {
            if (i == 3) {
                assertEquals(Dragon.class, w.getClass());
            }
        }
    }

    @Test
    void straightFightWarriorsWithArms() {
        army.addUnit(Warrior.class, 6);
        army.addUnit(dragon);
        army.addUnit(Lancer.class,3);
        System.out.println(army);
        System.out.println(dragon);

        Defender defender = new Defender();
        armyEnemy.addUnit(Warrior.class, 6);
        armyEnemy.addUnit(defender);
        armyEnemy.addUnit(Lancer.class, 3);
        System.out.println(armyEnemy);
        System.out.println(defender);


        System.out.println(Battle.straightFight(dragon, defender));
        System.out.println(dragon);
        for (Warrior w: armyEnemy) {
            System.out.println(w);
        }
    }


    @Test
    void straightFightArms() {
        army.addUnit(Warrior.class, 6);
        army.addUnit(new Defender());
        army.addUnit(Lancer.class,3);
        System.out.println(army);
        System.out.println(dragon);

        Defender defender = new Defender();
        armyEnemy.addUnit(Warrior.class, 6);
        armyEnemy.addUnit(defender);
        armyEnemy.addUnit(Lancer.class, 3);
        System.out.println(armyEnemy);
        System.out.println(defender);


        System.out.println(Battle.fight(armyEnemy, army));
        System.out.println(dragon);
        System.out.println(defender);

        System.out.println(army);
        for (Warrior w: army) {
            System.out.println(w);
        }
        System.out.println(armyEnemy);
        for (Warrior w: armyEnemy) {
            System.out.println(w);
        }
    }


    @Test
    void fightArms() {
        army.addUnit(dragon);
        army.addUnit(Warrior.class, 6);
        army.addUnit(Lancer.class,3);
        System.out.println(army);
        System.out.println(dragon);

        Defender defender = new Defender();
        Warrior warrior = new Warrior();
//        armyEnemy.addUnit(defender);
        armyEnemy.addUnit(warrior);
        armyEnemy.addUnit(Warrior.class, 6);
        armyEnemy.addUnit(Lancer.class, 3);
        System.out.println(armyEnemy);
        System.out.println(defender);


        System.out.println(Battle.fight(dragon, warrior));
        System.out.println(dragon);
        for (Warrior w: armyEnemy) {
            System.out.println(w);
        }
    }

    private Army createArmyEnemy() {
        return new Army();
    }

}