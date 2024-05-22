package controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Comparator;


import javafx.fxml.FXMLLoader;
import model.Memory;
import model.Process;
import model.Event.EndEvent;
import model.Event.Event;
import model.Event.StartEvent;

public class IndexController {

  private Memory memory = Memory.getInstance();
  private int time = 2000;

  FXMLLoader holesTableloader = new FXMLLoader(getClass().getResource("holesTable.fxml"));
  FXMLLoader memoryTable = new FXMLLoader(getClass().getResource("memoryTable.fxml"));
  FXMLLoader partitionsTable = new FXMLLoader(getClass().getResource("partitionsTable.fxml"));
  FXMLLoader processesTableLoader = new FXMLLoader(getClass().getResource("processesTable.fxml"));

  public void startMVT() throws IOException {

    ArrayList<Process> processes = memory.getProcesses();
    ArrayList<Event> events = new ArrayList<Event>();

    holesTableloader.load();
    memoryTable.load();
    partitionsTable.load();
    processesTableLoader.load();

    HolesTableController holesTableController = holesTableloader.getController();
    MemoryTableController memoryTableController = memoryTable.getController();
    PartitionsTableController partitionsTableController = partitionsTable.getController();
    ProcessesTableController processesTableController = processesTableLoader.getController();

    System.out.println("Start MVT");

    for (Process process : processes) {

      StartEvent startEvent = new StartEvent(process, this.memory);
      EndEvent endEvent = new EndEvent(process, this.memory);

      events.add(startEvent);
      events.add(endEvent);
    }

    events.sort(Comparator.comparing(Event::getTimeEvent));

    for (Event event : events) {

      System.out.println("Time: " + event.getTimeEvent());
      event.execute();
      // holesTableController.updateTable();
      // memoryTableController.updateTable();
      // partitionsTableController.updateTable();
      // processesTableController.updateTable();
    }
    

    System.out.println("Start MVT");

  }

  public boolean nextStep() {
    return true;
  
  }

}
