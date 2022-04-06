package ua.pollstar.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorFightTestParameterezed {
    private Warrior warrior, warrior2;
    private Knight knight;

    @BeforeEach
    void init () {
        warrior = new Warrior();
        warrior2 = new Warrior();
        knight = new Knight();
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(new Warrior(), new Knight(), false),
                Arguments.of(new Knight(), new Warrior(), true)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
     public void fight(Warrior w1, Warrior w2, boolean test) {
        /*
         *     "1. Fight": [
         * carl = Warrior()
         * jim = Knight()''',
         *                      test="fight(carl, jim)",
         *                      answer=False)
        */
        var result = Battle.fight(w1, w2);
        assertEquals(result, test);
    }

    @Test
    @DisplayName("test fight between Warrior isAlive and Warrior")
    void fight3 () {
        /*
         *     "3. Fight": [
         * bob = Warrior()
         * mars = Warrior()
         * fight(bob, mars)''',
         *                      test="bob.is_alive",
         *                      answer=True)
         */
        Battle.fight(warrior, warrior2);
        assertTrue(warrior.isAlive());
    }

    @Test
    @DisplayName("test fight between Knight isAlive and Warrior")
    void fight4 () {
        /*
         *     "4. Fight": [
         * zeus = Knight()
         * godkiller = Warrior()
         * fight(zeus, godkiller)''',
         *                      test="zeus.is_alive",
         *                      answer=True)
         */
        Battle.fight(knight, warrior);
        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("test fight between Warrior and Warrior is not Alive")
    void fight5 () {
        /*
         *     "5. Fight": [
         * husband = Warrior()
         * wife = Warrior()
         * fight(husband, wife)''',
         *                      test="wife.is_alive",
         *                      answer=False)
         */
        Battle.fight(warrior, warrior2);
        assertFalse(warrior2.isAlive());
    }

    @Test
    @DisplayName("test fight between Warrior and Knight isAlive")
    void fight6 () {
        /*
         *     "6. Fight": [
         * dragon = Warrior()
         * knight = Knight()
         * fight(dragon, knight)''',
         *                      test="knight.is_alive",
         *                      answer=True)
         */
        Battle.fight(warrior, knight);
        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("test fight between Warrior - Knight and Knight - Warrior")
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
        warrior2 = new Warrior();
        Battle.fight(warrior, knight);
        var result = Battle.fight(knight, warrior2);
        assertFalse(result);
    }
}
