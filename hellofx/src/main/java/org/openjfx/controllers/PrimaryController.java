package org.openjfx.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import library.App;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
