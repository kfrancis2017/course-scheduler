package degreeswork;

import java.util.ArrayList;

import java.util.HashMap;

public class CourseList {
<<<<<<< HEAD
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
     * @param course
     * @return
     */
    public boolean addCourse(Course course) {
        if (course == null)
            return false;
        courses.add(course);
        return true;
    }

    /**
     * Creates a new Course object and adds to the list
     * @param coursename 
     * @param courseID
     * @param description
     * @param prereq
     * @param coreq
     * @param AOS_Req
     * @return
     */
    public boolean addCourse(String coursename, String courseID, String description, CourseList prereq, CourseList coreq, String AOS_Req) {
        courses.add(new Course(coursename, courseID, description, prereq, coreq, AOS_Req));
        return true;
    }

    public boolean modifyCourse(Course newCourse, Course oldCourse) {
        if (newCourse == oldCourse)
            return false;
        courses.remove(newCourse);
        courses.add(oldCourse);
        return true;

    }

    public boolean deleteCourse(Course course) {
        if (course != findCourseByCode(course.getCourseID()))
            return false;
        courses.remove(course);
        return true;
=======
    
    private static HashMap<String, Course>courseHash = new HashMap<String, Course>();
    private static ArrayList<Course> courses;
    
    public boolean addCourse(Course course) {
        courseHash.put(course.courseID, course);
        return false;
    }

    public boolean modifyCourse(Course newCourse, Course oldCourse) {
        courseHash.remove(oldCourse);
        courseHash.put(newCourse.courseID, newCourse);
        return false;
    }

    public boolean deleteCourse(Course course) {
        courseHash.remove(course);
        return false;
>>>>>>> 6b5331cad303fd6386e11a7b43d9d74df951a6d0
    }

    public Course findCourse(String courseID) {
        courseHash.get(courseID);
        return null;
    }
}