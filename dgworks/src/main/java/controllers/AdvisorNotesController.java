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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import dgworks.App;
import model.*;

//
public class AdvisorNotesController implements Initializable {

    @FXML
    public GridPane grid_profile;
    
    @FXML
    public TextField txt_note;
    
    @FXML
    public TextField txt_search;

    @FXML
    public Label lbl_DNE;

    @FXML 
    public Label lbl_added;

    DegreeWorks dg = DegreeWorks.getInstance();
    
    @FXML
    public void btnSearch(MouseEvent event) throws IOException {
        String username = txt_search.getText();

        if (dg.getStudent(username) == null) {
            lbl_DNE.setText("Student DNE");
            return;
        } else {
            lbl_DNE.setText("");
        }

        dg.setStudent(dg.getStudent(username));

        VBox vbName = new VBox();

        Label student_username = new Label(" " + dg.getStudentName());

        vbName.getChildren().add(student_username);

        grid_profile.add(vbName, 1, 0);

        for (int i = 0; i < dg.getStudentInfo().size(); i++) {
            VBox vb = new VBox();

            String info = dg.getStudentInfo().get(i);

            String[] infoArr = info.split(":");

            Label student_info = new Label(infoArr[1]);

            vb.getChildren().add(student_info);

            grid_profile.add(student_info, 1, i+1);
        }
    }

    @FXML
    public void btnSubmit(MouseEvent event) throws IOException {
        String session = txt_note.getText();

        dg.addAdvisingNote(dg.mStudent, session);

        txt_note.setText("");

        lbl_added.setText("Note Added");
    }
    
    @FXML
    public void dashboard(MouseEvent event) throws IOException {
        App.setRoot("advisor_home");
    }
    
    @FXML
    public void viewPlans(MouseEvent event) throws IOException {
        App.setRoot("advisor_plans");
    }

    @FXML
    public void logout(MouseEvent event) throws IOException {
        dg.logout();
        App.setRoot("role");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
