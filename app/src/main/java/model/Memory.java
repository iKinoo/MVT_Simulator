package model;

import java.util.ArrayList;

public class Memory {

    private MemorySpace head;
    private MemorySpace tail;
    private final MemorySpace operatingSystemSpace;    

    public Memory() {
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
    }

    public void add(MemorySpace memorySpace) {
        if (head == null) {
            head = memorySpace;
            tail = memorySpace;
        } else {
            tail.setNext(memorySpace);
            tail = memorySpace;
        }
    }

    public MemorySpace getHead() {
        return head;
    }

    public MemorySpace getTail() {
        return tail;
    }

    public void remove(MemorySpace memorySpace) {
        MemorySpace current = head;
        MemorySpace previous = null;

        while (current != null) {
            if (current == memorySpace) {
                if (previous == null) {
                    head = current.next();
                } else {
                    previous.setNext(current.next());
                }
                break;
            }
            previous = current;
            current = current.next();
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public ArrayList<MemorySpace> getMemorySpaces() {
        ArrayList<MemorySpace> memorySpaces = new ArrayList<>();
        MemorySpace current = head;

        while (current != null) {
            memorySpaces.add(current);
            current = current.next();
        }

        return memorySpaces;
    }
}
