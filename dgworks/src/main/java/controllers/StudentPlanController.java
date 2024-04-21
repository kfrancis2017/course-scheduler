package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import dgworks.App;
import model.*;

public class StudentPlanController implements Initializable {

    @FXML
    public Label lbl_description;

    @FXML
    public GridPane sem1;

    @FXML
    public GridPane sem2;

    @FXML
    public GridPane sem3;

    @FXML
    public GridPane sem4;

    @FXML
    public GridPane sem5;

    @FXML
    public GridPane sem6;

    @FXML
    public GridPane sem7;

    @FXML
    public GridPane sem8;

    @FXML
    public TextField txt_course;

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

    @FXML
    public void btnAdd(MouseEvent event) throws IOException {

    }

    @FXML
    public void btnGenPlan(MouseEvent event) throws IOException {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
