package model.Event;

import model.Memory;
import model.Process;


public class StartEvent implements Event {

    private Memory memory;
    
    private Process process;

    public StartEvent(Process process, Memory memory){
        this.process = process;
        this.memory = memory;
    }

    public Process getProcess(){
        return process;
    }

    public int getTimeEvent(){
        return process.getArrivalTimeProperty().get();
    }
    
    @Override
    public void execute() {
        this.memory.addProcess(process);
    }
}
