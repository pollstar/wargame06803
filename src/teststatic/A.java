package teststatic;

import ua.pollstar.softserve.warriors.Warrior;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class A {
    private static int value = 1;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
