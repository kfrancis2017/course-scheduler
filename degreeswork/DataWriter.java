package degreeswork;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;;

public class DataWriter {

    
    public void SaveAllStudents() {
        UserList students = UserList.getInstance();
        ArrayList<User> studentList = students.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < studentList.size(); i++) {
            jsonUsers.add(getStudentJSON(studentList.get(i)));
        }

        try (FileWriter file = new FileWriter("json/student.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getStudentJSON(User user) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put("userID", user.getUserID());
        studentDetails.put("username", user.getUsername());
        studentDetails.put("password", user.getPassword());
        studentDetails.put("email", user.getEmail());
        studentDetails.put("firstname", user.getFirstName());
        studentDetails.put("lastname", user.getLastName());

        return studentDetails;
    }

    public void SaveAllAdvisors() {
        
    }

    public void SaveAllAdmins() {

    }
}
