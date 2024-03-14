package degreeswork;

import java.util.ArrayList;

public class Course {

    private String courseName;
    private String courseID;
    private String description;
    private ArrayList<ArrayList<String>> prereq; // ArrayList of ArrayList to represent ANDs of ORs logic.
    private ArrayList<ArrayList<String>> coreq; // Same structure for corequisites.
    private String AOS_Req; 
    private boolean courseHolds;


    public Course() {
        this.prereq = new ArrayList<>();
        this.coreq = new ArrayList<>();
        this.AOS_Req = "";
        this.courseName = "";
        this.courseID = "";
        this.description = "";
        this.courseHolds = false;
    }

    public Course(String courseName, String courseID, String description, ArrayList<ArrayList<String>> prereq, ArrayList<ArrayList<String>> coreq, String AOS_Req, boolean holds) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.description = description;
        this.prereq = prereq;
        this.coreq = coreq;
        this.AOS_Req = AOS_Req;
        this.courseHolds = holds;
    }

    // Getters
    public String getTitle() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<ArrayList<String>> getPrereq() {
        return prereq;
    }

    public ArrayList<ArrayList<String>> getCoreq() {
        return coreq;
    }

    public String getAOS_Req() {
        return AOS_Req;
    }

    public boolean getCourseHolds() {
        return courseHolds;
    }

    // Setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setTitle(String courseName) {
        this.courseName = courseName;        
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrereq(ArrayList<ArrayList<String>> prereq) {
        this.prereq = prereq;
    }

    public void setCoreq(ArrayList<ArrayList<String>> coreq) {
        this.coreq = coreq;
    }

    public void setAOS_Req(String AOS_Req) {
        this.AOS_Req = AOS_Req;
    }
    
    public void setCourseHolds(boolean holds) {
        this.courseHolds = holds;
    }
    // Additional methods might go here, such as isAvailable, updateCourseDetails, displayCourseDetails, isEligible, etc.
}
