package org.openjfx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import library.DegreeworksApp;
import degreeswork.*;

public class RoleController {

    @FXML
    private void onStudentLoginClicked(ActionEvent event) throws IOException {
        App.setRoot("student_login");
    }

    @FXML
    private void onAdvisorLoginClicked(ActionEvent event) throws IOException {
        App.setRoot("advisor_login");
    }
    
}
