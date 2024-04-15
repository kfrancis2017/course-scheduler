module dgworks {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens dgworks to javafx.fxml;
    exports dgworks;

    opens model to java.fxml;
    exports model;

    opens controllers to java.fxml;
    exports controllers;

}
