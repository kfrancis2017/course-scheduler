package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import dgworks.*;

public class RoleController {

    @FXML
    private Button advisorBtn;

    @FXML
    private AnchorPane role_pane;

    @FXML
    private Button studentBtn;

    @FXML
    void btnAdvisorClicked(MouseEvent event) throws IOException {
        App.setRoot("advisor_login");
    }

    @FXML
    void btnStudentClicked(MouseEvent event) throws IOException {
        App.setUserAgentStylesheet("student_login");
    }

}
