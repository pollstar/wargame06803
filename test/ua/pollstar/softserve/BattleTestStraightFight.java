package ua.pollstar.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import teststatic.A;
import ua.pollstar.softserve.warriors.*;

import static org.junit.jupiter.api.Assertions.*;

class BattleTestStraightFight {
    private Army army1, army2;

    @BeforeEach
    void init() {
        army1 = new Army();
        army2 = new Army();
    }

    @Test
    void straight_fight1() {
        army1.addUnit(Warrior.class, 2);
        army2.addUnit(Warrior.class, 2);

        var result = Battle.straight_fight(army1, army2);
        assertTrue(result);
    }

    @Test
    void straight_fight2() {
        army1.addUnit(Vampire.class, 3);
        army2.addUnit(Warrior.class, 2);
        army2.addUnit(Knight.class, 1);

        var result = Battle.straight_fight(army1, army2);
        assertFalse(result);
    }

    @Test
    void straight_fight3() {
        army1.addUnit(Vampire.class, 4);
        army2.addUnit(Warrior.class, 2);
        army2.addUnit(Knight.class, 1);

        var result = Battle.straight_fight(army1, army2);
        assertTrue(result);
    }

    @Test
    void straight_fight4() {
        army1.addUnit(Vampire.class, 4);
        army2.addUnit(Healer.class, 1);
        army2.addUnit(Warrior.class, 2);

        var result = Battle.straight_fight(army1, army2);
        assertTrue(result);
    }

    @Test
    void straight_fight5() {
        army1.addUnit(Vampire.class, 4);
        army2.addUnit(Lancer.class, 1);
        army2.addUnit(Warrior.class, 2);

        var result = Battle.straight_fight(army1, army2);
        assertTrue(result);
    }
}