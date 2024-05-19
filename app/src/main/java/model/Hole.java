package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hole implements MemorySpace{

    private IntegerProperty number;
    private IntegerProperty location;
    private IntegerProperty size;
    private StringProperty status;
    private MemorySpace next;

    @Override
    public MemorySpace next() {
        return next;
    }
    @Override
    public void setNext(MemorySpace next) {
        this.next = next;
    }

    public Hole(Integer number, Integer location, Integer size, String status) {
        this.number = new SimpleIntegerProperty(number);
        this.location = new SimpleIntegerProperty(location);
        this.size = new SimpleIntegerProperty(size);
        this.status = new SimpleStringProperty(status);
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
}
