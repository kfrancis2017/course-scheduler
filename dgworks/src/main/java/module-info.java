module dgworks {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires org.apache.pdfbox;
    requires javafx.graphics;
    requires javafx.base;

    opens dgworks to javafx.fxml;
    exports dgworks;

    opens model to java.fxml;
    exports model;

    opens controllers to java.fxml;
    exports controllers;

}
