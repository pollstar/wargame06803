package ua.pollstar.softserve.weapons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    Weapon weapon;

    @Test
    void newWeapon() {
        weapon = Weapon.builder()
                .heal(10)
                .attack(5)
                .defense(3)
                .build();
        System.out.println(weapon);

        Weapon sword = new Sword();
        System.out.println(sword);
        Weapon shield = new Shield();
        System.out.println(shield);
        Weapon greatAxe = new GreatAxe();
        System.out.println(greatAxe);
        Weapon katana = new Katana();
        System.out.println(katana);
        Weapon magicWand = new MagicWand();
        System.out.println(magicWand);
    }

    @Test
    void getHealth() {
    }

    @Test
    void getAttack() {
    }

    @Test
    void getDefense() {
    }

    @Test
    void getVampirism() {
    }

    @Test
    void getHeal() {
    }

    @Test
    void builder() {
    }
}