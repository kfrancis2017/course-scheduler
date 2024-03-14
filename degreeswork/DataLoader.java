package degreeswork;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataLoader {
    public DataLoader() {

    }

    public static ArrayList<User> getAllStudents() {
        ArrayList<User> students = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray studentData = (JSONArray) parser.parse(new FileReader("json/student.json"));
            for (Object obj : studentData) {
                JSONObject studentJson = (JSONObject) obj;
                Student student = parseStudent(studentJson);
                students.add(student);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return students;
    }

    //Why is parseStudent the only one separate from getAllStudents?
    private static Student parseStudent(JSONObject studentJson) {
        Student student = new Student();

        student.setUserID(UUID.fromString((String) studentJson.get("userID")));
        student.setUsername((String) studentJson.get("username"));
        student.setPassword((String) studentJson.get("password"));
        student.setEmail((String) studentJson.get("email"));
        student.setFirstName((String) studentJson.get("firstName"));
        student.setLastName((String) studentJson.get("lastName"));

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

        student.setMajor(new Major((String) studentJson.get("major")));
        student.setProgram((String) studentJson.get("program"));
        student.setCurrentAdvisor(UUID.fromString((String) studentJson.get("currentAdvisor")));
        return student;
    }

    public static void getAllAdvisors() {
        UserList users = UserList.getInstance();


        JSONParser parser = new JSONParser();
        try {
            JSONArray advisorData = (JSONArray) parser.parse(new FileReader("json/advisor.json"));
            for (Object obj : advisorData) {
                JSONObject advisorJSON = (JSONObject) obj;
                Advisor advisor = new Advisor();

                advisor.setUserID(UUID.fromString((String) advisorJSON.get("userID")));
                advisor.setUsername((String) advisorJSON.get("username"));
                advisor.setPassword((String) advisorJSON.get("password"));
                advisor.setEmail((String) advisorJSON.get("email"));
                advisor.setFirstName((String) advisorJSON.get("firstName"));
                advisor.setLastName((String) advisorJSON.get("lastName"));
                advisor.setAccountStatus((String) advisorJSON.get("accountStatus"));

                JSONArray adviseeIDs = (JSONArray) advisorJSON.get("adviseeList");
                ArrayList<String> advisees = new ArrayList<>();
                for (Object id : adviseeIDs) {
                    advisees.add((String) id);
                }
                advisor.setAdviseeList(advisees);

                advisor.setAdvisorSpecialization((String) advisorJSON.get("advisorSpecialization"));

                users.addUser(advisor);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<User> getAllAdmins() {
        ArrayList<User> admins = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try {
            JSONArray adminData = (JSONArray) parser.parse(new FileReader("json/admin.json"));
            for (Object obj : adminData) {
                JSONObject adminJSON = (JSONObject) obj;
                Admin admin = new Admin();

                admin.setUserID(UUID.fromString((String) adminJSON.get("userID")));
                admin.setUsername((String) adminJSON.get("username"));
                admin.setPassword((String) adminJSON.get("password"));
                admin.setEmail((String) adminJSON.get("email"));
                admin.setFirstName((String) adminJSON.get("firstName"));
                admin.setLastName((String) adminJSON.get("lastName"));
                admin.setAccountStatus((String) adminJSON.get("accountStatus"));

                admins.add(admin);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return admins;
    }

}