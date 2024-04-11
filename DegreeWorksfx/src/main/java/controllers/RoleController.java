package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import library.DegreeworksApp;

public class RoleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void btnAdvisorClicked(MouseEvent event) {
        DegreeworksApp.setRoot("advisor_login");
    }

    @FXML
    void btnStudentClicked(MouseEvent event) {
        DegreeworksApp.setRoot("student_login");
    }

    @FXML
    void initialize() {

    }

}
