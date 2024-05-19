package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Partition implements MemorySpace {

    private IntegerProperty number;
    private IntegerProperty location;
    private IntegerProperty size;
    private StringProperty status;
    private Process process;

    private MemorySpace next;

    @Override
    public MemorySpace next() {
        return next;
    }

    public void setNext(MemorySpace next) {
        this.next = next;
    }

    public Partition(Integer number, Integer location, Integer size, String status, Process process) {
        this.number = new SimpleIntegerProperty(number);
        this.location = new SimpleIntegerProperty(location);
        this.size = new SimpleIntegerProperty(size);
        this.status = new SimpleStringProperty(status);
        this.process = process;
    }

    public IntegerProperty getNumber() {
        return number;
    }

    public IntegerProperty getLocation() {
        return location;
    }

    public IntegerProperty getSize() {
        return size;
    }

    public StringProperty getStatus() {
        return status;
    }

    public Process getProcess() {
        process.getName();
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
