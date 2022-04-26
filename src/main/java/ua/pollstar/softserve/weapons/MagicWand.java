package ua.pollstar.softserve.weapons;

public class MagicWand extends Weapon{
    public MagicWand() {
        super.builderInternal()
                .health(30)
                .attack(3)
                .heal(3)
                .build();
    }

}
