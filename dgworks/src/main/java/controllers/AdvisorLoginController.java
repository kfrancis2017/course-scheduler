package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import dgworks.App;
import model.*;

public class AdvisorLoginController implements Initializable {
    private DegreeWorks dg;
    private AdvisorHomeController homeController;
    private Advisor8SemController semController;

    @FXML
    public TextField txt_username;
    @FXML
    public TextField txt_password;
    @FXML
    public Label lbl_error;
    @FXML
    public Button loginbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void btnLoginClicked(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/dgworks/advisor_home.fxml"));
        loader.load();
        this.homeController = (AdvisorHomeController)loader.getController();
        
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/dgworks/advisor_8sem.fxml"));
        loader2.load();
        this.semController = (Advisor8SemController)loader2.getController();
    
        String username = txt_username.getText();
        String password = txt_password.getText();

       DegreeWorks dg = DegreeWorks.getInstance();

       if (!dg.advisorLogin(username, password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }
        
        dg.setAdvisor(dg.getAdvisor(username));

        homeController.setDegreeWorks(dg);
        semController.setDegreeWorks(dg);

        
        App.setRoot("advisor_home");

    }

    public DegreeWorks getDegreeWorks() {
        return this.dg;
    }

    @FXML
    public void back(MouseEvent event) throws IOException {
        App.setRoot("role");
    }
}
