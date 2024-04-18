package controllers;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dgworks.App;
import javafx.fxml.Initializable;
import model.DegreeWorks;

public class Advisor8SemController implements Initializable {

    @FXML
    private VBox courseLabels;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DegreeWorks dg = DegreeWorks.getInstance();
        courseLabels.getChildren().add(new Label("CSC 101"));
        courseLabels.getChildren().add(new Label("CSC 101"));

    }
    @FXML
    void viewNotes(MouseEvent event) {
    }

    DegreeWorks dg = DegreeWorks.getInstance();

    @FXML
    public void dashboard(MouseEvent event) throws IOException {
        App.setRoot("advisor_home");
    }

    @FXML
    void viewPlans(MouseEvent event) {

    }
}