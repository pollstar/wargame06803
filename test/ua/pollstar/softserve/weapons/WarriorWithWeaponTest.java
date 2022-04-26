package ua.pollstar.softserve.weapons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.pollstar.softserve.warriors.*;
import ua.pollstar.softserve.weapons.Weapon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorWithWeaponTest {
    private Weapon weapon;
    private Warrior warrior;
    private ArrayList<Warrior> warriors;

    private static Stream<Arguments> initWeapon() {
        return Stream.of(
                Arguments.of(Weapon.builder().health(10).attack(5).vampirism(6).defense(7).heal(8).build()),
                Arguments.of(Weapon.builder().health(-10).attack(-5).vampirism(-6).defense(-7).heal(-8).build()),
                Arguments.of(Weapon.builder().health(-100).attack(-105).vampirism(-106).defense(-107).heal(-108).build()),
                Arguments.of(Weapon.builder().health(100).attack(105).vampirism(106).defense(107).heal(108).build()),
                Arguments.of(new Sword()),
                Arguments.of(new Shield()),
                Arguments.of(new MagicWand()),
                Arguments.of(new Katana()),
                Arguments.of(new GreatAxe())
        );
    }

    void init() {
        warriors = new ArrayList<>(
                Arrays.asList(new Warrior(), new Knight(), new Defender(), new Vampire(), new Lancer())
        );
    }

    @ParameterizedTest
    @MethodSource("initWeapon")
    void test_WarriorEquip(Weapon weapon) {
        init();
        for (var w : warriors) {
            int oldHealth = w.getHealth();
            int oldAttack = w.getAttack();
            int oldMaxHealth = w.getMaxHealth();
            int oldMaxAttack = w.getMaxAttack();

            w.equipWeapon(weapon);

            assertEquals(oldHealth + weapon.getHealth(), w.getHealth());
            int newAttack = Math.max(0, oldAttack + weapon.getAttack());
            assertEquals(newAttack, w.getAttack());

            int newMaxHealth = Math.max(0, oldMaxHealth + weapon.getHealth());
            assertEquals(newMaxHealth, w.getMaxHealth());
            int newMaxAttack = Math.max(0, oldMaxAttack + weapon.getAttack());
            assertEquals(newMaxAttack, w.getMaxAttack());
        }
    }

    @ParameterizedTest
    @MethodSource("initWeapon")
    void test_Vampirism_Equip(Weapon weapon) {
        var w = new Vampire();

        int oldValue = w.getVampirism();
        int oldMaxValue = w.getMaxVampirism();

        w.equipWeapon(weapon);

        int newValue = Math.max(0, oldValue + weapon.getVampirism());
        assertEquals(newValue, w.getVampirism());

        int newMaxValue = Math.max(0, oldMaxValue + weapon.getVampirism());
        assertEquals(newMaxValue, w.getMaxVampirism());
    }

    @ParameterizedTest
    @MethodSource("initWeapon")
    void test_Defense_Equip(Weapon weapon) {
        var w = new Defender();

        int oldValue = w.getDefense();
        int oldMaxValue = w.getMaxDefense();

        w.equipWeapon(weapon);

        int newValue = Math.max(0, oldValue + weapon.getDefense());
        assertEquals(newValue, w.getDefense());

        int newMaxValue = Math.max(0, oldMaxValue + weapon.getDefense());
        assertEquals(newMaxValue, w.getMaxDefense());
    }

    @ParameterizedTest
    @MethodSource("initWeapon")
    void test_Heal_Equip(Weapon weapon) {
        var w = new Healer();

        int oldValue = w.getHeal();
        int oldMaxValue = w.getMaxHeal();

        w.equipWeapon(weapon);

        int newValue = Math.max(0, oldValue + weapon.getHeal());
        assertEquals(newValue, w.getHeal());

        int newMaxValue = Math.max(0, oldMaxValue + weapon.getHeal());
        assertEquals(newMaxValue, w.getMaxHeal());
    }

    @Test
    void test_Warrior_Equip_and_Warrior_NotEquip() {
        init();
        var weapon = Weapon.builder().health(10).attack(5).vampirism(6).defense(7).heal(8).build();
        for (Warrior w : warriors) {
            Constructor<? extends Warrior> warriorConst = null;
            try {
                warriorConst = w.getClass().getDeclaredConstructor();
                warrior = warriorConst.newInstance();
            } catch (NoSuchMethodException | IllegalAccessException
                    | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }

            warrior.equipWeapon(Weapon.builder().health(10).attack(5).vampirism(6).defense(7).heal(8).build());
            assertNotEquals(w.getHealth(), warrior.getHealth());
            assertNotEquals(w.getAttack(), warrior.getAttack());
        }
    }

    @Test
    void test_isAlive_Warrior_After_Equip() {
        init();
        var weapon = Weapon.builder().health(-100).attack(5).vampirism(6).defense(7).heal(8).build();
        for (Warrior w : warriors) {
            assertTrue(w.isAlive());
            w.equipWeapon(weapon);
            assertFalse(w.isAlive());
        }
    }

}

