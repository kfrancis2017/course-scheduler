package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import dgworks.App;
import model.*;

public class StudentPlanController implements Initializable {

    DegreeWorks dg = DegreeWorks.getInstance();

    @FXML
    public void dashboard(MouseEvent event) throws IOException {
        App.setRoot("student_home");
    }

    @FXML
    public void logout(MouseEvent event) throws IOException {
        dg.logout();
        App.setRoot("role");
    }

    @FXML
    public void viewNotes(MouseEvent event) throws IOException {
        App.setRoot("student_notes");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
