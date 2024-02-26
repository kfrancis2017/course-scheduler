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
        UserList students = new UserList(); // Assuming UserList can store Student objects
        
        JSONParser parser = new JSONParser();
        try {
            JSONArray studentData = (JSONArray) parser.parse(new FileReader("student.json"));
            for (Object obj : studentData) {
                JSONObject studentJson = (JSONObject) obj;
                // Parse student data here and create a Student object
                Student student = parseStudent(studentJson);
                students.add(student); // Assuming UserList has an add method similar to List
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
        return students;
    }

    private Student parseStudent(JSONObject studentJson) {
        // Assuming Student has a constructor that matches this structure or set methods for each field
        Student student = new Student();
        student.setUserID(UUID.fromString((String) studentJson.get("userID")));
        student.setUsername((String) studentJson.get("username"));
        student.setPassword((String) studentJson.get("password"));
        student.setEmail((String) studentJson.get("email"));
        student.setFirstName((String) studentJson.get("firstName"));
        student.setLastName((String) studentJson.get("lastName"));
        student.setAccountStatus((String) studentJson.get("accountStatus"));

        // Convert JSON array to List or appropriate data structure for courses
        JSONArray currentCoursesArray = (JSONArray) studentJson.get("currentCourses");
        List<Course> currentCoursesList = new ArrayList<>();
        for (Object courseObj : currentCoursesArray) {
            Course course = new Course();
            currentCoursesList.add(courseList.findCourse((String) courseObj));//<-- need to define courseList
        }
        student.setCurrentCourses(currentCoursesList); // Make sure to convert JSONArray to the correct type
        student.setMajor(new Major((String) studentJson.get("major")));
        student.addSessionNote(new ArrayList<String>(studentJson.get("sessionNotes")));
        student.setProgram((String) studentJson.get("program"));
        student.setCurrentAdvisor(UUID.fromString((String) studentJson.get("currentAdvisor")));
        student.setMajorGPA((Double) studentJson.get("major_GPA"));
        student.setOverallGPA((Double) studentJson.get("overall_GPA"));
        student.setMajorCompletionPercentage((Double) studentJson.get("majorCompletionPercentage"));
        student.setCoreCompletionPercentage((Double) studentJson.get("coreCompletionPercentage"));
        student.setDegreeCompletionPercentage((Double) studentJson.get("degreeCompletionPercentage"));
        // Handle null for finishedCourses if necessary
        // Handle additional fields as needed
        
        return student;
    }
    
    // Other methods ...
}

    
    public UserList getAllAdvisors() {
        UserList advisors = new UserList();
        
        JSONParser parser = new JSONParser();
        try {
            JSONArray advisorData = (JSONArray) parser.parse(new FileReader("advisor.json"));
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
            JSONArray adminData = (JSONArray) parser.parse(new FileReader("admins.json"));
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
    
}


