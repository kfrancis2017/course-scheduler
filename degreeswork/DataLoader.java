package degreeswork;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataLoader {

    public UserList getAllStudents() {
        // Initialize a new UserList to hold Student objects
        UserList students = new UserList();
    
        // Create a JSON parser for reading the student data
        JSONParser parser = new JSONParser();

        try {
            // Parse the JSON file containing student data into a JSONArray
            JSONArray studentData = (JSONArray) parser.parse(new FileReader("json/student.json"));
    
            // Iterate through each object in the student data array
            for (Object obj : studentData) {
                JSONObject studentJson = (JSONObject) obj;
    
                // Parse individual student JSON object into a Student object
                Student student = parseStudent(studentJson);
    
                // Add the parsed Student object to the UserList
                students.addStudent(student);
            }
        } catch (IOException | ParseException e) {
            // Print the stack trace for debugging if an exception occurs
            e.printStackTrace();
        }
    
        // Return the list of parsed Student objects
        return students;
    }
    
    private Student parseStudent(JSONObject studentJson) {
        // Create a new Student instance
        Student student = new Student();
    
        // Set "User" properties from the JSON object
        student.setUserID(UUID.fromString((String) studentJson.get("userID")));
        student.setUsername((String) studentJson.get("username"));
        student.setPassword((String) studentJson.get("password"));
        student.setEmail((String) studentJson.get("email"));
        student.setFirstName((String) studentJson.get("firstName"));
        student.setLastName((String) studentJson.get("lastName"));
    
        // Convert JSON array of current courses into a List<String>
        JSONArray currentCoursesArray = (JSONArray) studentJson.get("currentCourses");
        ArrayList<String> currentCoursesList = new ArrayList<>();
        for (Object courseObj : currentCoursesArray) {
            currentCoursesList.add((String) courseObj);
        }
        student.setCurrentCourses(currentCoursesList);
    
        // Convert JSON array of session notes into a List<String>
        JSONArray sessionNotesArray = (JSONArray) studentJson.get("sessionNotes");
        ArrayList<String> sessionNotesList = new ArrayList<>();
        for (Object noteObj : sessionNotesArray) {
            sessionNotesList.add((String) noteObj);
        }
        student.setAdvisingNotes(sessionNotesList);
    
        // Set additional student properties from the JSON object
        student.setMajor(new Major((String) studentJson.get("major")));
        student.setProgram((String) studentJson.get("program"));
        student.setCurrentAdvisor(UUID.fromString((String) studentJson.get("currentAdvisor")));
        student.setMajorGPA((Double) studentJson.get("major_GPA"));
        student.setOverallGPA((Double) studentJson.get("overall_GPA"));
        student.setMajorCompletionPercentage((Double) studentJson.get("majorCompletionPercentage"));
        student.setCoreCompletionPercentage((Double) studentJson.get("coreCompletionPercentage"));
        student.setDegreeCompletionPercentage((Double) studentJson.get("degreeCompletionPercentage"));
    
        // Return the fully populated Student object
        return student;
    }
    


    public UserList getAllAdvisors() {
        UserList advisors = new UserList();

        JSONParser parser = new JSONParser();
        try {
            JSONArray advisorData = (JSONArray) parser.parse(new FileReader("json/advisor.json"));
            for (Object obj : advisorData) {
                JSONObject advisor = (JSONObject) obj;
                // Parse advisor data and add to advisors list
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return advisors;
    }

    public UserList getAllAdmins() {
        UserList admins = new UserList();

        JSONParser parser = new JSONParser();
        try {
            JSONArray adminData = (JSONArray) parser.parse(new FileReader("json/admins.json"));
            for (Object obj : adminData) {
                JSONObject admin = (JSONObject) obj;
                // Parse admin data and add to admins list
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return admins;
    }
    

    public void testFunctions() {
        // Test retrieving all students
        UserList allStudents = getAllStudents();
        System.out.println("All Students:");
        for (User student : allStudents.getUsers()) {
            System.out.println(student);
        }

        // Test retrieving all advisors
        UserList allAdvisors = getAllAdvisors();
        System.out.println("\nAll Advisors:");
        for (User advisor : allAdvisors.getUsers()) {
            System.out.println(advisor);
        }
    }

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();

        // Testing functionality to retrieve all students
        System.out.println("Testing getAllStudents:");
        UserList students = dataLoader.getAllStudents();
        for (User student : students.getUsers()) {
            System.out.println(student);
            System.out.println("\n");
        }

        // Optionally, you can test other functionalities
        // For example, testing getAllAdvisors:
        System.out.println("\nTesting getAllAdvisors:");
        UserList advisors = dataLoader.getAllAdvisors();
        for (User advisor : advisors.getUsers()) {
            System.out.println(advisor);
        }
    }
}