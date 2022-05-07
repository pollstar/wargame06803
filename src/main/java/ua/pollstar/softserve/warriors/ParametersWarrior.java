package ua.pollstar.softserve.warriors;

import java.util.Map;

public class ParametersWarrior {
    public static enum Parameter {
        HEALTH,
        ATTACK,
        DEFENSE,
        VAMPIRISM,
        NEXT_DAMAGE,
        HEAL
    }
    private static Map<Class<? extends Warrior>, Map<Parameter, Integer>> parameters = Map.of(
            Rookie.class, Map.of(
                    Parameter.HEALTH, 50,
                    Parameter.ATTACK,1),
            Warrior.class, Map.of(
                    Parameter.HEALTH, 50,
                    Parameter.ATTACK,5),
            Knight.class, Map.of(
                    Parameter.HEALTH, 50,
                    Parameter.ATTACK, 7),
            Defender.class, Map.of(
                    Parameter.HEALTH, 60,
                    Parameter.ATTACK, 3,
                    Parameter.DEFENSE, 2),
            Lancer.class, Map.of(
                    Parameter.HEALTH, 50,
                    Parameter.ATTACK, 6,
                    Parameter.NEXT_DAMAGE, 50),
            Vampire.class, Map.of(
                    Parameter.HEALTH, 40,
                    Parameter.ATTACK, 4,
                    Parameter.VAMPIRISM, 50),
            Healer.class, Map.of(
                    Parameter.HEALTH, 60,
                    Parameter.ATTACK, 0,
                    Parameter.HEAL, 2),
            Warlord.class, Map.of(
                    Parameter.HEALTH, 100,
                    Parameter.ATTACK, 4,
                    Parameter.DEFENSE, 2)

            );

    public static Map<Parameter, Integer> getParameters(Class<? extends Warrior> warrior) {
        return parameters.get(warrior);
    }

    public static Integer getParameter(Class<? extends Warrior> warrior, Parameter parameter) {
        return getParameters(warrior).get(parameter);
    }

    public static Integer getParameter(Warrior warrior, Parameter parameter) {
        return getParameter(warrior.getClass(), parameter);
    }
}
