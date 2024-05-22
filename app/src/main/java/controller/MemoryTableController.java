package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Memory;
import model.MemorySpace;

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

    private Memory memory = Memory.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        updateTable();
        
    }
    public void updateTable() {
        

        memorySpaceNumber.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty().asObject());
        memorySpaceLocation.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty().asObject());
        memorySpaceSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
        memorySpaceStatus.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());

        memoryTable.getItems().clear();
        memoryTable.getItems().addAll(memory.getMemorySpaces());
    }

    

  

}
