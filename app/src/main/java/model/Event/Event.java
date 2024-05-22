package model.Event;
import model.Process;

public interface Event {
    public int getTimeEvent();
    public Process getProcess();
    public void execute();
}
