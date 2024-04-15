package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import dgworks.App;
import model.*;

public class RoleController implements Initializable {

    @FXML
    public void onStudentClicked(ActionEvent event) throws IOException {
        App.setRoot("student_login");
    }

    @FXML
    public void onAdvisorClicked(ActionEvent event) throws IOException {
        App.setRoot("advisor_login");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}