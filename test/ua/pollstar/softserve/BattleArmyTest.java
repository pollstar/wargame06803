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
        Arguments[] arg = {
                Arguments.of(Warrior.class, 1, Warrior.class, 2, false),
                Arguments.of(Warrior.class, 2, Warrior.class, 3, false),
                Arguments.of(Warrior.class, 5, Warrior.class, 7, false),
                Arguments.of(Warrior.class, 20, Warrior.class, 21, true),
                Arguments.of(Warrior.class, 10, Warrior.class, 11, true),
                Arguments.of(Warrior.class, 11, Warrior.class, 7, true),
                Arguments.of(Knight.class, 1, Warrior.class, 2, false),
                Arguments.of(Knight.class, 2, Warrior.class, 3, false),
                Arguments.of(Knight.class, 5, Warrior.class, 7, true),
                Arguments.of(Knight.class, 20, Warrior.class, 21, true),
                Arguments.of(Knight.class, 10, Warrior.class, 11, true),
                Arguments.of(Knight.class, 11, Warrior.class, 7, true),
                Arguments.of(Defender.class, 1, Warrior.class, 2, false),
                Arguments.of(Defender.class, 2, Warrior.class, 3, false),
                Arguments.of(Defender.class, 5, Warrior.class, 7, false),
                Arguments.of(Defender.class, 20, Warrior.class, 21, true),
                Arguments.of(Defender.class, 10, Warrior.class, 11, true),
                Arguments.of(Defender.class, 11, Warrior.class, 7, true),
                Arguments.of(Vampire.class, 1, Warrior.class, 2, false),
                Arguments.of(Vampire.class, 2, Warrior.class, 3, false),
                Arguments.of(Vampire.class, 5, Warrior.class, 7, false),
                Arguments.of(Vampire.class, 20, Warrior.class, 21, true),
                Arguments.of(Vampire.class, 10, Warrior.class, 11, true),
                Arguments.of(Vampire.class, 11, Warrior.class, 7, true),
                Arguments.of(Lancer.class, 1, Warrior.class, 2, false),
                Arguments.of(Lancer.class, 2, Warrior.class, 3, true),
                Arguments.of(Lancer.class, 5, Warrior.class, 7, true),
                Arguments.of(Lancer.class, 20, Warrior.class, 21, true),
                Arguments.of(Lancer.class, 10, Warrior.class, 11, true),
                Arguments.of(Lancer.class, 11, Warrior.class, 7, true),

                Arguments.of(Warrior.class, 1, Knight.class, 2, false),
                Arguments.of(Warrior.class, 2, Knight.class, 3, false),
                Arguments.of(Warrior.class, 5, Knight.class, 7, false),
                Arguments.of(Warrior.class, 20, Knight.class, 21, false),
                Arguments.of(Warrior.class, 10, Knight.class, 11, false),
                Arguments.of(Warrior.class, 11, Knight.class, 7, true),
                Arguments.of(Knight.class, 1, Knight.class, 2, false),
                Arguments.of(Knight.class, 2, Knight.class, 3, false),
                Arguments.of(Knight.class, 5, Knight.class, 7, false),
                Arguments.of(Knight.class, 20, Knight.class, 21, true),
                Arguments.of(Knight.class, 10, Knight.class, 11, true),
                Arguments.of(Knight.class, 11, Knight.class, 7, true),
                Arguments.of(Defender.class, 1, Knight.class, 2, false),
                Arguments.of(Defender.class, 2, Knight.class, 3, false),
                Arguments.of(Defender.class, 5, Knight.class, 7, false),
                Arguments.of(Defender.class, 20, Knight.class, 21, false),
                Arguments.of(Defender.class, 10, Knight.class, 11, false),
                Arguments.of(Defender.class, 11, Knight.class, 7, true),
                Arguments.of(Vampire.class, 1, Knight.class, 2, false),
                Arguments.of(Vampire.class, 2, Knight.class, 3, false),
                Arguments.of(Vampire.class, 5, Knight.class, 7, false),
                Arguments.of(Vampire.class, 20, Knight.class, 21, false),
                Arguments.of(Vampire.class, 10, Knight.class, 11, false),
                Arguments.of(Vampire.class, 11, Knight.class, 7, true),
                Arguments.of(Lancer.class, 1, Knight.class, 2, false),
                Arguments.of(Lancer.class, 2, Knight.class, 3, false),
                Arguments.of(Lancer.class, 5, Knight.class, 7, true),
                Arguments.of(Lancer.class, 20, Knight.class, 21, true),
                Arguments.of(Lancer.class, 10, Knight.class, 11, true),
                Arguments.of(Lancer.class, 11, Knight.class, 7, true),

                Arguments.of(Warrior.class, 1, Defender.class, 2, false),
                Arguments.of(Warrior.class, 2, Defender.class, 3, false),
                Arguments.of(Warrior.class, 5, Defender.class, 7, false),
                Arguments.of(Warrior.class, 20, Defender.class, 21, false),
                Arguments.of(Warrior.class, 10, Defender.class, 11, false),
                Arguments.of(Warrior.class, 11, Defender.class, 7, true),
                Arguments.of(Knight.class, 1, Defender.class, 2, false),
                Arguments.of(Knight.class, 2, Defender.class, 3, true),
                Arguments.of(Knight.class, 5, Defender.class, 7, true),
                Arguments.of(Knight.class, 20, Defender.class, 21, true),
                Arguments.of(Knight.class, 10, Defender.class, 11, true),
                Arguments.of(Knight.class, 11, Defender.class, 7, true),
                Arguments.of(Defender.class, 1, Defender.class, 2, false),
                Arguments.of(Defender.class, 2, Defender.class, 3, false),
                Arguments.of(Defender.class, 5, Defender.class, 7, false),
                Arguments.of(Defender.class, 20, Defender.class, 21, false),
                Arguments.of(Defender.class, 10, Defender.class, 11, false),
                Arguments.of(Defender.class, 11, Defender.class, 7, true),
                Arguments.of(Vampire.class, 1, Defender.class, 2, false),
                Arguments.of(Vampire.class, 2, Defender.class, 3, false),
                Arguments.of(Vampire.class, 5, Defender.class, 7, false),
                Arguments.of(Vampire.class, 20, Defender.class, 21, false),
                Arguments.of(Vampire.class, 10, Defender.class, 11, false),
                Arguments.of(Vampire.class, 11, Defender.class, 7, true),
                Arguments.of(Lancer.class, 1, Defender.class, 2, false),
                Arguments.of(Lancer.class, 2, Defender.class, 3, false),
                Arguments.of(Lancer.class, 5, Defender.class, 7, false),
                Arguments.of(Lancer.class, 20, Defender.class, 21, true),
                Arguments.of(Lancer.class, 10, Defender.class, 11, true),
                Arguments.of(Lancer.class, 11, Defender.class, 7, true),
                
                Arguments.of(Warrior.class, 1, Vampire.class, 2, false),
                Arguments.of(Warrior.class, 2, Vampire.class, 3, false),
                Arguments.of(Warrior.class, 5, Vampire.class, 7, false),
                Arguments.of(Warrior.class, 20, Vampire.class, 21, true),
                Arguments.of(Warrior.class, 10, Vampire.class, 11, false),
                Arguments.of(Warrior.class, 11, Vampire.class, 7, true),
                Arguments.of(Knight.class, 1, Vampire.class, 2, false),
                Arguments.of(Knight.class, 2, Vampire.class, 3, true),
                Arguments.of(Knight.class, 5, Vampire.class, 7, true),
                Arguments.of(Knight.class, 20, Vampire.class, 21, true),
                Arguments.of(Knight.class, 10, Vampire.class, 11, true),
                Arguments.of(Knight.class, 11, Vampire.class, 7, true),
                Arguments.of(Defender.class, 1, Vampire.class, 2, false),
                Arguments.of(Defender.class, 2, Vampire.class, 3, true),
                Arguments.of(Defender.class, 5, Vampire.class, 7, true),
                Arguments.of(Defender.class, 20, Vampire.class, 21, true),
                Arguments.of(Defender.class, 10, Vampire.class, 11, true),
                Arguments.of(Defender.class, 11, Vampire.class, 7, true),
                Arguments.of(Vampire.class, 1, Vampire.class, 2, false),
                Arguments.of(Vampire.class, 2, Vampire.class, 3, false),
                Arguments.of(Vampire.class, 5, Vampire.class, 7, false),
                Arguments.of(Vampire.class, 20, Vampire.class, 21, true),
                Arguments.of(Vampire.class, 10, Vampire.class, 11, true),
                Arguments.of(Vampire.class, 11, Vampire.class, 7, true),
                Arguments.of(Lancer.class, 1, Vampire.class, 2, true),
                Arguments.of(Lancer.class, 2, Vampire.class, 3, true),
                Arguments.of(Lancer.class, 5, Vampire.class, 7, true),
                Arguments.of(Lancer.class, 20, Vampire.class, 21, true),
                Arguments.of(Lancer.class, 10, Vampire.class, 11, true),
                Arguments.of(Lancer.class, 11, Vampire.class, 7, true),

                Arguments.of(Warrior.class, 1, Lancer.class, 2, false),
                Arguments.of(Warrior.class, 2, Lancer.class, 3, false),
                Arguments.of(Warrior.class, 5, Lancer.class, 7, false),
                Arguments.of(Warrior.class, 20, Lancer.class, 21, false),
                Arguments.of(Warrior.class, 10, Lancer.class, 11, false),
                Arguments.of(Warrior.class, 11, Lancer.class, 7, true),
                Arguments.of(Knight.class, 1, Lancer.class, 2, false),
                Arguments.of(Knight.class, 2, Lancer.class, 3, false),
                Arguments.of(Knight.class, 5, Lancer.class, 7, false),
                Arguments.of(Knight.class, 20, Lancer.class, 21, false),
                Arguments.of(Knight.class, 10, Lancer.class, 11, false),
                Arguments.of(Knight.class, 11, Lancer.class, 7, true),
                Arguments.of(Defender.class, 1, Lancer.class, 2, false),
                Arguments.of(Defender.class, 2, Lancer.class, 3, false),
                Arguments.of(Defender.class, 5, Lancer.class, 7, false),
                Arguments.of(Defender.class, 20, Lancer.class, 21, false),
                Arguments.of(Defender.class, 10, Lancer.class, 11, false),
                Arguments.of(Defender.class, 11, Lancer.class, 7, true),
                Arguments.of(Vampire.class, 1, Lancer.class, 2, false),
                Arguments.of(Vampire.class, 2, Lancer.class, 3, false),
                Arguments.of(Vampire.class, 5, Lancer.class, 7, false),
                Arguments.of(Vampire.class, 20, Lancer.class, 21, false),
                Arguments.of(Vampire.class, 10, Lancer.class, 11, false),
                Arguments.of(Vampire.class, 11, Lancer.class, 7, false),
                Arguments.of(Lancer.class, 1, Lancer.class, 2, false),
                Arguments.of(Lancer.class, 2, Lancer.class, 3, false),
                Arguments.of(Lancer.class, 5, Lancer.class, 7, false),
                Arguments.of(Lancer.class, 20, Lancer.class, 21, true),
                Arguments.of(Lancer.class, 10, Lancer.class, 11, true),
                Arguments.of(Lancer.class, 11, Lancer.class, 7, true)
        };
        return Stream.of(arg);
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
        var result = Battle.fight(army1, army2);
        assertFalse(result);
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
        /*
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
        /*
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

    @Test
    @DisplayName("battleLancerVsWarriorWithHealer")
    void battleLancerVsWarriorWithHealer() {
        army1.addUnit(Lancer.class, 1);
        army2.addUnit(Warrior.class, 1);
        army2.addUnit(Healer.class, 1);
        var result = Battle.fight(army1, army2);
            assertTrue(result);
    }

    @Test
    @DisplayName("battleWarriorVsWarrior")
    void battleWarriorVsWarrior() {
        army1.addUnit(Warrior.class, 1);
        army2.addUnit(Warrior.class, 1);
        assertTrue(Battle.fight(army1, army2));
    }


    @Test
    @DisplayName("battleWarriorVsWarrior")
    void battleWarriorVsVampire() {
        army1.addUnit(Warrior.class, 1);
        army2.addUnit(Vampire.class, 1);
        assertTrue(Battle.fight(army1, army2));
//        if (army1.isAlive()) {
//            System.out.println("Warrior in army1 is:" + army1.getWarrior().getClass().getSimpleName());
//            System.out.println("       health: " + army1.getWarrior().getHealth());
//        } else if (army2.isAlive()) {
//            System.out.println("Warrior in army2 is:" + army2.getWarrior().getClass().getSimpleName());
//            System.out.println("       health: " + army2.getWarrior().getHealth());
//        }
    }

}
