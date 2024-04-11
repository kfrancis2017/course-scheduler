module dgworks {
    requires javafx.controls;
    requires javafx.fxml;

    opens dgworks to javafx.fxml;
    exports dgworks;
}
