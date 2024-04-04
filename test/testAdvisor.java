package test;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import degreeswork.Advisor;
import degreeswork.Student;

public class testAdvisor {
    
    @Test
    public void testAdvisorConstructor() {
        Advisor advisor = new Advisor("advisor", "password", "John", "Doe");
        Assert.assertEquals("advisor", advisor.getUsername());
        Assert.assertEquals("password", advisor.getPassword());
        Assert.assertEquals("John", advisor.getFirstName());
        Assert.assertEquals("Doe", advisor.getLastName());
    }

    @Test
    public void testAddAdvisee() {
        Advisor advisor = new Advisor();
        Student student = new Student("student", "password", "Alice", "Smith");
        advisor.addAdvisee(student);
        System.out.println(advisor.getAdviseeList());
        Assert.assertTrue(advisor.getAdviseeList().contains("student"));
    }

    @Test
    public void testGetAdviseeList() {
        Advisor advisor = new Advisor();
        Student student1 = new Student("student1", "password", "Alice", "Smith");
        Student student2 = new Student("student2", "password", "Bob", "Johnson");
        advisor.addAdvisee(student1);
        advisor.addAdvisee(student2);
        ArrayList<String> adviseeList = advisor.getAdviseeList();
        Assert.assertEquals(2, adviseeList.size());
        Assert.assertTrue(adviseeList.contains("student1"));
        Assert.assertTrue(adviseeList.contains("student2"));
    }

    @Test
    public void testGetAdvisee() {
        Advisor advisor = new Advisor();
        Student student = new Student("student", "password", "Alice", "Smith");
        advisor.addAdvisee(student);
        Student retrievedStudent = advisor.getAdvisee("student");
        Assert.assertEquals(student, retrievedStudent);
    }

    @Test
    public void testGetAdviseeDetails() {
        Advisor advisor = new Advisor();
        Student student = new Student("student", "password", "Alice", "Smith");
        advisor.addAdvisee(student);
        String adviseeDetails = advisor.getAdviseeDetails(student);
        Assert.assertTrue(adviseeDetails.contains("student"));
        Assert.assertTrue(adviseeDetails.contains("Alice"));
        Assert.assertTrue(adviseeDetails.contains("Smith"));
    }

    @Test
    public void testAddAdvisingSession() {
        Advisor advisor = new Advisor();
        Student student = new Student("student", "password", "Alice", "Smith");
        advisor.addAdvisingSession(student, "Session notes");
        Assert.assertEquals(advisor.getUsername() + " said: Session notes on " + new java.util.Date(), student.getAdvisingNotes().get(0));
    }

    @Test
    public void testSetAdvisorSpecialization() {
        Advisor advisor = new Advisor();
        advisor.setAdvisorSpecialization("Computer Science");
        Assert.assertEquals("Computer Science", advisor.getAdvisorSpecialization());
    }
}
