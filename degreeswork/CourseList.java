package degreeswork;

import java.util.HashMap;
import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;
    private HashMap<String, Course> coursesByCode;

    /**
     * Initializes a static CourseList
     */
    public CourseList() {
        courses = new ArrayList<Course>();
        coursesByCode = new HashMap<String, Course>();
    }

    /**
     * Return static CourseList if one does not exist
     * @return Static CourseList
     */
    public static CourseList getInstance() {
        if (courseList == null)
            courseList = new CourseList();
        return courseList;
    }

    public boolean addCourse(Course course) {
        return false;
    }

    public boolean addCourse(String coursename, String courseID, String description, CourseList prereq, CourseList coreq, String AOS_Req) {
        return true;
    }

    public boolean modifyCourse(Course newCourse, Course oldCourse) {
        return false;
    }

    public boolean deleteCourse(Course course) {
        return false;
    }

    /**
     * Utilizes the HashMap to find courses by their "key"
     * @param courseID The "key" to access elements of the HashMap
     * @return The desired Course
     */
    public Course findCourseByCode(String courseID) {
        loadHashMap();
        return coursesByCode.get(courseID);
    }

    /**
     * Transfers the ArrayList of Courses into the Hashmap
     */
    public void loadHashMap() {

        for (Course course : courses) {
            coursesByCode.put(course.getCourseID(), course);
        }

    }
}
