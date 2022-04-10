package ua.pollstar.softserve.warriors;

public class Defender extends Warrior {
    private static int maxHealth = 60;
    private static int maxAttack = 3;
    private static int maxDefense = 2;

    private int defense;

    public Defender() {
        setHealth(maxHealth);
        setDefense(maxDefense);
        setAttack(maxAttack);
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

    public static int getMaxDefense() {
        return maxDefense;
    }

    public static void setMaxDefense(int maxDefense) {
        Defender.maxDefense = maxDefense;
    }
}
