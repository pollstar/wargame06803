package ua.pollstar.softserve.eventhandling;

import ua.pollstar.softserve.warriors.Warrior;

public interface Handler {
    void setNext(Handler handler);
    Handler getNext();
    void handler(Warrior ownerEvent, EventsType event, int value);
}
