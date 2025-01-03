package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import javafx.scene.chart.PieChart.Data;

public class DegreeWorks {

    private User mUser;
    public Student mStudent;
    public Advisor mAdvisor;
    //TODO
    private UserList allUsers;
    private CourseList allCourses;
    private MajorList allMajors;
    private static DegreeWorks degreeWorks;


    public DegreeWorks() {
        DataLoader.getAllCourses();
        DataLoader.getAllMajors();
        DataLoader.getAllStudents();
        DataLoader.getAllAdvisors();
        
        

        this.allUsers = UserList.getInstance();
        this.allCourses = CourseList.getInstance();
        this.allMajors = MajorList.getInstance();
    }

    public static DegreeWorks getInstance() {
        if (degreeWorks == null) {
            degreeWorks = new DegreeWorks();
        }
        return degreeWorks;
    }

    public void logout() {
        this.mUser = null;
        this.mAdvisor = null;
        this.mStudent = null;
    }

    public boolean studentLogin(String username, String password) {
        this.mUser = allUsers.login(username, password);
        if (this.mUser != null && this.mUser instanceof Student) {
            this.mStudent = (Student) this.mUser; // Set mStudent if the logged-in user is a student
        }
        return this.mUser != null;
    }

    public boolean advisorLogin(String username, String password) {
        this.mUser = allUsers.login(username, password);
        if (this.mUser != null && this.mUser instanceof Advisor) {
            this.mAdvisor = (Advisor) this.mUser; // Set mAdvisor if the logged-in user is a student
        }
        return this.mUser != null;
    }

    public boolean signup(String username, String password, String firstname, String lastname, boolean isAdvisor) {
        allUsers.addUser(username, password, firstname, lastname, isAdvisor);
        return true;
    }

    public boolean advisorSignup(String username, String password, String firstname, String lastname) {
        Advisor advisor = new Advisor(username, password, firstname, lastname);
        allUsers.addUser(advisor);
        return true;
    }

    public String getUser(String username) {
        if (allUsers.searchUser(username))
            return allUsers.getUser(username).toString();
        else
            return null;
    }

    public UserList getAllUsers() {
        return this.allUsers;
    }

    public ArrayList<Student> getStudents() {
        return allUsers.getStudents();
    }

    public ArrayList<Advisor> getAdvisors() {
        return allUsers.getAdvisors();
    }

    public ArrayList<Course> getCourses() {
        return allCourses.getCourses();
    }

    public CourseList getAllCourses() {
        return allCourses;
    }

    public Student getStudent(String username) {
        mStudent = allUsers.searchStudent(username);
        return mStudent;
    }

    public Advisor getAdvisor(String username) {
        mAdvisor = allUsers.searchAdvisor(username);
        return mAdvisor;
    }

    public String courseToString() {
        StringBuffer sb = new StringBuffer();
        for (Course course : allCourses.getCourses()) {
            sb.append(course.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printUserList() {
        System.out.println(allUsers.toString());
    }

    public boolean addCourse(Course course) {
        return allCourses.addCourse(course);
    }

    public boolean modifyCourse(Course newCourse, Course oldCourse) {
        return allCourses.modifyCourse(newCourse, oldCourse);
    }

    public boolean deleteCourse(Course course) {
        return allCourses.deleteCourse(course);
    }

    public Course findCourse(String courseID) {
        return allCourses.findCourseByCode(courseID);
    }

    public void printSchedule(String username) {
    }
    
    public void viewRecord() {
        mStudent.viewRecord();
    }

    public String getMajorName() {
        return mStudent.getMajor().getName();
    }

    public void getRequirements(String majorName) {
        System.out.println(allMajors.listCoursesForMajor(majorName, mStudent));
    }

    public void addStudentCourse(String courseID) {
        mStudent.updateStudentTranscript(courseID, null);
    }
    public void allToString() {
        System.out.println(allMajors.allToString());
    }

    public String getStudentName() {
        return mStudent.getFirstName() + " " + mStudent.getLastName();
    }

    public String getAdvisorName() {
        return mAdvisor.getFirstName() + " " + mAdvisor.getLastName();
    }

    public ArrayList<String> getNotes() {
        return mStudent.getAdvisingNotes();
    }

    public ArrayList<String> getAdvisees() {
        return mAdvisor.getAdviseeList();
    }

    public ArrayList<String> getStudentInfo() {
        return mStudent.getStudentInfo();
    }

    public ArrayList<String> getCurrentCourses() {
        return mStudent.getCurrentCourses();
    }

    public ArrayList<String> getAdvisorInfo() {
        return mAdvisor.getInfo();
    }

    public ArrayList<String> getStudentTranscript() {
        return mStudent.getTranscript();
    }

    public void setAdvisor(Advisor advisor) {
        this.mAdvisor = advisor;
    }

    public void setStudent(Student student) {
        this.mStudent = student;
    }

    public void addAdvisingNote(Student student, String session) {
        mAdvisor.addAdvisingSession(student, session);
    }

    public long getMajorHours() {
        return mStudent.getMajor().getHours();
    }

    public int getStudentHours() {
        return mStudent.getHours();
    }
   
    public boolean searchCourse(String id) {
        return !allCourses.findCourseByCode(id).equals(null);
    }

    public void addFinishedCourse(String courseID, String grade, String sem) {
        mStudent.addFinishedCourse(courseID, grade, sem);
    }
    

}
