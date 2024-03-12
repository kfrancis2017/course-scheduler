package degreeswork;

import java.util.ArrayList;

import java.util.HashMap;

public class CourseList {
    
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
    }

    public Course findCourse(String courseID) {
        courseHash.get(courseID);
        return null;
    }
}