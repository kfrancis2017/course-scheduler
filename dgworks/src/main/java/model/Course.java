package model;

import java.util.ArrayList;

public class Course {

    private String title;
    private String courseID;
    private String description;
    private ArrayList<ArrayList<String>> prereq; // ArrayList of ArrayList to represent ANDs of ORs logic.
    private ArrayList<ArrayList<String>> coreq; // Same structure for corequisites.
    private String AOS_Req;
    private boolean courseHolds;
    private int hours;

    public Course() {
        this.prereq = new ArrayList<>();
        this.coreq = new ArrayList<>();
        this.AOS_Req = "";
        this.title = "";
        this.courseID = "";
        this.description = "";
        this.courseHolds = false;
        this.hours = 0;
    }

    public Course(String title, String courseID, String description, ArrayList<ArrayList<String>> prereq, ArrayList<ArrayList<String>> coreq, String AOS_Req, boolean courseHolds, int hours) {
        this.title = title;
        this.courseID = courseID;
        this.description = description;
        this.prereq = prereq;
        this.coreq = coreq;
        this.AOS_Req = AOS_Req;
        this.courseHolds = courseHolds;
        this.hours = hours;
    }

    // Getters
    public String getTitle() {
        return title;
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

    public ArrayList<ArrayList<String>> getPrereqClean() {//this is for SCHEDULING PURPOSES PRIMARILY
        // Iterate over each ArrayList<String> in the outer list
        for (ArrayList<String> preReq : prereq) {
            // Iterate over each String in the inner ArrayList
            for (int i = 0; i < preReq.size(); i++) {
                String currentString = preReq.get(i);
                int indexOfTab = currentString.indexOf('\t');
                // If a tab character is found, substring from the beginning to the tab index
                if (indexOfTab != -1) {
                    preReq.set(i, currentString.substring(0, indexOfTab));
                }
            }
        }
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

    public int getHours() {
        return hours;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
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

    public void setCourseHolds(boolean courseHolds) {
        this.courseHolds = courseHolds;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return courseID+" - "+title;
    }

}
