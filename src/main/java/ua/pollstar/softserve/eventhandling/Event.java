package ua.pollstar.softserve.eventhandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ua.pollstar.softserve.warriors.Warrior;

@AllArgsConstructor
@Getter
@Setter
public class Event {
    private Warrior ownerEvent;
    private EventsType event;
    private int value;

}
