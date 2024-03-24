//Run this carefully. It will overwrite the json files with the current data in the Lists.


package test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;
import degreeswork.*;

public class testDataWriter {
/* 
    @Before
    public void setUp() {
        // Add any necessary setup here
    }

    @Test
    public void testSaveAdvisors() {
        // Invoke the method to save advisors
        DataWriter.SaveAllUsers();

        // Verify that the advisor JSON file is created
        File advisorFile = new File("json/advisor.json");
        assertTrue("Advisor JSON file does not exist", advisorFile.exists());

        // Read the contents of the JSON file and verify its structure
        try (FileReader reader = new FileReader(advisorFile)) {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(reader);
            assertFalse("Advisor list is empty", jsonArray.isEmpty());

            // Assert the correctness of each advisor JSON object
            for (Object obj : jsonArray) {
                JSONObject advisorJson = (JSONObject) obj;
                assertNotNull("Advisor userID is null", advisorJson.get("userID"));
                assertNotNull("Advisor username is null", advisorJson.get("username"));
                assertNotNull("Advisor password is null", advisorJson.get("password"));
                assertNotNull("Advisor email is null", advisorJson.get("email"));
                assertNotNull("Advisor firstName is null", advisorJson.get("firstName"));
                assertNotNull("Advisor lastName is null", advisorJson.get("lastName"));
                assertNotNull("Advisor accountStatus is null", advisorJson.get("accountStatus"));
                assertNotNull("Advisor adviseeList is null", advisorJson.get("adviseeList"));
                assertNotNull("Advisor advisorSpecialization is null", advisorJson.get("advisorSpecialization"));
            }
        } catch (IOException | ParseException e) {
            fail("Exception occurred while reading advisor JSON file: " + e.getMessage());
        }
    }

    @Test
    public void testSaveStudents() {
        // Invoke the method to save students
        DataWriter.SaveAllUsers();

        // Verify that the student JSON file is created
        File studentFile = new File("json/student.json");
        assertTrue("Student JSON file does not exist", studentFile.exists());

        // Read the contents of the JSON file and verify its structure
        try (FileReader reader = new FileReader(studentFile)) {
            JSONArray jsonArray = (JSONArray) new JSONParser().parse(reader);
            assertFalse("Student list is empty", jsonArray.isEmpty());

            // Assert the correctness of each student JSON object
            for (Object obj : jsonArray) {
                JSONObject studentJson = (JSONObject) obj;
                assertNotNull("Student userID is null", studentJson.get("userID"));
                assertNotNull("Student username is null", studentJson.get("username"));
                assertNotNull("Student password is null", studentJson.get("password"));
                assertNotNull("Student email is null", studentJson.get("email"));
                assertNotNull("Student firstName is null", studentJson.get("firstName"));
                assertNotNull("Student lastName is null", studentJson.get("lastName"));
                assertNotNull("Student currentCourses is null", studentJson.get("currentCourses"));
                assertNotNull("Student sessionNotes is null", studentJson.get("sessionNotes"));
                assertNotNull("Student major is null", studentJson.get("major"));
                assertNotNull("Student currentSemester is null", studentJson.get("currentSemester"));
                assertNotNull("Student program is null", studentJson.get("program"));
                assertNotNull("Student currentAdvisor is null", studentJson.get("currentAdvisor"));
            }
        } catch (IOException | ParseException e) {
            fail("Exception occurred while reading student JSON file: " + e.getMessage());
        }
    }
*/
}

