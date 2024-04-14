package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import dgworks.App;
import model.*;

public class StudentLoginController {

    @FXML
    private Label lbl_error;

    @FXML
    private TextField txt_password;

    @FXML
    private TextField txt_username;

    @FXML
    void back(MouseEvent event) throws IOException{
        App.setRoot("role");
    }

    @FXML
    void btnLoginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        DegreeWorks dg = DegreeWorks.getInstance();

        if (!dg.studentLogin(username, password)) {
            lbl_error.setText("Invalid login credentials");
            return;
        }

        App.setRoot("student_home");
    }

}
