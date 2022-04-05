package ua.pollstar.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    private Warrior warrior1, warrior2;
    private Knight knight;
    private Army army1, army2;

    @Test
    @DisplayName("test fight betwen Warrior and Knight")
    void fight1 () {
        /*
         *     "1. Fight": [
         * carl = Warrior()
         * jim = Knight()''',
         *                      test="fight(carl, jim)",
         *                      answer=False)
        */
        warrior1 = new Warrior();
        knight = new Knight();

        var result = Battle.fightWarriors(warrior1, knight);
        assertFalse(result);
    }

    @Test
    @DisplayName("test fight betwen Knight and Warrior")
    void fight2 () {
        /*
         *     "2. Fight": [
         * ramon = Knight()
         * slevin = Warrior()''',
         *                      test="fight(ramon, slevin)",
         *                      answer=True)
         */
        warrior1 = new Warrior();
        knight = new Knight();

        var result = Battle.fightWarriors(knight, warrior1);

        assertTrue(result);
    }

    @Test
    @DisplayName("test fight betwen Warrior isAlive and Warrior")
    void fight3 () {
        /*
         *     "3. Fight": [
         * bob = Warrior()
         * mars = Warrior()
         * fight(bob, mars)''',
         *                      test="bob.is_alive",
         *                      answer=True)
         */
        warrior1 = new Warrior();
        warrior2 = new Warrior();

        Battle.fightWarriors(warrior1, warrior2);
        assertTrue(warrior1.getAlive());
    }

    @Test
    @DisplayName("test fight betwen Knight isAlive and Warrior")
    void fight4 () {
        /*
         *     "4. Fight": [
         * zeus = Knight()
         * godkiller = Warrior()
         * fight(zeus, godkiller)''',
         *                      test="zeus.is_alive",
         *                      answer=True)
         */

        warrior1 = new Warrior();
        knight = new Knight();

        Battle.fightWarriors(knight, warrior1);
        assertTrue(knight.getAlive());
    }

    @Test
    @DisplayName("test fight betwen Warrior and Warrior is not Alive")
    void fight5 () {
        /*
         *     "5. Fight": [
         * husband = Warrior()
         * wife = Warrior()
         * fight(husband, wife)''',
         *                      test="wife.is_alive",
         *                      answer=False)
         */
        warrior1 = new Warrior();
        warrior2 = new Warrior();

        Battle.fightWarriors(warrior1, warrior2);
        assertFalse(warrior2.getAlive());
    }

    @Test
    @DisplayName("test fight betwen Warrior and Knight isAlive")
    void fight6 () {
        /*
         *     "6. Fight": [
         * dragon = Warrior()
         * knight = Knight()
         * fight(dragon, knight)''',
         *                      test="knight.is_alive",
         *                      answer=True)
         */
        warrior1 = new Warrior();
        knight = new Knight();

        Battle.fightWarriors(warrior1, knight);
        assertTrue(knight.getAlive());
    }

    @Test
    @DisplayName("test fight betwen Warrior - Knight and Knight - Warrior")
    void fight7 () {
        /*
         *     "7. Fight": [
         * unit_1 = Warrior()
         * unit_2 = Knight()
         * unit_3 = Warrior()
         * fight(unit_1, unit_2)''',
         *                      test="fight(unit_2, unit_3)",
         *                      answer=False)
         */
        warrior1 = new Warrior();
        warrior2 = new Warrior();
        knight = new Knight();

        Battle.fightWarriors(warrior1, knight);
        var result = Battle.fightWarriors(knight, warrior2);
        assertFalse(result);
    }

    @Test
    @DisplayName("Test1. Army")
    void battle1() {
        /**
         * army_1.add_units(Warrior, 1)
         * army_2.add_units(Warrior, 2)
         * battle = Battle()''',
         *                      test="battle.fight(army_1, army_2)",
         *                      answer=False)
         */
        army1 = new Army();
        army2 = new Army();

        army1.addUnit(TypeWarrior.WARRIOR, 1);
        army2.addUnit(TypeWarrior.WARRIOR, 2);

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
        army1 = new Army();
        army2 = new Army();

        army1.addUnit(TypeWarrior.WARRIOR, 2);
        army2.addUnit(TypeWarrior.WARRIOR, 3);

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
        army1 = new Army();
        army2 = new Army();

        army1.addUnit(TypeWarrior.WARRIOR, 5);
        army2.addUnit(TypeWarrior.WARRIOR, 7);

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
        army1 = new Army();
        army2 = new Army();

        army1.addUnit(TypeWarrior.WARRIOR, 20);
        army2.addUnit(TypeWarrior.WARRIOR, 21);

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
        army1 = new Army();
        army2 = new Army();

        army1.addUnit(TypeWarrior.WARRIOR, 10);
        army2.addUnit(TypeWarrior.WARRIOR, 11);

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
        army1 = new Army();
        army2 = new Army();

        army1.addUnit(TypeWarrior.WARRIOR, 11);
        army2.addUnit(TypeWarrior.WARRIOR, 7);

        assertTrue(Battle.fight(army1, army2));
    }
}
