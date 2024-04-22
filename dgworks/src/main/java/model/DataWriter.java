package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter {

    // ... (existing code)

    /**
     * Calls the following methods to save all types of users
     */
    public static void SaveAllUsers() {
        saveStudents();
        saveAdvisors();
    }
    
    /**
     * Uses singleton to write student JSON file
     */
    private static void saveStudents() {
        DegreeWorks dg = DegreeWorks.getInstance();
        ArrayList<Student> students = dg.getStudents();
        JSONArray jsonStudents = new JSONArray();

        for (Student student : students) {
            jsonStudents.add(getStudentJSON(student));
        }

        writeJSONToFile("json/student.json", jsonStudents);
    }

    /**
     * Uses singleton to write advisor JSON file
     */
    private static void saveAdvisors() {
        DegreeWorks dg = DegreeWorks.getInstance();       
        ArrayList<Advisor> advisors = dg.getAdvisors();
        JSONArray jsonAdvisors = new JSONArray();

        for (Advisor advisor : advisors) {
            jsonAdvisors.add(getAdvisorJSON(advisor));
        }

        writeJSONToFile("json/advisor.json", jsonAdvisors);
    }

    private static void writeJSONToFile(String filename, JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(filename)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put("userID", student.getUserID().toString());
        studentDetails.put("username", student.getUsername());
        studentDetails.put("password", student.getPassword());
        studentDetails.put("email", student.getEmail());
        studentDetails.put("firstName", student.getFirstName());
        studentDetails.put("lastName", student.getLastName());

        // Convert List of current courses to JSON Array
        JSONArray currentCoursesArray = new JSONArray();
        currentCoursesArray.addAll(student.getCurrentCourses());
        studentDetails.put("currentCourses", currentCoursesArray);

        // Convert List of session notes to JSON Array
        JSONArray sessionNotesArray = new JSONArray();
        sessionNotesArray.addAll(student.getAdvisingNotes());
        studentDetails.put("sessionNotes", sessionNotesArray);

        studentDetails.put("major", student.getMajor().getName()); // Assuming 'Major' has a 'getName()' method
        studentDetails.put("currentSemester", student.getCurrentSemester());
        studentDetails.put("program", student.getProgram());
        studentDetails.put("currentAdvisor", student.getAdvisor().toString());

        JSONArray finishedCoursesArray = new JSONArray();
        finishedCoursesArray.addAll(student.getFinishedCourses());
        studentDetails.put("finishedCourses", finishedCoursesArray);

        return studentDetails;
    }

    private static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject advisorDetails = new JSONObject();
        advisorDetails.put("userID", advisor.getUserID().toString());
        advisorDetails.put("username", advisor.getUsername());
        advisorDetails.put("password", advisor.getPassword());
        advisorDetails.put("email", advisor.getEmail());
        advisorDetails.put("firstName", advisor.getFirstName());
        advisorDetails.put("lastName", advisor.getLastName());
        advisorDetails.put("accountStatus", advisor.getAccountStatus());

        // Convert List of advisee IDs to JSON Array
        JSONArray adviseeIDs = new JSONArray();
        adviseeIDs.addAll(advisor.getAdviseeList());
        advisorDetails.put("adviseeList", adviseeIDs);

        advisorDetails.put("advisorSpecialization", advisor.getAdvisorSpecialization());

        return advisorDetails;
    }
}