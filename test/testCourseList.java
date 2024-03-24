package test;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import degreeswork.Course;
import degreeswork.CourseList;

public class testCourseList {
    
    @Test
    public void testAddCourse() {
        CourseList courseList = CourseList.getInstance();
        Course course1 = new Course("Math", "MATH101", "Introduction to Mathematics", new ArrayList<>(), new ArrayList<>(), "Mathematics", true);
        Course course2 = new Course("Physics", "PHYS101", "Introduction to Physics", new ArrayList<>(), new ArrayList<>(), "Physics", true);

        Assert.assertTrue(courseList.addCourse(course1));
        Assert.assertTrue(courseList.addCourse(course2));
        Assert.assertFalse(courseList.addCourse(course1)); // Adding duplicate course should fail
    }

    @Test
    public void testModifyCourse() {
        CourseList courseList = CourseList.getInstance();
        Course oldCourse = new Course("Math", "MATH101", "Introduction to Mathematics", new ArrayList<>(), new ArrayList<>(), "Mathematics", true);
        courseList.addCourse(oldCourse);

        Course newCourse = new Course("Advanced Math", "MATH201", "Advanced Mathematics", new ArrayList<>(), new ArrayList<>(), "Mathematics", true);
        Assert.assertTrue(courseList.modifyCourse(newCourse, oldCourse));
    }

    @Test
    public void testDeleteCourse() {
        CourseList courseList = CourseList.getInstance();
        Course course = new Course("Math", "MATH101", "Introduction to Mathematics", new ArrayList<>(), new ArrayList<>(), "Mathematics", true);
        courseList.addCourse(course);

        Assert.assertTrue(courseList.deleteCourse(course));
        Assert.assertFalse(courseList.deleteCourse(course)); // Deleting the same course again should fail
    }

    @Test
    public void testFindCourseByCode() {
        CourseList courseList = CourseList.getInstance();
        Course course = new Course("Math", "MATH101", "Introduction to Mathematics", new ArrayList<>(), new ArrayList<>(), "Mathematics", true);
        courseList.addCourse(course);

        Course foundCourse = courseList.findCourseByCode("MATH101");
        Assert.assertEquals(course, foundCourse);
    }

    @Test
    public void testGetCourses() {
        CourseList courseList = CourseList.getInstance();
        Course course1 = new Course("Math", "MATH101", "Introduction to Mathematics", new ArrayList<>(), new ArrayList<>(), "Mathematics", true);
        Course course2 = new Course("Physics", "PHYS101", "Introduction to Physics", new ArrayList<>(), new ArrayList<>(), "Physics", true);

        courseList.addCourse(course1);
        courseList.addCourse(course2);

        ArrayList<Course> courses = courseList.getCourses();
        Assert.assertEquals(2, courses.size());
        Assert.assertTrue(courses.contains(course1));
        Assert.assertTrue(courses.contains(course2));
    }
}
