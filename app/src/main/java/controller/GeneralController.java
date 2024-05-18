package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class GeneralController extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("index.fxml")));
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

}
