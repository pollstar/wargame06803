package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.Army;

import java.lang.reflect.InvocationTargetException;

public class WarriorFactory {
    public enum Type {
        WARRIOR,
        KNIGHT,
        DEFENDER,
        VAMPIRE,
        LANCER,
        HEALER,
        WARLORD,
        DRAGON
    }

    public static Warrior createWarrior(Type type) {
        return switch (type) {
            case WARRIOR -> new Warrior();
            case KNIGHT -> new Knight();
            case DEFENDER -> new Defender();
            case VAMPIRE -> new Vampire();
            case LANCER -> new Lancer();
            case HEALER -> new Healer();
            case WARLORD -> new Warlord();
            case DRAGON -> new Dragon();
        };
    }

    public static Warrior createWarrior(Type type, Army army) {
        var warrior = createWarrior(type);
        warrior.setArmy(army);
        return warrior;
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

    public static Warrior createWarrior(Class<? extends Warrior> warriorClass, Army army) {
        var warrior = createWarrior(warriorClass);
        assert warrior != null;
        warrior.setArmy(army);
        return warrior;
    }


}
