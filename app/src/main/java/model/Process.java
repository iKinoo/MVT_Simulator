package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Process {

    private String name;
    private Integer size;
    private Integer arrivalTime;
    private Integer duration;
    public Integer endTime;

    public Process(String name, Integer size, Integer arrivalTime, Integer duration) {
        this.name = name;
        this.size = size;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
    }

    public StringProperty getNameProperty() {
        return new SimpleStringProperty(name);
    }

    public IntegerProperty getSizeProperty() {
        return new SimpleIntegerProperty(size);
    }

    public IntegerProperty getArrivalTimeProperty() {
        return new SimpleIntegerProperty(arrivalTime);
    }

    public IntegerProperty getDurationProperty() {
        return new SimpleIntegerProperty(duration);
    }

}
