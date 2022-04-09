package ua.pollstar.softserve.warriors;

public class Defender extends Warrior {
    private int defense;

    public Defender() {
        setHealth(60);
        setDefense(2);
        setAttack(3);
    }

    protected void takeDamage(int damage) {
        if (damage > getDefense()) {
            int h = getHealth() - (damage - getDefense());
            setHealth(h);
        }
    }

    private int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }
}
