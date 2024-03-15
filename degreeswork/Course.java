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
    
    public String toString() {
        //to string: courseID | courseName
        //tostring description
        //tostring AOS req and holds
        //tostring prereq, with the ANDs being the outside arraylist, and the ors bing the inside one
        //tostring coreq, same as above
        StringBuffer sb = new StringBuffer();
        sb.append(courseID);
        sb.append(" | ");
        sb.append(courseName);
        sb.append("\n");
        sb.append(description);
        sb.append("\n");
        sb.append(AOS_Req);
        sb.append(" ");
        sb.append(courseHolds);
        sb.append("\n");
        // Initialize a flag to check if it's the first group
        boolean isFirstGroup = true;
        for (ArrayList<String> andArr : prereq) {
            if (!isFirstGroup) sb.append(" and ");
            isFirstGroup = false; // After the first group, set this to false
            boolean isFirstItem = true;
            for (String orArr : andArr) {
                if (!isFirstItem) sb.append(" or ");
                isFirstItem = false; // After the first item, set this to false
                sb.append(orArr);
            }
        }
        sb.append("\n");

        isFirstGroup = true;
        for (ArrayList<String> andArr : coreq) {
            if (!isFirstGroup) sb.append(" and ");
            isFirstGroup = false; // After the first group, set this to false
            boolean isFirstItem = true;
            for (String orArr : andArr) {
                if (!isFirstItem) sb.append(" or ");
                isFirstItem = false; // After the first item, set this to false
                sb.append(orArr);
            }
        }
        return sb.toString();
    }
    // Additional methods might go here, such as isAvailable, updateCourseDetails, displayCourseDetails, isEligible, etc.
}
