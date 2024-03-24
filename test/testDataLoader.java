package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import degreeswork.*;



public class testDataLoader {

@Test
    public void testGetAllCourses() {
        // Load the expected course data from the provided JSON entry
        Course expectedCourse = loadExpectedCourse();

        // Load courses from DataLoader
        DataLoader.getAllCourses();

        // Retrieve the courses from the CourseList
        ArrayList<Course> courses = CourseList.getInstance().getCourses();
        assertNotNull(courses);

        // Check if the expected course is in the CourseList
        assertTrue("Course MATH141 is not found in the CourseList", courses.contains(expectedCourse));
    }

    // Helper method to load the expected course data from JSON
    private Course loadExpectedCourse() {
        JSONParser parser = new JSONParser();
        try {
            // Read the JSON entry for the expected course
            JSONObject courseData = (JSONObject) parser.parse(new FileReader("json/newcourse.json"));

            // Create a Course object using the JSON data
            Course course = new Course();
            course.setCourseID((String) courseData.get("courseID"));
            course.setTitle((String) courseData.get("title"));
            course.setDescription((String) courseData.get("description"));
            // Set other attributes of the course as needed

            return course;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testGetAllStudents() {
        // Load students from DataLoader
        DataLoader.getAllStudents();
        
        // Retrieve the students from the UserList
        ArrayList<Student> students = UserList.getInstance().getStudents();
        assertNotNull(students);

        // Assert that the list is not empty
        assertFalse("Student list is empty", students.isEmpty());

        // Add more assertions to verify the correctness of the loaded students
        for (Student student : students) {
            assertNotNull("Student ID is null", student.getUserID());
            assertNotNull("Student username is null", student.getUsername());
            assertNotNull("Student password is null", student.getPassword());
            assertNotNull("Student first name is null", student.getFirstName());
            assertNotNull("Student last name is null", student.getLastName());
            assertNotNull("Student email is null", student.getEmail());
            assertNotNull("Student major is null", student.getMajor());
            assertNotNull("Student current semester is null", student.getCurrentSemester());
            assertNotNull("Student program is null", student.getProgram());
            assertNotNull("Student advisor is null", student.getAdvisor());
            assertNotNull("Student finished courses list is null", student.getFinishedCourses());
            assertNotNull("Student dashboard warnings list is null", student.getDashboardWarnings());
            // Add more assertions as needed
        }
    }

    @Test
    public void testGetAllAdvisors() {
        // Load advisors from DataLoader
        DataLoader.getAllAdvisors();
        
        // Retrieve the advisors from the UserList
        ArrayList<Advisor> advisors = UserList.getInstance().getAdvisors();
        assertNotNull(advisors);

        // Assert that the list is not empty
        assertFalse("Advisor list is empty", advisors.isEmpty());

        // Add more assertions to verify the correctness of the loaded advisors
        for (Advisor advisor : advisors) {
            assertNotNull("Advisor ID is null", advisor.getUserID());
            assertNotNull("Advisor username is null", advisor.getUsername());
            assertNotNull("Advisor password is null", advisor.getPassword());
            assertNotNull("Advisor first name is null", advisor.getFirstName());
            assertNotNull("Advisor last name is null", advisor.getLastName());
            assertNotNull("Advisor advisee list is null", advisor.getAdviseeList());
            // Add more assertions as needed
        }
    }

    @Test
    public void testGetAllMajors() {
        // Load majors from DataLoader
        DataLoader.getAllMajors();
        
        // Retrieve the majors from the MajorList
        ArrayList<Major> majors = MajorList.getInstance().getMajors();
        assertNotNull(majors);

        // Assert that the list is not empty
        assertFalse("Major list is empty", majors.isEmpty());

        // Add more assertions to verify the correctness of the loaded majors
        for (Major major : majors) {
            assertNotNull("Major ID is null", major.getName());
            assertNotNull("Major required courses list is null", major.getCourses());
            // Add more assertions as needed
        }
    }
}

