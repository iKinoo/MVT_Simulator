module mvt_simulation {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.base;

    opens controller to javafx.fxml;

    exports controller;
}
