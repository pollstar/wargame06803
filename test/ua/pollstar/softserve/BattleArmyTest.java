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

class BattleArmyTest {
    private Army army1, army2;

    @BeforeEach
    void init() {
        army1 = new Army();
        army2 = new Army();
    }

    private static Stream<Arguments> argumentsBattleTwoArms() {
        return Stream.of(
                Arguments.of(Warrior.class, 1, Warrior.class, 2, false),
                Arguments.of(Warrior.class, 2, Warrior.class, 3, false),
                Arguments.of(Warrior.class, 5, Warrior.class, 7, false),
                Arguments.of(Warrior.class, 20, Warrior.class, 21, true),
                Arguments.of(Warrior.class, 10, Warrior.class, 11, true),
                Arguments.of(Warrior.class, 11, Warrior.class, 7, true)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsBattleTwoArms")
    void battle1(Class<? extends Warrior> warrior1, int count1, Class<? extends Warrior> warrior2, int count2, boolean test) {
        army1.addUnit(warrior1, count1);
        army2.addUnit(warrior2, count2);
        assertEquals(Battle.fight(army1, army2), test);
    }

    @Test
    @DisplayName("Test7. Battle")
    void battle7() {
        army1.addUnit(Warrior.class, 5);
        army1.addUnit(Defender.class, 4);
        army1.addUnit(Defender.class, 5);
        army2.addUnit(Warrior.class, 4);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test8. Battle")
    void battle8() {
        army1.addUnit(Defender.class, 5);
        army1.addUnit(Warrior.class, 20);
        army2.addUnit(Warrior.class, 21);
        army1.addUnit(Defender.class, 4);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test9. Battle")
    void battle9() {
        army1.addUnit(Warrior.class, 10);
        army1.addUnit(Defender.class, 5);
        army2.addUnit(Warrior.class, 5);
        army1.addUnit(Defender.class, 10);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test10. Battle")
    void battle10() {
        army1.addUnit(Defender.class, 2);
        army1.addUnit(Warrior.class, 1);
        army1.addUnit(Defender.class, 1);
        army2.addUnit(Warrior.class, 5);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test11. Battle")
    void battle11() {
        army1.addUnit(Defender.class, 5);
        army1.addUnit(Vampire.class, 6);
        army1.addUnit(Warrior.class, 7);
        army2.addUnit(Warrior.class, 6);
        army2.addUnit(Defender.class, 6);
        army2.addUnit(Vampire.class, 6);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test12. Battle")
    void battle12() {
        army1.addUnit(Defender.class, 2);
        army1.addUnit(Vampire.class, 3);
        army1.addUnit(Warrior.class, 4);
        army2.addUnit(Warrior.class, 4);
        army2.addUnit(Defender.class, 3);
        army2.addUnit(Vampire.class, 3);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test13. Battle")
    void battle13() {
        army1.addUnit(Defender.class, 11);
        army1.addUnit(Vampire.class, 3);
        army1.addUnit(Warrior.class, 4);
        army2.addUnit(Warrior.class, 4);
        army2.addUnit(Defender.class, 4);
        army2.addUnit(Vampire.class, 13);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test14. Battle")
    void battle14() {
        army1.addUnit(Defender.class, 9);
        army1.addUnit(Vampire.class, 3);
        army1.addUnit(Warrior.class, 8);
        army2.addUnit(Warrior.class, 4);
        army2.addUnit(Defender.class, 4);
        army2.addUnit(Vampire.class, 13);
        assertTrue(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test15_0. Battle")
    void battle15_0() {
        army1.addUnit(Lancer.class, 1);
        army2.addUnit(Warrior.class, 1);
        army2.addUnit(Knight.class, 1);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test15. Battle")
    void battle15() {
        /**
         * army_1.add_units(Lancer, 5)
         * army_1.add_units(Vampire, 3)
         * army_1.add_units(Warrior, 4)
         * army_1.add_units(Defender, 2)
         * army_2.add_units(Warrior, 4)
         * army_2.add_units(Defender, 4)
         * army_2.add_units(Vampire, 6)
         * army_2.add_units(Lancer, 5)
         */
        army1.addUnit(Lancer.class, 5);
        army1.addUnit(Vampire.class, 3);
        army1.addUnit(Warrior.class, 4);
        army1.addUnit(Defender.class, 2);
        army2.addUnit(Warrior.class, 4);
        army2.addUnit(Defender.class, 4);
        army2.addUnit(Vampire.class, 6);
        army2.addUnit(Lancer.class, 5);
        assertFalse(Battle.fight(army1, army2));
    }

    @Test
    @DisplayName("Test16. Battle")
    void battle16() {
        /**
         * army_1.add_units(Lancer, 7)
         * army_1.add_units(Vampire, 3)
         * army_1.add_units(Warrior, 4)
         * army_1.add_units(Defender, 2)
         * army_2.add_units(Warrior, 4)
         * army_2.add_units(Defender, 4)
         * army_2.add_units(Vampire, 6)
         * army_2.add_units(Lancer, 4)
         */
        army1.addUnit(Lancer.class, 7);
        army1.addUnit(Vampire.class, 3);
        army1.addUnit(Warrior.class, 4);
        army1.addUnit(Defender.class, 2);
        army2.addUnit(Warrior.class, 4);
        army2.addUnit(Defender.class, 4);
        army2.addUnit(Vampire.class, 6);
        army2.addUnit(Lancer.class, 4);
        assertTrue(Battle.fight(army1, army2));
    }
}
