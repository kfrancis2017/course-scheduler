package test;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

import degreeswork.Course;

public class testCourse {

    @Test
    public void testDefaultConstructor() {
        Course course = new Course();
        Assert.assertEquals("", course.getTitle());
        Assert.assertEquals("", course.getCourseID());
        Assert.assertEquals("", course.getDescription());
        Assert.assertTrue(course.getPrereq().isEmpty());
        Assert.assertTrue(course.getCoreq().isEmpty());
        Assert.assertEquals("", course.getAOS_Req());
        Assert.assertFalse(course.getCourseHolds());
    }

    @Test
    public void testParameterizedConstructor() {
        ArrayList<ArrayList<String>> prereq = new ArrayList<>();
        ArrayList<ArrayList<String>> coreq = new ArrayList<>();
        Course course = new Course("Math", "MATH101", "Introduction to Mathematics", prereq, coreq, "Mathematics", true,3);
        Assert.assertEquals("Math", course.getTitle());
        Assert.assertEquals("MATH101", course.getCourseID());
        Assert.assertEquals("Introduction to Mathematics", course.getDescription());
        Assert.assertEquals(prereq, course.getPrereq());
        Assert.assertEquals(coreq, course.getCoreq());
        Assert.assertEquals("Mathematics", course.getAOS_Req());
        Assert.assertTrue(course.getCourseHolds());
    }
}