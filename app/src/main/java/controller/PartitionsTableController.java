package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Partition;

public class PartitionsTableController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        partitionNumber.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty().asObject());
        partitionLocation.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty().asObject());
        partitionSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
        partitionStatus.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
        partitionProcess.setCellValueFactory(cellData -> cellData.getValue().getProcess().getNameProperty());
    }

}
