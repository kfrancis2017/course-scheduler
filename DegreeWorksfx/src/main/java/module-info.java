module org.openjfx.hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens library to javafx.fxml;
    exports library;

    opens degreeswork to javafx.fxml;
    exports degreeswork;
}
