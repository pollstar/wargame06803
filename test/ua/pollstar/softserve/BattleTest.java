package ua.pollstar.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {
    private Warrior warrior1, warrior2;
    private Knight knight;

    @BeforeEach
    public void initEach(){
        warrior1 = new Warrior();
        warrior2 = new Warrior();
        knight = new Knight();
    }

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
        var result = Battle.fight(warrior1, knight);
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
        var result = Battle.fight(knight, warrior1);

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
        Battle.fight(warrior1, warrior2);
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

        Battle.fight(knight, warrior1);
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
        Battle.fight(warrior1, warrior2);
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
        Battle.fight(warrior1, knight);
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
        Battle.fight(warrior1, knight);
        var result = Battle.fight(knight, warrior2);
        assertFalse(result);
    }
}
