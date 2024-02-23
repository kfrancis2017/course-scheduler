package stubs;

public class Course {
    
    public String courseName;
    public String courseID;
    public String description;
    public CourseList prereq;
    public CourseList coreq;
    public String AOS_Req;

    public Course(String coursename, String courseID, String description, CourseList prereq, CourseList coreq, String AOS_Req) {

    }

    public Course(Course course) {
        
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
