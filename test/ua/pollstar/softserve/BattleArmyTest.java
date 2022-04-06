package ua.pollstar.softserve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
}
