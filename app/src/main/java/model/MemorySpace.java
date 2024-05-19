package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface MemorySpace {
    public IntegerProperty getNumber();
    public IntegerProperty getLocation();
    public IntegerProperty getSize();
    public StringProperty getStatus();

    public MemorySpace next();
    public void setNext(MemorySpace next);
}
