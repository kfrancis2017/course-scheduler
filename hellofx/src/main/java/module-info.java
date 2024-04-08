module org.openjfx.hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens org.openjfx.controllers to javafx.fxml;
    exports org.openjfx.controllers;

    opens library to javafx.fxml;
    exports library;

    opens degreeswork to javafx.fxml;
    exports degreeswork;
}
