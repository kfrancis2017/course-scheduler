package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import dgworks.App;
import model.*;

public class StudentNotesController implements Initializable {

    @FXML
    public ListView<String> list_notes;

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
    public void viewPlans(MouseEvent event) throws IOException {
        App.setRoot("student_plan");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ArrayList<String> notes = dg.getNotes();
        list_notes.getItems().addAll(notes);
    }
}
