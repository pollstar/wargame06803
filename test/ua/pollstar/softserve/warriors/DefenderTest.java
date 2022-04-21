package ua.pollstar.softserve.warriors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefenderTest {
    private Defender defender;

    @BeforeEach
    void init() {
        defender = new Defender();
    }

    @Test
    @DisplayName("Defender, test takeDamage with full health")
    void test_takeDamage() {
        var damages = new int[]{0, 1, 2, 4, 8, 20, 100};
        for (var i : damages) {
            defender = new Defender();
            var oldHealth = defender.getHealth();
            defender.takeDamage(i);
            var shouldBeHealth =  i <= defender.getDefense()? oldHealth: oldHealth - i + defender.getDefense();
            assertEquals(shouldBeHealth, defender.getHealth());
        }
    }

    @Test
    @DisplayName("Defender, test takeDamage with not full health")
    void test_takeDamage2() {
        var damages = new int[]{0, 1, 2, 4, 8, 20, 100};
        defender.takeDamage(defender.getDefense() + 5);
        for (var i : damages) {
            defender = new Defender();
            var oldHealth = defender.getHealth();
            defender.takeDamage(i);
            var shouldBeHealth =  i <= defender.getDefense()? oldHealth: oldHealth - i + defender.getDefense();
            assertEquals(shouldBeHealth, defender.getHealth());
        }
    }

    @Test
    @DisplayName("Defender, test takeDamage for negative values")
    void test_takeDamage_negative() {
        var damages = new int[]{-4, -8, -20, -100};
        for (var i : damages) {
            defender = new Defender();
            var oldHealth = defender.getHealth();
            defender.takeDamage(i);
            var shouldBeHealth =  i <= defender.getDefense()? oldHealth: oldHealth - i + defender.getDefense();
            assertEquals(shouldBeHealth, defender.getHealth());
        }
    }

    @Test
    @DisplayName("Defender, test getDefense ")
    void test_getDefense() {
        assertEquals(defender.getDefense(),
                ParametersWarrior.getParameter(defender, ParametersWarrior.Parameter.DEFENSE));
    }
}