package ua.pollstar.softserve;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {

    @Test
    @DisplayName("test fight betwen Warrior and Warrior")
    void fight001 () {
        /*
        chuck = Warrior()
        bruce = Warrior()
        fight(chuck, bruce) == True
        chuck.is_alive == True
        bruce.is_alive == False
         */
        var chuck = new Warrior();
        var bruce = new Warrior();

        var result = Battle.fight(chuck, bruce);

        assertTrue(result);
        assertTrue(chuck.isAlive);
        assertFalse(bruce.isAlive);
    }

    @Test
    @DisplayName("test fight betwen Knight and Warrior")
    void fight002 () {
        /*
        carl = Knight()
        dave = Warrior()

        fight(dave, carl) == False
        carl.is_alive == True
        dave.is_alive == False
        */
        var carl = new Knight();
        var dave = new Warrior();

        var result = Battle.fight(dave, carl);

        assertFalse(result);
        assertTrue(carl.isAlive);
        assertFalse(dave.isAlive);
    }

    @Test
    @DisplayName("test fight betwen Warrior and Knight")
    void fight1 () {
        /*
         *     "1. Fight": [
         *         prepare_test(middle_code='''carl = Warrior()
         * jim = Knight()''',
         *                      test="fight(carl, jim)",
         *                      answer=False)
         *                 ],
        */
        var carl = new Warrior();
        var jim = new Knight();

        var result = Battle.fight(carl, jim);

        assertFalse(result);
    }

    @Test
    @DisplayName("test fight betwen Knight and Warrior")
    void fight2 () {
        /*
         *     "2. Fight": [
         *         prepare_test(middle_code='''ramon = Knight()
         * slevin = Warrior()''',
         *                      test="fight(ramon, slevin)",
         *                      answer=True)
         *                 ],
         */
        var ramon = new Knight();
        var slevin = new Warrior();

        var result = Battle.fight(ramon, slevin);

        assertTrue(result);
    }

    @Test
    @DisplayName("test fight betwen Warrior isAlive and Warrior")
    void fight3 () {
        /*
         *     "3. Fight": [
         *         prepare_test(middle_code='''bob = Warrior()
         * mars = Warrior()
         * fight(bob, mars)''',
         *                      test="bob.is_alive",
         *                      answer=True)
         *                 ],
         */
        var bob = new Warrior();
        var mars = new Warrior();

        var result = Battle.fight(bob, mars);

        assertTrue(bob.isAlive);
    }

    @Test
    @DisplayName("test fight betwen Knight isAlive and Warrior")
    void fight4 () {
        /*
         *     "4. Fight": [
         *         prepare_test(middle_code='''zeus = Knight()
         * godkiller = Warrior()
         * fight(zeus, godkiller)''',
         *                      test="zeus.is_alive",
         *                      answer=True)
         *                 ],
         */
        var zeus = new Knight();
        var godkiller = new Warrior();

        var result = Battle.fight(zeus, godkiller);

        assertTrue(zeus.isAlive);
    }

    @Test
    @DisplayName("test fight betwen Warrior and Warrior is not Alive")
    void fight5 () {
        /*
         *     "5. Fight": [
         *         prepare_test(middle_code='''husband = Warrior()
         * wife = Warrior()
         * fight(husband, wife)''',
         *                      test="wife.is_alive",
         *                      answer=False)
         *                 ],
         */
        var husband = new Warrior();
        var wife = new Warrior();

        var result = Battle.fight(husband, wife);

        assertFalse(wife.isAlive);
    }

    @Test
    @DisplayName("test fight betwen Warrior and Knight isAlive")
    void fight6 () {
        /*
         *     "6. Fight": [
         *         prepare_test(middle_code='''dragon = Warrior()
         * knight = Knight()
         * fight(dragon, knight)''',
         *                      test="knight.is_alive",
         *                      answer=True)
         *                 ],
         */
        var dragon = new Warrior();
        var knight = new Knight();

        var result = Battle.fight(dragon, knight);

        assertTrue(knight.isAlive);
    }

    @Test
    @DisplayName("test fight betwen Warrior - Knight and Knight - Warrior")
    void fight7 () {
        /*
         *     "7. Fight": [
         *         prepare_test(middle_code='''unit_1 = Warrior()
         * unit_2 = Knight()
         * unit_3 = Warrior()
         * fight(unit_1, unit_2)''',
         *                      test="fight(unit_2, unit_3)",
         *                      answer=False)
         *                 ]
         */
        var unit_1 = new Warrior();
        var unit_2 = new Knight();
        var unit_3 = new Warrior();

        Battle.fight(unit_1, unit_2);
        var result = Battle.fight(unit_2, unit_3);

        assertFalse(result);
    }
}
