package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Partition;
import model.Process;

public class PartitionsTableController implements Initializable{

    @FXML private TableView<Partition> partitionsTable;
    @FXML private TableColumn<Partition, Integer> partitionNumber;
    @FXML private TableColumn<Partition, Integer> partitionLocation;
    @FXML private TableColumn<Partition, Integer> partitionSize;
    @FXML private TableColumn<Partition, String> partitionStatus;
    @FXML private TableColumn<Partition, String> partitionProcess;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        partitionNumber.setCellValueFactory(cellData -> cellData.getValue().getNumber().asObject());
        partitionLocation.setCellValueFactory(cellData -> cellData.getValue().getLocation().asObject());
        partitionSize.setCellValueFactory(cellData -> cellData.getValue().getSize().asObject());
        partitionStatus.setCellValueFactory(cellData -> cellData.getValue().getStatus());
        partitionProcess.setCellValueFactory(cellData -> cellData.getValue().getProcess().getName());
        
        partitionsTable.getItems().add(new Partition(1, 0, 10, "Free", new Process("paco", 10, 0, 5)));
        partitionsTable.getItems().add(new Partition(2, 10, 20, "Free", new Process("paco", 10, 0, 5)));
        partitionsTable.getItems().add(new Partition(3, 30, 5, "Free", new Process("paco", 10, 0, 5)));
        partitionsTable.getItems().add(new Partition(4, 35, 15, "Free", new Process("paco", 10, 0, 5)));
        partitionsTable.getItems().add(new Partition(5, 50, 10, "Free", new Process("paco", 10, 0, 5)));
        
    }
    
}
