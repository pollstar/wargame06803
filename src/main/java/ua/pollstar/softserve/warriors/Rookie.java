package ua.pollstar.softserve.warriors;

public class Rookie extends Warrior{
    public Rookie() {
        setMaxHealth(ParametersWarrior.getParameter(Healer.class, ParametersWarrior.Parameter.HEALTH));
        setMaxAttack(ParametersWarrior.getParameter(Healer.class, ParametersWarrior.Parameter.ATTACK));
        setHealth(getMaxHealth());
        setAttack(getMaxAttack());
    }
}
