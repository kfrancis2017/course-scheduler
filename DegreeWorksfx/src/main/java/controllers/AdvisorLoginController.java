package org.openjfx.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import library.DegreeworksApp;
import model.*;

public class AdvisorLoginController implements Initializable {
    @FXML
    private TextField txt_username;
    @FXML
    private TextField txt_password;
    @FXML
    private Label lbl_error;

    @FXML
    private void btnLoginClicked(MouseEvent event) throws IOException {
        String username = txt_username.getText();
        String password = txt_password.getText();

        DegreeWorks dgworks = DegreeWorks.getInstance();

        if(!dgworks.advisorLogin(username, password)) {
            lbl_error.setText("Invalid login credentials");
            return;
        }

        App.setRoot("advisor_home");
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        App.setRoot("role");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }
    
}
