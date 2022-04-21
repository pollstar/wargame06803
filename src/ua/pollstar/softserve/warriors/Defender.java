package ua.pollstar.softserve.warriors;

public class Defender extends Warrior {
    private int defense;

    public Defender() {
        setDefense(ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.DEFENSE));
    }

    public void takeDamage(int damage) {
        if (damage > getDefense()) {
            super.takeDamage(damage - getDefense());
        }
    }

    public int getDefense() {
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }
}
