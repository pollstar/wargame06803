package ua.pollstar.softserve.eventhandling;

public interface Handler {
    int value = 0;

    void setNext(Handler handler);
    void handle(EventsType event, int value);
}
