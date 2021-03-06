package ua.pollstar.softserve.weapons;


import lombok.Builder;

public class Weapon {
    private int health = 0;
    private int attack = 0;
    private int defense = 0;
    private int vampirism = 0;
    private int heal = 0;

    public Weapon() {
    }

    private Weapon(int health, int attack, int defense, int vampirism, int heal) {
        setParametrs(health, attack, defense, vampirism, heal);
    }

    private void setParametrs(int health, int attack, int defense, int vampirism, int heal) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.vampirism = vampirism;
        this.heal = heal;
    }

    @Builder(builderMethodName = "builder")
    public static Weapon newWeapon(int health, int attack, int defense, int vampirism, int heal) {
        return new Weapon(health, attack, defense, vampirism, heal);
    }

    @Builder(builderMethodName = "builderInternal")
    protected void newWeaponInternal(int health, int attack, int defense, int vampirism, int heal) {
        setParametrs(health, attack, defense, vampirism, heal);
    }


    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getVampirism() {
        return vampirism;
    }

    public int getHeal() {
        return heal;
    }

    @Override
    public String toString() {
        return "Weapon: " + this.getClass().getSimpleName() + " {" +
                "health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", vampirism=" + vampirism +
                ", heal=" + heal +
                '}';
    }
}