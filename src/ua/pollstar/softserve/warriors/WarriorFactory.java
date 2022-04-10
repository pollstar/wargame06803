package ua.pollstar.softserve.warriors;

import java.lang.reflect.InvocationTargetException;

public class WarriorFactory {
    public enum Type {
        WARRIOR,
        KNIGHT
    }

    public static Warrior createWarrior(Type type) {
        return switch (type) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
        };
    }

    public static Warrior createWarrior(Class<? extends Warrior> warriorClass) {
        try {
            var constructor = warriorClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
