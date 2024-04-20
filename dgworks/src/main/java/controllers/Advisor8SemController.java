package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import dgworks.App;
import model.*;

public class Advisor8SemController implements Initializable {
    @FXML
    public GridPane grid_advisees;

    private DegreeWorks dg;

    public void setDegreeWorks(DegreeWorks dg) {
        this.dg = dg;
    }

    public DegreeWorks getDegreeWorks() {
        return this.dg;
    }

    @FXML
    public void dashboard(MouseEvent event) throws IOException {
        App.setRoot("advisor_home");
    }

    @FXML
    public void viewNotes(MouseEvent event) throws IOException {
        App.setRoot("advisor_notes");
    }

    @FXML
    public void logout(MouseEvent event) throws IOException {
        dg.logout();
        App.setRoot("role");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (dg!=null) {
            for (int i = 0; i < dg.getAdvisees().size(); i++) {
                VBox vbox = new VBox();
                Label student_username = new Label(dg.getAdvisees().get(i));

                vbox.getChildren().add(student_username);

                grid_advisees.add(vbox, 0, i);
                
            }
        } else {
            System.out.println("DegreeWorks is null");
        }
    }


}
