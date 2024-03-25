package degreeswork;

import java.util.ArrayList;

public class CourseList {
    private static CourseList courseList;
    private ArrayList<Course> courses;

    public CourseList() {
        courses = new ArrayList<Course>();
    }

    public CourseList(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public static CourseList getInstance() {
        if (courseList == null)
            courseList = new CourseList();
        return courseList;
    }

    public boolean addCourse(Course course) {
        if (course == null || findCourseByCode(course.getCourseID()) != null)
            return false;
        courses.add(course);
        return true;
    }

    public boolean addCourse(String title, String courseID, String description, ArrayList<ArrayList<String>> prereq, ArrayList<ArrayList<String>> coreq, String AOS_Req, boolean holds, int hours) {
        if (findCourseByCode(courseID) != null) return false;
        courses.add(new Course(title, courseID, description, prereq, coreq, AOS_Req, holds, hours));
        return true;
    }
    
    public boolean modifyCourse(Course newCourse, Course oldCourse) {
        if (newCourse == oldCourse)
            return false;
        int index = courses.indexOf(oldCourse);
        if(index != -1) {  // old course exists
            courses.set(index, newCourse);
            return true;
        }
        return false;
    }

    public boolean deleteCourse(Course course) {
        return courses.remove(course);
    }

    public Course findCourseByCode(String courseID) {
        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Course course : courses) {
            sb.append(course.getCourseID());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String allToString() {
        StringBuilder sb = new StringBuilder();
        for (Course course : courses) {
            sb.append(course.toString());
            sb.append("\n");
        }
        return sb.toString();        
    }
}
