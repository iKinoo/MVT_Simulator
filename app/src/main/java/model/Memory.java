package model;

import java.util.ArrayList;

public class Memory {

    private static Memory instance;

    private MemorySpace head;
    private MemorySpace tail;
    private final MemorySpace operatingSystemSpace;
    private ArrayList<MemorySpace> memorySpaces = new ArrayList<>();
    private final int memorySize = 64;
    @SuppressWarnings("unused")
    private int freeMemory = 54;
    

    private Memory() {
        this.operatingSystemSpace = new Partition(
                0,
                0,
                10,
                "Activo",
                new Process("Sistema Operativo", 10, 0, 0));

        tail = new Hole(
                1,
                10,
                54,
                "Libre");
        head = this.operatingSystemSpace;
        head.setNext(tail);

        memorySpaces.add(operatingSystemSpace);
        memorySpaces.add(tail);
    }

    public static Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }

    public MemorySpace getHead() {
        return head;
    }

    public MemorySpace getTail() {
        return tail;
    }

    public MemorySpace getOperatingSystemSpace() {
        return operatingSystemSpace;
    }

    public void addMemorySpace(MemorySpace memorySpace) {
        
        this.tail.setNext(memorySpace);
        this.tail = memorySpace;
        this.memorySpaces.add(memorySpace);

        if (memorySpace instanceof Hole) {
            this.freeMemory += memorySpace.getSizeProperty().getValue();
        } else {
            this.freeMemory -= memorySpace.getSizeProperty().getValue();
        }
    }

    public int getMemorySize() {
        return memorySize;
    }

    public ArrayList<MemorySpace> getMemorySpaces() {
        return memorySpaces;
    }
}
