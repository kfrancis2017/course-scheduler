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
        Course course1 = new Course("Intro to CS", "CS101", "Introduction to Computer Science", new ArrayList<>(), new ArrayList<>(), "", true,3);
        Course course2 = new Course("Data Structures", "CS201", "Data Structures and Algorithms", new ArrayList<>(), new ArrayList<>(), "", true,3);

        major.addCourse(course1);
        major.addCourse(course2);

        ArrayList<ArrayList<Course>> courses = major.getCourses();
        Assert.assertEquals(2, courses.size());
        boolean foundCourse1 = false;
        boolean foundCourse2 = false;
        for (ArrayList<Course> courseList : courses) {
            if (courseList.contains(course1)) {
                foundCourse1 = true;
            }
            if (courseList.contains(course2)) {
                foundCourse2 = true;
            }
        }
        Assert.assertTrue(foundCourse1);
        Assert.assertTrue(foundCourse2);
        
    }

    @Test
    public void testToString() {
        String majorName = "Computer Science";
        Major major = new Major(majorName);
        Assert.assertEquals(majorName, major.toString());
    }
}
