package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hole implements MemorySpace {

    private Integer number;
    private Integer location;
    private Integer size;
    private String status;
    private MemorySpace next;

    @Override
    public MemorySpace next() {
        return next;
    }

    @Override
    public IntegerProperty getEndProperty() {
        return new SimpleIntegerProperty(location + size - 1);
    }

    @Override
    public void setNext(MemorySpace next) {
        this.next = next;
    }

    public Hole(Integer number, Integer location, Integer size, String status) {
        this.number = number;
        this.location = location;
        this.size = size;
        this.status = status;
    }

    public IntegerProperty getNumberProperty() {
        return new SimpleIntegerProperty(number);
    }

    public IntegerProperty getLocationProperty() {
        return new SimpleIntegerProperty(location);
    }

    public IntegerProperty getSizeProperty() {
        return new SimpleIntegerProperty(size);
    }

    public StringProperty getStatusProperty() {
        return new SimpleStringProperty(status);
    }
}
