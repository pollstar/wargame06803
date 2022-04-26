package ua.pollstar.softserve;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.pollstar.softserve.warriors.Defender;
import ua.pollstar.softserve.warriors.Lancer;
import ua.pollstar.softserve.warriors.Warrior;
import ua.pollstar.softserve.warriors.WarriorFactory;
import ua.pollstar.softserve.weapons.Weapon;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {
    Army army;

    @BeforeEach
    void init() {
        army = new Army();
    }

    @Test
    void addUnit() {
        army.addUnit(Warrior.class, 0);
        assertFalse(army.isAlive());
        army.addUnit(Warrior.class, 3);
        assertTrue(army.isAlive());
        army.addUnit(Lancer.class, 2);
        assertTrue(army.isAlive());
        army.addUnit(Defender.class, 1);
        assertTrue(army.isAlive());
    }

    @Test
    void testAddUnit() {
    }

    @Test
    void getWarrior() {
    }

    @Test
    void isAlive() {
        army.addUnit(Warrior.class, 3);
        army.addUnit(Lancer.class, 2);
        army.addUnit(Defender.class, 1);

        int count = 0;
        for (var w : army) {
            count++;
            if (count % 2 == 0) {
                w.equipWeapon(Weapon.builder().health(-100).build());
            }
        }

        assertTrue(army.isAlive());
        int count2 = 0;
        for (var w : army) {
            count2++;
        }

        assertEquals(count/2, count2);
    }

    @Test
    void isAlive2() {
        army.addUnit(Warrior.class, 3);
        army.addUnit(Lancer.class, 2);
        army.addUnit(Defender.class, 1);

        int count = 0;
        for (var w : army) {
            count++;
            w.equipWeapon(Weapon.builder().health(-100).build());
        }

        assertFalse(army.isAlive());
        int count2 = 0;
        for (var w : army) {
            count2++;
        }

        assertEquals(0, count2);
    }

    @Test
    void isAlive3() {
        army.addUnit(Warrior.class, 1);

        assertTrue(army.isAlive());

        int count2 = 0;
        for (var w : army) {
            count2++;
        }

        assertEquals(1, count2);
    }

    @Test
    void iterator() {
    }

    @Test
    void straightFightOn() {
    }

    @Test
    void straightFightOff() {
    }

    @Test
    void needHeal() {
    }

    @Test
    void takeDamageForNext() {
    }
}