package ua.pollstar.softserve.warriors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorFactoryTest {
    private static Stream<Arguments> createdWarriorOverClass() {
        return Stream.of(
                Arguments.of(Warrior.class),
                Arguments.of(Knight.class),
                Arguments.of(Defender.class),
                Arguments.of(Lancer.class),
                Arguments.of(Vampire.class),
                Arguments.of(Healer.class)
        );
    }

    private static Stream<Arguments> createdWarriorOverType() {
        return Stream.of(
                Arguments.of(WarriorFactory.Type.WARRIOR),
                Arguments.of(WarriorFactory.Type.KNIGHT),
                Arguments.of(WarriorFactory.Type.DEFENDER),
                Arguments.of(WarriorFactory.Type.LANCER),
                Arguments.of(WarriorFactory.Type.VAMPIRE),
                Arguments.of(WarriorFactory.Type.HEALER)
        );
    }

    @ParameterizedTest
    @MethodSource("createdWarriorOverClass")
    void test_createdWarrior1(Class<? extends Warrior> warrior) {
        Warrior test = WarriorFactory.createWarrior(warrior);

        assert test != null;
        Class<? extends Warrior> testClass = test.getClass();

        assertEquals(test.getHealth(),
                ParametersWarrior.getParameter(testClass, ParametersWarrior.Parameter.HEALTH));
        System.out.println(test.getClass().getSimpleName() + " has health: " + test.getHealth());

        assertEquals(test.getAttack(),
                ParametersWarrior.getParameter(testClass, ParametersWarrior.Parameter.ATTACK));
        System.out.println("       has attack: " + test.getAttack());

    }

    @ParameterizedTest
    @MethodSource("createdWarriorOverType")
    void test_createdWarrior2(WarriorFactory.Type warrior) {
        Warrior test = WarriorFactory.createWarrior(warrior);
        test_createdWarrior1(test.getClass());
    }
}