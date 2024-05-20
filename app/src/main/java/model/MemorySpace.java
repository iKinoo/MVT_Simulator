package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public interface MemorySpace {
    public IntegerProperty getNumberProperty();
    public IntegerProperty getLocationProperty();
    public IntegerProperty getEndProperty();
    public IntegerProperty getSizeProperty();
    public StringProperty getStatusProperty();

    public MemorySpace next();
    public void setNext(MemorySpace next);
}
