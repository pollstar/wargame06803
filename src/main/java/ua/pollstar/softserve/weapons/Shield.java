package ua.pollstar.softserve.weapons;

public class Shield extends Weapon{
    public Shield() {
        super.builderInternal()
                .health(20)
                .attack(-1)
                .defense(2)
                .build();
    }

}
