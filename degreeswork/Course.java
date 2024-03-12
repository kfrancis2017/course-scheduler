package degreeswork;

public class Course {
    
    public String courseName;
    public String courseID;
    public String description;
    public CourseList prereq;
    public CourseList coreq;
    public String AOS_Req;

    public Course(String coursename, String courseID, String description, CourseList prereq, CourseList coreq,
            String AOS_Req) {
        this.courseName = coursename;
        this.courseID = courseID;
        this.description = description;
        this.prereq = prereq;
        this.coreq = coreq;
        this.AOS_Req = AOS_Req;
    }

    public Course(String prereq, String grade, boolean pre) {

    }

    public Course(Course course) {
        
    }

    public Course() {
        this.prereq = new CourseList();
        this.coreq = new CourseList();
        this.AOS_Req = "";
        this.courseName = "";
        this.courseID = "";
        this.description = "";
    }

    // Setter for prereq
    public void setPrereq(CourseList prereq) {
        this.prereq = prereq;
    }

    // Setter for coreq
    public void setCoreq(CourseList coreq) {
        this.coreq = coreq;
    }

    // Setter for AOS_Req
    public void setAOS_Req(String AOS_Req) {
        this.AOS_Req = AOS_Req;
    }

    // Setter for courseName
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Setter for courseID
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
    
// Setter for prereq
public CourseList getPrereq(CourseList prereq) {
    return prereq;
}

// Setter for coreq
public CourseList getCoreq(CourseList coreq) {
    return coreq;
}

// Setter for AOS_Req
public String getAOS_Req(String AOS_Req) {
    return AOS_Req;
}

// Setter for courseName
public String getCourseName(String courseName) {
    return courseName;
}

// Setter for courseID
public String getCourseID() {
    return courseID;
}

// Setter for description
public String getDescription(String description) {
    return description;
}

    public boolean isAvailable(String semester) {
        return true;
    }

    public void updateCourseDetails(String updatedDetails, CourseList courseDB) {

    }

    public void displayCourseDetails() {

    }

    public boolean isEligible(CourseList courses, CourseList finishedCourses, Major major) {
        return true;
    }
}
