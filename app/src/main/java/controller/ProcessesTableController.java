package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import model.Process;

public class ProcessesTableController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        processName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        processSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
        processArrivalTime.setCellValueFactory(cellData -> cellData.getValue().getArrivalTimeProperty().asObject());
        processDuration.setCellValueFactory(cellData -> cellData.getValue().getDurationProperty().asObject());
    }
}
