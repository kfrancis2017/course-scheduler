package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import dgworks.App;
import model.*;

public class StudentHomeController implements Initializable {

    DegreeWorks dg = DegreeWorks.getInstance();

    @FXML
    public Label lbl_name;

    @FXML
    public void logout(MouseEvent event) throws IOException {
        dg.logout();
        App.setRoot("role");
    }

    @FXML
    public void viewNotes(MouseEvent event) throws IOException {
        App.setRoot("student_notes");
    }

    @FXML
    public void viewPlans(MouseEvent event) throws IOException {
        App.setRoot("student_plan");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_name.setText(dg.getStudentName());
    }

}
