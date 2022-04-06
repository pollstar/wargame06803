package ua.pollstar.softserve;

public class Defender extends Warrior{
    protected int defense;

    public Defender() {
        health = 60;
        defense = 2;
        attack = 3;
    }

    protected void setDamage(int damage) {
        if (damage > defense) {
            health -= damage - defense;
            alive = health > 0;
        }
    }
}
