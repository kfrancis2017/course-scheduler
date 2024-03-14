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

    /**
     * Adds a Course object to the list
     * @param course The Course object
     * @return False if null, true otherwise
     */
    public boolean addCourse(Course course) {
        if (course == null)
            return false;
        courses.add(course);
        return true;
    }

    /**
     * Creates a new Course object and adds to the list
     * @param coursename The name of the course
     * @param courseID The course identifier 
     * @param description The course description
     * @param prereq The course prerequisites
     * @param coreq The course corequisites
     * @param AOS_Req The Area of Study Requirements the course falls under
     * @return Boolean value of true
     */
    public boolean addCourse(String courseName, String courseID, String description, ArrayList<ArrayList<String>> prereq, ArrayList<ArrayList<String>> coreq, String AOS_Req) {
        courses.add(new Course(courseName, courseID, description, prereq, coreq, AOS_Req));
        return true;
    }

    /**
     * Replaces a old course with a new course in the list
     * @param newCourse The new Course object
     * @param oldCourse The old Course object
     * @return False if new = old, True if new != old
     */
    public boolean modifyCourse(Course newCourse, Course oldCourse) {
        if (newCourse == oldCourse)
            return false;
        courses.remove(oldCourse);
        courses.add(newCourse);
        return true;

    }

    /**
     * Removes a Course from the list
     * @param course The Course object
     * @return Boolean value representing the success of course deletion
     */
    public boolean deleteCourse(Course course) {
        if (course != findCourseByCode(course.getCourseID()))
            return false;
        courses.remove(course);
        return true;
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
