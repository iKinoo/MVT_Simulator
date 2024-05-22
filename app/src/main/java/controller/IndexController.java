package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Hole;
import model.Memory;
import model.MemorySpace;
import model.Partition;
import model.Process;
import model.Event.EndEvent;
import model.Event.Event;
import model.Event.StartEvent;

public class IndexController implements Initializable {

  private Memory memory = Memory.getInstance();
  private int counter = 0;
  private Scanner scanner = new Scanner(System.in);

  // HOLES TABLE CONTROLLER

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    updateAll();

  }

  public void updateAll() {
    updateTablePartitions();
    updateTableHoles();
    updateTableMemoryTable();
    updateTableProcesses();
  }

  // HOLE TABLE CONTROLLER
  // --------------------------
  @FXML
  private TableView<Hole> holesTable;
  @FXML
  private TableColumn<Hole, Integer> holeNumber;
  @FXML
  private TableColumn<Hole, Integer> holeLocation;
  @FXML
  private TableColumn<Hole, Integer> holeSize;
  @FXML
  private TableColumn<Hole, String> holeStatus;

  public void updateTableHoles() {

    holeNumber.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty().asObject());
    holeLocation.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty().asObject());
    holeSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
    holeStatus.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());

    holesTable.getItems().clear();
    holesTable.getItems().setAll(memory.getHoles());
  }

  // MEMORY TABLE CONTROLLER
  // --------------------------

  @FXML
  private TableView<MemorySpace> memoryTable;
  @FXML
  private TableColumn<MemorySpace, Integer> memorySpaceNumber;
  @FXML
  private TableColumn<MemorySpace, Integer> memorySpaceLocation;
  @FXML
  private TableColumn<MemorySpace, Integer> memorySpaceSize;
  @FXML
  private TableColumn<MemorySpace, String> memorySpaceStatus;

  public void updateTableMemoryTable() {

    memorySpaceNumber.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty().asObject());
    memorySpaceLocation.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty().asObject());
    memorySpaceSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
    memorySpaceStatus.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());

    memoryTable.getItems().clear();
    memoryTable.getItems().addAll(memory.getMemorySpaces());
  }

  // PARTITIONS TABLE CONTROLLER
  // --------------------------

  @FXML
  private TableView<Partition> partitionsTable;
  @FXML
  private TableColumn<Partition, Integer> partitionNumber;
  @FXML
  private TableColumn<Partition, Integer> partitionLocation;
  @FXML
  private TableColumn<Partition, Integer> partitionSize;
  @FXML
  private TableColumn<Partition, String> partitionStatus;
  @FXML
  private TableColumn<Partition, String> partitionProcess;

  public void updateTablePartitions() {

    partitionNumber.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty().asObject());
    partitionLocation.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty().asObject());
    partitionSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
    partitionStatus.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
    partitionProcess.setCellValueFactory(cellData -> cellData.getValue().getProcess().getNameProperty());

    partitionsTable.getItems().clear();
    partitionsTable.getItems().setAll(memory.getPartitions());
  }

  // PROCESSES TABLE CONTROLLER
  @FXML
  private TableView<Process> processesTable;
  @FXML
  private TableColumn<Process, String> processName;
  @FXML
  private TableColumn<Process, Integer> processSize;
  @FXML
  private TableColumn<Process, Integer> processArrivalTime;
  @FXML
  private TableColumn<Process, Integer> processDuration;

  public void updateTableProcesses() {

    processName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
    processSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
    processArrivalTime.setCellValueFactory(cellData -> cellData.getValue().getArrivalTimeProperty().asObject());
    processDuration.setCellValueFactory(cellData -> cellData.getValue().getDurationProperty().asObject());

    processesTable.getItems().clear();
    processesTable.getItems().setAll(memory.getProcesses());
    System.out.println("Update Table Processes");
  }

  ArrayList<Process> processes = memory.getProcesses();
  ArrayList<Event> events = new ArrayList<Event>();

  public void startMVT() throws IOException {

    System.out.println("Start MVT");

    for (Process process : processes) {

      StartEvent startEvent = new StartEvent(process, this.memory);
      EndEvent endEvent = new EndEvent(process, this.memory);

      events.add(startEvent);
      events.add(endEvent);
    }

    events.sort(Comparator.comparing(Event::getTimeEvent));

    System.out.println("Start MVT");

  }
  int index = 0;
  public void nextStep() {

    if (index < events.size()) {
      events.get(index).execute();
      index++;
    }

    updateAll();
  }
}
