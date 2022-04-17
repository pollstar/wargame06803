package ua.pollstar.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.pollstar.softserve.warriors.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorFightTest {
    private Warrior warrior1, warrior2;
    private Knight knight;
    private Defender defender;

    @BeforeEach
    public void init() {
        warrior1 = new Warrior();
        warrior2 = new Warrior();
        knight = new Knight();
    }

    public class Rookie extends Warrior {
        public Rookie() {
            super();
            setHealth(50);
            setAttack(1);
        }
    }

    private static Stream<Arguments> argumentsFightTwoWarrior() {
        return Stream.of(
                Arguments.of(Warrior.class, Warrior.class, true),
                Arguments.of(Warrior.class, Knight.class, false),
                Arguments.of(Warrior.class, Defender.class, false),
                Arguments.of(Warrior.class, Vampire.class, true),
                Arguments.of(Warrior.class, Lancer.class, false),
                Arguments.of(Knight.class, Warrior.class, true),
                Arguments.of(Knight.class, Knight.class, true),
                Arguments.of(Knight.class, Defender.class, true),
                Arguments.of(Knight.class, Vampire.class, true),
                Arguments.of(Knight.class, Lancer.class, true),
                Arguments.of(Defender.class, Warrior.class, true),
                Arguments.of(Defender.class, Defender.class, true),
                Arguments.of(Defender.class, Knight.class, false),
                Arguments.of(Defender.class, Vampire.class, true),
                Arguments.of(Defender.class, Lancer.class, false),
                Arguments.of(Vampire.class, Warrior.class, true),
                Arguments.of(Vampire.class, Defender.class, false),
                Arguments.of(Vampire.class, Knight.class, false),
                Arguments.of(Vampire.class, Vampire.class, true),
                Arguments.of(Vampire.class, Lancer.class, false),
                Arguments.of(Lancer.class, Warrior.class, true),
                Arguments.of(Lancer.class, Defender.class, true),
                Arguments.of(Lancer.class, Knight.class, false),
                Arguments.of(Lancer.class, Vampire.class, true),
                Arguments.of(Lancer.class, Lancer.class, true)
//                Arguments.of(Rookie.class, Warrior.class, true)
        );
    }


    @ParameterizedTest
    @MethodSource("argumentsFightTwoWarrior")
    void fight(Class<? extends Warrior> warrior1, Class<? extends Warrior> warrior2, boolean test) {
        var result = Battle.fight(WarriorFactory.createWarrior(warrior1),
                WarriorFactory.createWarrior(warrior2));
        assertEquals(result, test);
    }

    @Test
    void fight() {
        var result = Battle.fight(WarriorFactory.createWarrior(Warrior.class),
                WarriorFactory.createWarrior(Lancer.class));
        assertFalse(result);
    }

    @Test
    @DisplayName("test fight between Warrior isAlive and Warrior")
    void fight3() {
        /*
         *     "3. Fight": [
         * bob = Warrior()
         * mars = Warrior()
         * fight(bob, mars)''',
         *                      test="bob.is_alive",
         *                      answer=True)
         */
        Battle.fight(warrior1, warrior2);
        assertTrue(warrior1.isAlive());
    }

    @Test
    @DisplayName("test fight between Knight isAlive and Warrior")
    void fight4() {
        /*
         *     "4. Fight": [
         * zeus = Knight()
         * godkiller = Warrior()
         * fight(zeus, godkiller)''',
         *                      test="zeus.is_alive",
         *                      answer=True)
         */
        Battle.fight(knight, warrior1);
        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("test fight between Warrior and Warrior is not Alive")
    void fight5() {
        /*
         *     "5. Fight": [
         * husband = Warrior()
         * wife = Warrior()
         * fight(husband, wife)''',
         *                      test="wife.is_alive",
         *                      answer=False)
         */
        Battle.fight(warrior1, warrior2);
        assertFalse(warrior2.isAlive());
    }

    @Test
    @DisplayName("test fight between Warrior and Knight isAlive")
    void fight6() {
        /*
         *     "6. Fight": [
         * dragon = Warrior()
         * knight = Knight()
         * fight(dragon, knight)''',
         *                      test="knight.is_alive",
         *                      answer=True)
         */
        Battle.fight(warrior1, knight);
        assertTrue(knight.isAlive());
    }

    @Test
    @DisplayName("test fight between Warrior - Knight and Knight - Warrior")
    void fight7() {
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
