package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;
import dgworks.App;
import model.*;

public class StudentHomeController implements Initializable {

    DegreeWorks dg = DegreeWorks.getInstance();

    @FXML
    public Label lbl_name;
    
    @FXML
    public ListView list_cc;

    @FXML
    public Label lbl_info;

    @FXML
    public ListView list_trans;

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

        String info = "";

        for (String s : dg.getStudentInfo()) {
            info += s + "\n";
        }

        lbl_info.setText(info);

        list_cc.getItems().addAll(dg.getCurrentCourses());

        list_trans.getItems().addAll(dg.getStudentTranscript());

    }

}
