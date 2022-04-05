package ua.pollstar.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleArmyTest {
    private Army army1, army2;

    @BeforeEach
    void init() {
        army1 = new Army();
        army2 = new Army();
    }

    @Test
    @DisplayName("Test1. Army")
    void    battle1() {
        /**
         * army_1.add_units(Warrior, 1)
         * army_2.add_units(Warrior, 2)
         * battle = Battle()''',
         *                      test="battle.fight(army_1, army_2)",
         *                      answer=False)
         */
        army1.addUnit(Warrior.class, 1);
        army2.addUnit(Warrior.class, 2);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test2. Army")
    void battle2() {
        /**
         army_1.add_units(Warrior, 2)
         army_2.add_units(Warrior, 3)
         battle = Battle()''',
         test="battle.fight(army_1, army_2)",
         answer=False)
         */
        army1.addUnit(Warrior.class, 2);
        army2.addUnit(Warrior.class, 3);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test3. Army")
    void battle3() {
        /**
         army_1.add_units(Warrior, 5)
         army_2.add_units(Warrior, 7)
         battle = Battle()''',
         test="battle.fight(army_1, army_2)",
         answer=False)
         */
        army1.addUnit(Warrior.class, 5);
        army2.addUnit(Warrior.class, 7);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test4. Army")
    void battle4() {
        /**
         army_1.add_units(Warrior, 20)
         army_2.add_units(Warrior, 21)
         battle = Battle()''',
         test="battle.fight(army_1, army_2)",
         answer=True)
         */
        army1.addUnit(Warrior.class, 20);
        army2.addUnit(Warrior.class, 21);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test5. Army")
    void battle5() {
        /**
         army_1.add_units(Warrior, 10)
         army_2.add_units(Warrior, 11)
         battle = Battle()''',
         test="battle.fight(army_1, army_2)",
         answer=True)
         */
        army1.addUnit(Warrior.class, 10);
        army2.addUnit(Warrior.class, 11);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test6. Army")
    void battle6() {
        /**
         army_1.add_units(Warrior, 11)
         army_2.add_units(Warrior, 7)
         battle = Battle()''',
         test="battle.fight(army_1, army_2)",
         answer=True)
         */
        army1.addUnit(Warrior.Type.WARRIOR, 11);
        army2.addUnit(Warrior.Type.WARRIOR, 7);
        assertTrue(Battle.fight(army1, army2));
    }
}
