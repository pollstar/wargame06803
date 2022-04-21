package ua.pollstar.softserve.warriors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorsTest {

    private static Stream<Arguments> getWarriors() {
        return Stream.of(
                Arguments.of(new Warrior()),
                Arguments.of(new Knight()),
                Arguments.of(new Defender()),
                Arguments.of(new Vampire()),
                Arguments.of(new Lancer()),
                Arguments.of(new Healer())
        );
    }

    @ParameterizedTest
    @MethodSource("getWarriors")
    void test_getAttack(Warrior warrior) {
        assertEquals(warrior.getAttack(), ParametersWarrior.getParameter(warrior, ParametersWarrior.Parameter.ATTACK));
    }

    @ParameterizedTest
    @MethodSource("getWarriors")
    void test_setAttack(Warrior warrior) {
        var a = -1;
        warrior.setAttack(a);
        assertEquals(0, warrior.getAttack());
        a = 0;
        warrior.setAttack(a);
        assertEquals(0, warrior.getAttack());
        a = ParametersWarrior.getParameter(warrior, (ParametersWarrior.Parameter.ATTACK));
        warrior.setAttack(a);
        assertEquals(a, warrior.getAttack());
        a = ParametersWarrior.getParameter(warrior, (ParametersWarrior.Parameter.ATTACK)) + 1;
        warrior.setAttack(a);
        assertEquals(ParametersWarrior.getParameter(warrior, ParametersWarrior.Parameter.ATTACK), warrior.getAttack());
    }

    @ParameterizedTest
    @MethodSource("getWarriors")
    void test_getHealth(Warrior warrior) {
        assertEquals(warrior.getHealth(), ParametersWarrior.getParameter(warrior,
                ParametersWarrior.Parameter.HEALTH));
    }

    @ParameterizedTest
    @MethodSource("getWarriors")
    void test_setHealth(Warrior warrior) {
        var a = -1;
        warrior.setHealth(a);
        assertEquals(a, warrior.getHealth());
        a = 0;
        warrior.setHealth(a);
        assertEquals(a, warrior.getHealth());
        a = ParametersWarrior.getParameter(warrior, (ParametersWarrior.Parameter.HEALTH));
        warrior.setHealth(a);
        assertEquals(a, warrior.getHealth());
        a += 1;
        warrior.setHealth(a);
        assertEquals(ParametersWarrior.getParameter(warrior, ParametersWarrior.Parameter.HEALTH), warrior.getHealth());
    }

    @ParameterizedTest
    @MethodSource("getWarriors")
    void test_isAlive(Warrior warrior) {
        assertTrue(warrior.isAlive());
        warrior.setHealth(0);
        assertFalse(warrior.isAlive());
        warrior.setHealth(-1);
        assertFalse(warrior.isAlive());
        warrior.setHealth(10);
        assertTrue(warrior.isAlive());
        warrior.setHealth(ParametersWarrior.getParameter(warrior,
                ParametersWarrior.Parameter.HEALTH));
        assertTrue(warrior.isAlive());
    }

    @ParameterizedTest
    @MethodSource("getWarriors")
    void test_attackEnemy(Warrior warrior) {
        Warrior warrior1 = new Warrior();
        var oldHealth = warrior1.getHealth();
        warrior.attackEnemy(warrior1);
        assertEquals(warrior1.getHealth(), oldHealth - warrior.getAttack());
    }

    @Test
    void test_attackEnemy_null() {
        Warrior warrior = new Warrior();
        warrior.attackEnemy(null);
    }

    @ParameterizedTest
    @MethodSource("getWarriors")
    void test_takeDamage(Warrior warrior) {
        var damage = new int[]{-2, -1, 0, 1, 2, 3};
        for (var i: damage) {
            var oldHealth = warrior.getHealth();
            warrior.takeDamage(i);
            if (i < 0) {
                assertEquals(oldHealth, warrior.getHealth());
            } else if (!warrior.getClass().equals(Defender.class)){
                assertEquals(oldHealth - i, warrior.getHealth());
            }
        }
    }
}