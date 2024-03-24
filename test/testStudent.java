package test;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import degreeswork.Student;

public class testStudent {
    
    @Test
    public void testUpdateStudentTranscript_AddNewCourse() {
        Student student = new Student();
        String courseID = "CS101";
        String grade = "A";

        student.updateStudentTranscript(courseID, grade);

        ArrayList<ArrayList<String>> finishedCourses = student.getFinishedCourses();
        Assert.assertEquals(1, finishedCourses.size());
        Assert.assertEquals(courseID, finishedCourses.get(0).get(0));
        Assert.assertEquals(grade, finishedCourses.get(0).get(1));
    }

    @Test
    public void testUpdateStudentTranscript_UpdateExistingCourseGrade() {
        Student student = new Student();
        String courseID = "CS101";
        String grade = "A";
        student.addFinishedCourse(courseID, "B");

        student.updateStudentTranscript(courseID, grade);

        ArrayList<ArrayList<String>> finishedCourses = student.getFinishedCourses();
        Assert.assertEquals(1, finishedCourses.size());
        Assert.assertEquals(courseID, finishedCourses.get(0).get(0));
        Assert.assertEquals(grade, finishedCourses.get(0).get(1));
    }

    @Test
    public void testViewRecord() {
        Student student = new Student("user123", "password", "John", "Doe");
        student.setProgram("Computer Science");
        student.addFinishedCourse("CS101", "A");
        student.addFinishedCourse("CS201", "B");

        // Redirect standard output to capture printed output
        System.out.println("---- Expected Output ----");
        System.out.println("Student Record for: John Doe");
        System.out.println("Major: Computer Science");
        System.out.println("Program: Computer Science");
        System.out.println("Completed Courses:");
        System.out.println("CS101\tA");
        System.out.println("CS201\tB");
        System.out.println("---- Actual Output ----");
        student.viewRecord();
    }
}
