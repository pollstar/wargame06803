package ua.pollstar.softserve.warriors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VampireTest {

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
    void test_attackEnemy() {
        Vampire vampire = new Vampire();
        Warrior warrior = new Warrior();
        var oldHealthVampire = vampire.getHealth();
        var oldHealthWarrior = warrior.getHealth();
        vampire.attackEnemy(warrior);
        var newHealthWarrior = warrior.getHealth();
        var shouldBeHealth = oldHealthVampire + (oldHealthWarrior - newHealthWarrior) * vampire.getVampirism()/100;

        assertEquals(Math.min(shouldBeHealth,
                ParametersWarrior.getParameter(vampire, ParametersWarrior.Parameter.HEALTH)), vampire.getHealth());
    }
}