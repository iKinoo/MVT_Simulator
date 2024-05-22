package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Hole;
import model.Memory;

public class HolesTableController implements Initializable {

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

    private Memory memory = Memory.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        holeNumber.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty().asObject());
        holeLocation.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty().asObject());
        holeSize.setCellValueFactory(cellData -> cellData.getValue().getSizeProperty().asObject());
        holeStatus.setCellValueFactory(cellData -> cellData.getValue().getStatusProperty());
        
        holesTable.getItems().setAll(memory.getHoles());
    }
}
