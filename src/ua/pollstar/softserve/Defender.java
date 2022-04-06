package ua.pollstar.softserve;

public class Defender extends Warrior{
    protected int defense;

    public Defender() {
        defense = 2;
        attack = 3;
    }

    protected void setDamage(int damage) {
        if (damage > defense) {
            health -= damage;
            if (health <= 0) {
                alive = false;
            }
        }
    }
}
