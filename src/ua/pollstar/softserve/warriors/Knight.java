package ua.pollstar.softserve.warriors;

public class Knight extends Warrior{
    private static int maxHealth = 50;
    private static int maxAttack = 7;

    public Knight() {
        setHealth(maxHealth);
        setAttack(maxAttack);
    }
}
