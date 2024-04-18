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

public class AdvisorHomeController implements Initializable {
    
    @FXML
    public ListView<String> list_advisees;

    DegreeWorks dg = DegreeWorks.getInstance();

    @FXML
    public void viewNotes(MouseEvent event) {
    }

    @FXML
    public void viewPlans(MouseEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> advisees = dg.getAdvisees();

        list_advisees.getItems().addAll(advisees);
    }
}
