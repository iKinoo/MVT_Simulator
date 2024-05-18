package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Process {

    private StringProperty name;
    private IntegerProperty size;
    private IntegerProperty arrivalTime;
    private IntegerProperty duration;

    public Process(String name, Integer size, Integer arrivalTime, Integer duration) {
        this.name = new SimpleStringProperty(name);
        this.size = new SimpleIntegerProperty(size);
        this.arrivalTime = new SimpleIntegerProperty(arrivalTime);
        this.duration = new SimpleIntegerProperty(duration);
    }

    public StringProperty getName() {
        return name;
    }

    public IntegerProperty getSize() {
        return size;
    }

    public IntegerProperty getArrivalTime() {
        return arrivalTime;
    }

    public IntegerProperty getDuration() {
        return duration;
    }

    
    
}
