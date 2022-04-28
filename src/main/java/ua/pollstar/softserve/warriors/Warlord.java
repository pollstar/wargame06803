package ua.pollstar.softserve.warriors;

import ua.pollstar.softserve.Army;

import java.util.Arrays;
import java.util.LinkedList;

public class Warlord extends Defender{
    public LinkedList<Warrior> moveUnits() {
        Army army = this.getArmy();
        if (army == null) {
            return new LinkedList<>();
        }


        LinkedList<Warrior> healers = new LinkedList<>();
        LinkedList<Warrior> warriors = new LinkedList<>();
        boolean firstLancerFound = false;
        for (Warrior w : army) {
            if (w.getClass() == Healer.class) {
                healers.addLast(w);
            } else if (w.getClass() != Warlord.class) {
                if (!firstLancerFound && w.getClass() == Lancer.class) {
                    warriors.addFirst(w);
                    firstLancerFound = true;
                } else {
                    warriors.addLast(w);
                }
            }
        }

        if (warriors.isEmpty()) {
            if(healers.isEmpty()) {
                return new LinkedList<Warrior>(Arrays.asList(this));
            }
            healers.addLast(this);
            return healers;
        }
        warriors.addAll(1, healers);
        warriors.addLast(this);

        return warriors;
    }
}

