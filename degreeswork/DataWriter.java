package degreeswork;

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
    public void SaveAllUsers() {
        saveStudents();
        saveAdvisors();
        saveAdmins();
    }

    /**
     * Uses singleton to write student JSON file
     */
    private void saveStudents() {
        UserList users = UserList.getInstance();
        ArrayList<Student> students = users.getStudents();
        JSONArray jsonStudents = new JSONArray();

        for (Student student : students) {
            jsonStudents.add(getStudentJSON(student));
        }

        writeJSONToFile("json/students.json", jsonStudents);
    }

    /**
     * Uses singleton to write advisor JSON file
     */
    private void saveAdvisors() {
        UserList users = UserList.getInstance();
        ArrayList<Advisor> advisors = users.getAdvisors();
        JSONArray jsonAdvisors = new JSONArray();

        for (Advisor advisor : advisors) {
            jsonAdvisors.add(getAdvisorJSON(advisor));
        }

        writeJSONToFile("json/advisors.json", jsonAdvisors);
    }

    /**
     * Uses singleton to write admin JSON file
     */
    private void saveAdmins() {
        UserList users = UserList.getInstance();
        ArrayList<Admin> admins = users.getAdmins();

        JSONArray jsonAdmins = new JSONArray();

        for (Admin admin : admins) {
            jsonAdmins.add(getAdminJSON(admin));
        }

        writeJSONToFile("json/admins.json", jsonAdmins);
    }

    private void writeJSONToFile(String filename, JSONArray jsonArray) {
        try (FileWriter file = new FileWriter(filename)) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject getStudentJSON(Student student) {
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

        return studentDetails;
    }

    private JSONObject getAdvisorJSON(Advisor advisor) {
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

    private JSONObject getAdminJSON(Admin admin) {
        JSONObject adminDetails = new JSONObject();
        adminDetails.put("userID", admin.getUserID().toString());
        adminDetails.put("username", admin.getUsername());
        adminDetails.put("password", admin.getPassword());
        adminDetails.put("email", admin.getEmail());
        adminDetails.put("firstName", admin.getFirstName());
        adminDetails.put("lastName", admin.getLastName());
        adminDetails.put("accountStatus", admin.getAccountStatus());

        return adminDetails;
    }

    
}