package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Hole;
import model.Memory;
import model.MemorySpace;
import model.Partition;
import model.Process;

public class MemoryTableController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        memorySpaceNumber.setCellValueFactory(cellData -> cellData.getValue().getNumber().asObject());
        memorySpaceLocation.setCellValueFactory(cellData -> cellData.getValue().getLocation().asObject());
        memorySpaceSize.setCellValueFactory(cellData -> cellData.getValue().getSize().asObject());
        memorySpaceStatus.setCellValueFactory(cellData -> cellData.getValue().getStatus());

        Memory memory = new Memory();

        memoryTable.getItems().addAll(memory.getMemorySpaces());
    }

}
