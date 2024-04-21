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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import dgworks.App;
import model.*;

public class Advisor8SemController implements Initializable {
    @FXML
    public GridPane grid_advisees;

    @FXML
    public GridPane sem1;
    private ArrayList<Course> semester1;

    private ArrayList<Course> fakeCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        // Create 6 fake course objects
        Course course1 = new Course("CSCI101");
        Course course2 = new Course("MATH101");
        Course course3 = new Course("PHYS101");
        Course course4 = new Course("ENG101");
        Course course5 = new Course("HIST101");
        Course course6 = new Course("ART101");
        
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        
        return courses;
    }

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
    private Student student = dg.getStudent("dspears");

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
    clearAll();        
        Scheduler scheduler = new Scheduler(student.getMajor(), student, dg.getCourses());
        ArrayList<ArrayList<Course>> schedule = new ArrayList<ArrayList<Course>>();

        //First populate finished courses
        if(student.getFinishedCourses().size() > 0){
            schedule.add(student.getFinishedCourseObjects(dg.getCourses()));
        }

        //Then populate current courses
        if(student.getCurrentCourses().size() > 0){
            schedule.add(student.getCurrentCourseObjects(dg.getCourses()));
        } 

        //Then populate future courses
        for (int i = 0; i < (scheduler.createSchedule().size()); i++) {
            schedule.add(scheduler.createNextSchedule(student).get(i));
        }

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
    public void createFutureSemesters() {
        clearAll();
        Scheduler scheduler = new Scheduler(student.getMajor(), student, dg.getCourses());
        ArrayList<ArrayList<Course>> schedule = scheduler.createNextSchedule(student);
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

    public void clearAll() {
        sem1.getChildren().clear();
        sem2.getChildren().clear();
        sem3.getChildren().clear();
        sem4.getChildren().clear();
        sem5.getChildren().clear();
        sem6.getChildren().clear();
        sem7.getChildren().clear();
        sem8.getChildren().clear();
    }


    @FXML
    public void createSem1() {
        sem1.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester1.size(); i++) {
            VBox vbox = new VBox();
            Course thisCourse = semester1.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester1.get(i).getHours() + "hrs)");
            student.updateFinishedCourseObjects(dg.getCourses());
            for (Course c : student.getCompletedCourses()) {
                if(thisCourse.equals(c.getCourseID())){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem1.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }

    @FXML
    public void createSem2() {
        sem2.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester2.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester2.get(i).getCourseID() + " (" + semester2.get(i).getHours() + "hrs)");
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem2.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }

    @FXML
    public void createSem3() {
        sem3.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester3.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester3.get(i).getCourseID() + " (" + semester3.get(i).getHours() + "hrs)");
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem3.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }

    @FXML
    public void createSem4() {
        sem4.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester4.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester4.get(i).getCourseID() + " (" + semester4.get(i).getHours() + "hrs)");
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem4.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }

    @FXML

    public void createSem5() {
        sem5.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester5.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester5.get(i).getCourseID() + " (" + semester5.get(i).getHours() + "hrs)");
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem5.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }

    @FXML
    public void createSem6() {
        sem6.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester6.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester6.get(i).getCourseID() + " (" + semester6.get(i).getHours() + "hrs)");
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem6.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }

    @FXML
    public void createSem7() {
        sem7.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester7.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester7.get(i).getCourseID() + " (" + semester7.get(i).getHours() + "hrs)");
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem7.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }

    @FXML
    public void createSem8() {
        sem8.getChildren().clear();
        int columnCount = 0;
        int rowCount = 0;
        for (int i = 0; i < semester8.size(); i++) {
            VBox vbox = new VBox();
            Label course = new Label(semester8.get(i).getCourseID() + " (" + semester8.get(i).getHours() + "hrs)");
            vbox.getChildren().add(course);
            vbox.setAlignment(javafx.geometry.Pos.CENTER);
            sem8.add(vbox, columnCount, rowCount);
            columnCount++;
            if (columnCount == 3) {
                columnCount = 0;
                rowCount++;
            }
        }
    }
}
