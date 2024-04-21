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

    @FXML
    public GridPane sem1;
    private ArrayList<Course> semester1;

    @FXML
    public GridPane sem2;
    private ArrayList<Course> semester2;

    @FXML
    public GridPane sem3;
    private ArrayList<Course> semester3;

    @FXML
    public GridPane sem4;
    private ArrayList<Course> semester4;

    @FXML
    public GridPane sem5;
    private ArrayList<Course> semester5;

    @FXML
    public GridPane sem6;
    private ArrayList<Course> semester6;

    @FXML
    public GridPane sem7;
    private ArrayList<Course> semester7;

    @FXML
    public GridPane sem8;
    private ArrayList<Course> semester8;

    private DegreeWorks dg = DegreeWorks.getInstance();

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
        for (int i = 0; i < dg.getAdvisees().size(); i++) {
            VBox vbox = new VBox();
            Label student_username = new Label(dg.getAdvisees().get(i));

            vbox.getChildren().add(student_username);

            grid_advisees.add(vbox, 0, i);
            this.createSemesters();
            this.createSem1();
            this.createSem2();
            this.createSem3();
            this.createSem4();
            this.createSem5();
            this.createSem6();
            this.createSem7();
            this.createSem8();       
        }
    }

    @FXML
    public void createSemesters() {
        sem1.getChildren().clear();
        //HARDCODED
        Student student = dg.getStudent("dspears");
        Scheduler scheduler = new Scheduler(student.getMajor(), student, dg.getCourses());
        ArrayList<ArrayList<Course>> schedule = scheduler.createSchedule();
        System.out.println(schedule);
        for (int i = 0; i < schedule.size(); i++) {
            switch (i) {
                case 0:
                    semester1 = schedule.get(i);
                    break;
                case 1:
                    semester2 = schedule.get(i);
                    break;
                case 2:
                    semester3 = schedule.get(i);
                    break;
                case 3:
                    semester4 = schedule.get(i);
                    break;
                case 4:
                    semester5 = schedule.get(i);
                    break;
                case 5:
                    semester6 = schedule.get(i);
                    break;
                case 6:
                    semester7 = schedule.get(i);
                    break;
                case 7:
                    semester8 = schedule.get(i);
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    public void createSem1() {
        sem1.getChildren().clear();
        for (int i = 0; i < semester1.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester1.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester1.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem1.add(vbox, 0, i);
        }
    }

    @FXML
    public void createSem2() {
        sem2.getChildren().clear();
        for (int i = 0; i < semester2.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester2.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester2.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem2.add(vbox, 0, i);
        }
    }

    @FXML
    public void createSem3() {
        sem3.getChildren().clear();
        for (int i = 0; i < semester3.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester3.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester3.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem3.add(vbox, 0, i);
        }
    }

    @FXML
    public void createSem4() {
        sem4.getChildren().clear();
        for (int i = 0; i < semester4.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester4.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester4.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem4.add(vbox, 0, i);
        }
    }

    @FXML
    public void createSem5() {
        sem5.getChildren().clear();
        for (int i = 0; i < semester5.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester5.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester5.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem5.add(vbox, 0, i);
        }
    }

    @FXML
    public void createSem6() {
        sem6.getChildren().clear();
        for (int i = 0; i < semester6.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester6.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester6.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem6.add(vbox, 0, i);
        }
    }

    @FXML
    public void createSem7() {
        sem7.getChildren().clear();
        for (int i = 0; i < semester7.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester7.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester7.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem7.add(vbox, 0, i);
        }
    }

    @FXML
    public void createSem8() {
        sem8.getChildren().clear();
        for (int i = 0; i < semester8.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester8.get(i).getCourseID());
            Label credits = new Label("Credits: " + semester8.get(i).getHours());
            vbox.getChildren().add(course);
            vbox.getChildren().add(credits);
            sem8.add(vbox, 0, i);
        }
    }


}
