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
import dgworks.App;
import model.*;

public class AdvisorHomeController implements Initializable {
    @FXML
    public ListView<String> list_advisees;

    @FXML
    public Label lbl_name;

    @FXML
    public Label lbl_info;

    private DegreeWorks dg;

    public void setDegreeWorks(DegreeWorks dg) {
        this.dg = dg;
    }

    public DegreeWorks getDegreeWorks() {
        return this.dg;
    }

    @FXML
    public void viewNotes(MouseEvent event) {
    }

    @FXML
    public void viewPlans(MouseEvent event) throws IOException{
        App.setRoot("advisor_8sem");
    }

    @FXML
    public void logout(MouseEvent event) throws IOException {
        dg.logout();
        App.setRoot("role");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (dg != null) {
            
            lbl_name.setText(dg.getAdvisorName());
    
            String info = "";
    
            for (String s : dg.getAdvisorInfo()) {
                info += s + "\n";
            }
    
            lbl_info.setText(info);
    
            ArrayList<String> advisees = dg.getAdvisees();
    
            list_advisees.getItems().addAll(advisees);
        } else {
            System.out.println("DegreeWorks object is null.");
        }

    }
}
