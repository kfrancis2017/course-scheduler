package java;

import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Course> currentCourses;
    private Major major;
    private ArrayList<String> advisingNotes;
    private String program;
    private String advisor;
    private double majorGPA;
    private double overallGPA;
    private double programCompletionPercentage;
    private double coreCompletionPercentage;
    private double degreeCompletionPercentage;
    private ArrayList<Course> finishedCourses;
    public ArrayList<String> dashboardWarning;

    public Student() {
       
    }

    public String viewCourseDetails(String courseID) {
       
        return "";
    }

    public String viewProgramRequirements() {
        
        return ""; 
    }

    public void changeProgram(String newData) {
        
    }

    public void updateStudentTranscript(String courseID, String grade) {
        
    }

    public void createSchedule() {
        
    }

    public void viewRecord() {
        
    }
}
