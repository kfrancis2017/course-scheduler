package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import dgworks.App;
import model.*;

public class AdvisorLoginController implements Initializable {
    @FXML
    public TextField txt_username;
    @FXML
    public TextField txt_password;
    @FXML
    public Label lbl_error;

    @FXML
    public void btnLoginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

       DegreeWorks dg = DegreeWorks.getInstance();

        if (!dg.advisorLogin(username, password)) {
            lbl_error.setText("Invalid login credentials.");
            return;
        }
        dg.setAdvisor(dg.getAdvisor(username));

        App.setRoot("advisor_home");
    }

    @FXML
    public void back(MouseEvent event) throws IOException {
        App.setRoot("role");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
