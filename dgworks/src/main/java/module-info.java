module dgworks {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens dgworks to javafx.fxml;

    exports dgworks;

    opens controllers to java.fxml;

    exports controllers;

    opens model to java.fxml;
    
    exports model;

}
