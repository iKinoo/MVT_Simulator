package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Hole;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        holeNumber.setCellValueFactory(cellData -> cellData.getValue().getNumber().asObject());
        holeLocation.setCellValueFactory(cellData -> cellData.getValue().getLocation().asObject());
        holeSize.setCellValueFactory(cellData -> cellData.getValue().getSize().asObject());
        holeStatus.setCellValueFactory(cellData -> cellData.getValue().getStatus());

        holesTable.getItems().add(new Hole(1, 0, 10, "Free"));
        holesTable.getItems().add(new Hole(2, 10, 20, "Free"));
        holesTable.getItems().add(new Hole(3, 30, 5, "Free"));
        holesTable.getItems().add(new Hole(4, 35, 15, "Free"));
        holesTable.getItems().add(new Hole(5, 50, 10, "Free"));

    }

}
