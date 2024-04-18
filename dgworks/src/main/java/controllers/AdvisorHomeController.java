package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import dgworks.App;
import model.*;

public class AdvisorHomeController implements Initializable {
    
    @FXML
    public ListView<String> list_advisees;

    @FXML
    public Label lbl_name;

    DegreeWorks dg = DegreeWorks.getInstance();

    @FXML
    public void viewNotes(MouseEvent event) {
    }

    @FXML
    public void viewPlans(MouseEvent event) {
    }

    @FXML
    public void logout(MouseEvent event) throws IOException {
        dg.logout();
        App.setRoot("role");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbl_name.setText(dg.getAdvisorName());

        ArrayList<String> advisees = dg.getAdvisees();

        list_advisees.getItems().addAll(advisees);
    }
}
