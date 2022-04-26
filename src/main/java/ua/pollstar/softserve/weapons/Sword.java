package ua.pollstar.softserve.weapons;

public class Sword extends Weapon{

    public Sword() {
        super.builderInternal()
                .health(5)
                .attack(2)
                .build();
    }
}
