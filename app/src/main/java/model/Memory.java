package model;

import java.util.ArrayList;


public class Memory {

    private static Memory instance;

    private MemorySpace head;
    private MemorySpace tail;
    private final MemorySpace operatingSystemSpace;
    public ArrayList<MemorySpace> memorySpaces = new ArrayList<>();
    public ArrayList<Process> processes = new ArrayList<>();
    private final int memorySize = 64;
    @SuppressWarnings("unused")
    private int freeMemory = 54;

    private Memory() {
        this.operatingSystemSpace = new Partition(
                0,
                0,
                9,
                "Activo",
                new Process("Sistema Operativo", 10, 0, 0));

        tail = new Hole(
                1,
                10,
                54,
                "Libre");
        head = this.operatingSystemSpace;
        head.setNext(tail);
        tail.setPrevious(head);
        head.setPrevious(null);

        memorySpaces.add(operatingSystemSpace);
        memorySpaces.add(tail);

        processes.add(new Process("A", 8, 1, 7));
        processes.add(new Process("B", 2,2, 7));
        processes.add(new Process("C", 18, 3, 4));
        processes.add(new Process("D", 6, 4, 6));
        processes.add(new Process("E", 14, 5, 5));
    }

    public static Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }

    public ArrayList<Hole> getHoles() {
        ArrayList<Hole> holes = new ArrayList<>();
        for (MemorySpace memorySpace : memorySpaces) {
            if (memorySpace instanceof Hole) {
                holes.add((Hole) memorySpace);
            }
        }
        return holes;
    }

    public ArrayList<Partition> getPartitions() {
        ArrayList<Partition> partitions = new ArrayList<>();
        for (MemorySpace memorySpace : memorySpaces) {
            if (memorySpace instanceof Partition) {
                partitions.add((Partition) memorySpace);
            }
        }
        return partitions;
    }

    public ArrayList<Process> getProcesses() {
        // ArrayList<Process> processes = new ArrayList<>();
        // for (MemorySpace memorySpace : memorySpaces) {
        //     if (memorySpace instanceof Partition) {
        //         Partition partition = (Partition) memorySpace;
        //         if (partition.getProcess() != null) {
        //             processes.add(partition.getProcess());
        //         }
        //     }
        // }
        // return processes;
        return this.processes;
    }

    public void addProcess(Process process) {

        for (MemorySpace memorySpace : memorySpaces) {
            if (memorySpace instanceof Hole) {
                Hole hole = (Hole) memorySpace;
                if (hole.getSizeProperty().getValue() >= process.getSizeProperty().getValue()) {
                    Partition partition = new Partition(
                            hole.getNumberProperty().getValue(),
                            hole.getLocationProperty().getValue(),
                            process.getSizeProperty().getValue(),
                            "Activo",
                            process);

                    partition.setNext(hole);
                    partition.setPrevious(hole.previous());

                    hole.previous().setNext(partition);
                    hole.setPrevious(partition);

                    hole.setSize(hole.getSizeProperty().getValue() - process.getSizeProperty().getValue());
                    hole.setLocation(hole.getLocationProperty().getValue() + process.getSizeProperty().getValue());
                    memorySpaces.add(memorySpaces.indexOf(hole), partition);
                    this.processes.add(process);
                    break;
                    
                }
            }
        }
    }

    public void addProcesses(ArrayList<Process> processes) {
        for (Process process : processes) {
            addProcess(process);
        }
    }

    public void removeProcess(Process process) {
            
            for (MemorySpace memorySpace : memorySpaces) {
                if (memorySpace instanceof Partition 
                    && ((Partition) memorySpace).getProcess().equals(process)){

                    Partition partition = (Partition) memorySpace;

                    // case [partition]-->[process] --> [hole] 
                    if (partition.previous() instanceof Partition
                        && partition.next() instanceof Hole
                        ) {
                        Hole hole = (Hole) partition.next();
                        hole.setSize(hole.getSizeProperty().getValue() + partition.getSizeProperty().getValue());
                        hole.setLocation(hole.getLocationProperty().getValue() - partition.getSizeProperty().getValue());
                        hole.setPrevious(partition.previous());

                        memorySpaces.remove(partition);
                        processes.remove(process);
                        break;
                    }
                    // case [hole]-->[process] --> [partition]
                    if (partition.previous() instanceof Hole
                        && partition.next() instanceof Partition
                        ) {
                        Hole hole = (Hole) partition.previous();
                        hole.setSize(hole.getSizeProperty().getValue() + partition.getSizeProperty().getValue());
                        partition.previous().setNext(partition.next());
                        partition.next().setPrevious(partition.previous());
                        memorySpaces.remove(partition);
                        processes.remove(process);
                        break;
                    }
                    // case [partition]-->[process] --> [partition]
                    if (partition.previous() instanceof Partition
                        && partition.next() instanceof Partition
                        ) {
                        Hole hole = new Hole(
                            partition.getNumberProperty().getValue(),
                            partition.getLocationProperty().getValue(),
                            partition.getSizeProperty().getValue(),
                            "Libre");
                        hole.setPrevious(partition.previous());
                        hole.setNext(partition.next());
                        partition.previous().setNext(hole);
                        partition.next().setPrevious(hole);
                        
                        memorySpaces.add(memorySpaces.indexOf(partition), hole);
                        memorySpaces.remove(partition);
                        processes.remove(process);
                        break;
                    }
                    // case [hole]-->[process] --> [hole]
                    if (partition.previous() instanceof Hole
                        && partition.next() instanceof Hole
                        ) {
                        Hole hole1 = (Hole) partition.previous();
                        Hole hole2 = (Hole) partition.next();
                        hole1.setSize(hole1.getSizeProperty().getValue() + partition.getSizeProperty().getValue() + hole2.getSizeProperty().getValue());
                        hole1.setNext(hole2.next());
                        hole2.next().setPrevious(hole1);
                        memorySpaces.remove(partition);
                        memorySpaces.remove(hole2);
                        processes.remove(process);
                        break;
                    }
                }
            }     
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


    public int getMemorySize() {
        return memorySize;
    }

    public ArrayList<MemorySpace> getMemorySpaces() {
        return memorySpaces;
    }
}
