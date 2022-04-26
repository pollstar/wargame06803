package ua.pollstar.softserve.weapons;

public class Katana extends Weapon{
    public Katana() {
        super.builderInternal()
                .health(-20)
                .attack(6)
                .defense(-5)
                .vampirism(50)
                .build();
    }

}
