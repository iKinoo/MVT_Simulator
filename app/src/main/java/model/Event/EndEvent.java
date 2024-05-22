package model.Event;

import model.Memory;
import model.Process;

public class EndEvent implements Event{

    private Memory memory;
    Process process;
    public EndEvent(Process process, Memory memory){
        this.process = process;
        this.memory = memory;
    }
    public Process getProcess(){
        return process;
    }
    public int getTimeEvent(){
        return process.getArrivalTimeProperty().get() + process.getDurationProperty().get();
    }
    @Override
    public void execute() {
        memory.removeProcess(process);
    }
}
