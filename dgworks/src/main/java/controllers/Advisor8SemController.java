package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private Student student = dg.mStudent;

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

    @FXML
    public void generate() {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < dg.getAdvisees().size(); i++) {
            VBox vbox = new VBox();
            Label student_username = new Label(dg.getAdvisees().get(i));

            student_username.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    student = UserList.getInstance().searchStudent(student_username.getText());
                    generate();
                }
            });

            vbox.getChildren().add(student_username);

            grid_advisees.add(vbox, 0, i);
                   
        }
    }

    @FXML
    public void createSemesters() {
    clearAll();        
        Scheduler scheduler = new Scheduler(student.getMajor(), student, dg.getCourses());
        ArrayList<ArrayList<Course>> schedule = new ArrayList<ArrayList<Course>>();
        for (int i = 0; i < 8; i++) {
            schedule.add(new ArrayList<Course>());
        }

        //First populate finished courses
        if(student.getFinishedCourses().size() > 0){
            for(ArrayList<String> list : student.getFinishedCourses()) {
                schedule.get(Integer.parseInt(list.get(2))-1).add(dg.getAllCourses().findCourseByCode(list.get(0)));
            }       
        }

        for (int i = schedule.size() - 1; i >= 0; i--) {
            if (schedule.get(i).isEmpty()) {
                schedule.remove(i);
            }
        } 

        //Then populate current courses
        if(student.getCurrentCourses().isEmpty() == false){
            ArrayList<Course> current = new ArrayList<Course>();
            for(String c : student.getCurrentCourses()) {
                current.add(dg.getAllCourses().findCourseByCode(c));
            }
            schedule.add(current);
        } 

        //Then populate future courses
        for (int i = 0; i < (scheduler.createNextSchedule(student).size()); i++) {
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

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
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
            Course thisCourse = semester2.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester2.get(i).getHours() + "hrs)");

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
                }
            }

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
            Course thisCourse = semester3.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester3.get(i).getHours() + "hrs)");

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
                }
            }

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
            Course thisCourse = semester4.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester4.get(i).getHours() + "hrs)");

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
                }
            }

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
            Course thisCourse = semester5.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester5.get(i).getHours() + "hrs)");

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
                }
            }

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
            Course thisCourse = semester6.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester6.get(i).getHours() + "hrs)");

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
                }
            }

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
            Course thisCourse = semester7.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester7.get(i).getHours() + "hrs)");

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
                }
            }

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
            Course thisCourse = semester8.get(i);
            Label course = new Label(thisCourse.getCourseID() + " (" + semester8.get(i).getHours() + "hrs)");

            //Colors!
            for (ArrayList<String> list : student.getFinishedCourses()) {
                if(thisCourse.getCourseID().equals(list.get(0))){
                    course.setStyle("-fx-background-color: #00FF00");
                }
            }
            for (String c : student.getCurrentCourses()) {
                if(thisCourse.getCourseID().equals(c)){
                    course.setStyle("-fx-background-color: #FFFF00");
                }
            }

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
