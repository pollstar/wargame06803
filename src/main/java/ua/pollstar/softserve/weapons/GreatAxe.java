package ua.pollstar.softserve.weapons;

public class GreatAxe extends Weapon{
    public GreatAxe() {
        super.builderInternal()
                .health(-15)
                .attack(5)
                .defense(-2)
                .vampirism(10)
                .build();
    }

}
