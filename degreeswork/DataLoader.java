package degreeswork;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataLoader {
    public DataLoader() {

    }
    public static void getAllCourses() {
        JSONParser parser = new JSONParser();
        CourseList courses = CourseList.getInstance();

        try {
            // Read the array of courses from the file
            JSONArray courseDataArray = (JSONArray) parser.parse(new FileReader("json/course.json"));
            for (Object courseObj : courseDataArray) {
                JSONObject courseData = (JSONObject) courseObj;
                Course course = new Course();
                course.setCourseID((String) courseData.get("courseID"));
                course.setTitle((String) courseData.get("title"));
                course.setDescription((String) courseData.get("description"));

                ArrayList<ArrayList<String>> prerequisites = new ArrayList<>();
                JSONArray prereqData = (JSONArray) courseData.get("prerequisites");
                for (Object obj : prereqData) {
                    ArrayList<String> prerequisiteList = new ArrayList<>();
                    JSONArray innerArray = (JSONArray) obj;
                    for (Object innerObj : innerArray) {
                        JSONObject prereqJSON = (JSONObject) innerObj;
                        String prerequisite = ((String) prereqJSON.get("precourseID")) + "\t" + (String) prereqJSON.get("grade");
                        prerequisiteList.add(prerequisite);
                    }
                    prerequisites.add(prerequisiteList);
                }
                course.setPrereq(prerequisites);

                ArrayList<ArrayList<String>> corequisites = new ArrayList<>();
                JSONArray coreqData = (JSONArray) courseData.get("corequisites");
                for (Object obj : coreqData) {
                    ArrayList<String> corequisiteList = new ArrayList<>();
                    JSONArray innerArray = (JSONArray) obj;
                    for (Object innerObj : innerArray) {
                        JSONObject coreqJSON = (JSONObject) innerObj;
                        String corequisite = ((String) coreqJSON.get("cocourseID")) + "\t" + (String) coreqJSON.get("grade");
                        corequisiteList.add(corequisite);
                    }
                    corequisites.add(corequisiteList);
                }
                course.setCoreq(corequisites);

                course.setAOS_Req((String) courseData.get("AOS_Req"));
                course.setCourseHolds((Boolean) courseData.get("courseHolds"));
                courses.addCourse(course);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    
      /**
     * Redone getAllStudents to be more in line with other "getAll" methods
     */
    public static void getAllStudents() {
        UserList users = UserList.getInstance();
        JSONParser parser = new JSONParser();
        try {
            JSONArray studentData = (JSONArray) parser.parse(new FileReader("json/student.json"));
            for (Object obj : studentData) {
                JSONObject studentJSON = (JSONObject) obj;
                Student student = new Student();

                student.setUserID(UUID.fromString((String) studentJSON.get("userID")));
                student.setUsername((String) studentJSON.get("username"));
                student.setPassword((String) studentJSON.get("password"));
                student.setEmail((String) studentJSON.get("email"));
                student.setFirstName((String) studentJSON.get("firstName"));
                student.setLastName((String) studentJSON.get("lastName"));

                JSONArray currentCoursesArray = (JSONArray) studentJSON.get("currentCourses");
                ArrayList<String> currentCoursesList = new ArrayList<>();
                for (Object courseObj : currentCoursesArray) {
                    currentCoursesList.add((String) courseObj);
                }
                student.setCurrentCourses(currentCoursesList);

                // Convert JSON array of session notes into a List<String>
                JSONArray sessionNotesArray = (JSONArray) studentJSON.get("sessionNotes");
                ArrayList<String> sessionNotesList = new ArrayList<>();
                for (Object noteObj : sessionNotesArray) {
                    sessionNotesList.add((String) noteObj);
                }
                student.setAdvisingNotes(sessionNotesList);

                student.setMajor(new Major((String) studentJSON.get("major")));
                student.setCurrentSemester((String) studentJSON.get("currentSemester"));
                student.setProgram((String) studentJSON.get("program"));
                student.setCurrentAdvisor(UUID.fromString((String) studentJSON.get("currentAdvisor")));

                JSONArray finCourses = (JSONArray) studentJSON.get("finishedCourses");
                ArrayList<ArrayList<String>> finishedCourses = new ArrayList<ArrayList<String>>();
                for (int i = 0; i < finCourses.size(); i++) {
                    ArrayList<String> course = new ArrayList<String>();
                    JSONArray finCourseEntry = (JSONArray) finCourses.get(i);
                }
                student.setAdviseeList(advisees);

                users.addUser(student);

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Doesn't return an ArrayList, instead populates the singleton, where you can use getAdvisors
     */
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

    /**
     * Populates singleton, same logic as above
     */
    public static void getAllAdmins() {
        UserList users = UserList.getInstance();

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

                users.addUser(admin);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

}