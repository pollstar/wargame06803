package ua.pollstar.softserve.warriors;

public class Healer extends Warrior {
    private int healOneTime = 2;
    private int maxHeals = 50;

    public Healer() {
        this.healOneTime = ParametersWarrior.getParameter(this.getClass(), ParametersWarrior.Parameter.HEAL);
    }

    public void heal(Warrior warrior) {
        if ((maxHeals--) > 0) {
            warrior.setHealth(warrior.getHealth() + healOneTime);
        }
    }

    public int getHealOneTime() {
        return healOneTime;
    }
}
