package test;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import degreeswork.Course;
import degreeswork.Major;

public class testMajor {
    
    @Test
    public void testConstructor() {
        String majorName = "Computer Science";
        Major major = new Major(majorName);
        Assert.assertEquals(majorName, major.getName());
        Assert.assertTrue(major.getCourses().isEmpty());
    }

    @Test
    public void testAddCourse() {
        Major major = new Major("Computer Science");
        Course course1 = new Course("Intro to CS", "CS101", "Introduction to Computer Science", new ArrayList<>(), new ArrayList<>(), "", true);
        Course course2 = new Course("Data Structures", "CS201", "Data Structures and Algorithms", new ArrayList<>(), new ArrayList<>(), "", true);

        major.addCourse(course1);
        major.addCourse(course2);

        ArrayList<Course> courses = major.getCourses();
        Assert.assertEquals(2, courses.size());
        Assert.assertTrue(courses.contains(course1));
        Assert.assertTrue(courses.contains(course2));
    }

    @Test
    public void testToString() {
        String majorName = "Computer Science";
        Major major = new Major(majorName);
        Assert.assertEquals(majorName, major.toString());
    }
}
