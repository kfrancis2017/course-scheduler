package degreeswork;

import java.util.ArrayList;

public class DegreeWorks {

    private User mUser;
    private UserList allUsers;
    private CourseList allCourses;

    public DegreeWorks(UserList users, CourseList courses) {
        this.allUsers = users;
        this.allCourses = courses;
    }

    public DegreeWorks() {
        this.allUsers = UserList.getInstance();
        this.allCourses = CourseList.getInstance();

        DataLoader.getAllStudents();
        DataLoader.getAllAdvisors();
        DataLoader.getAllAdmins();
        DataLoader.getAllCourses();
    }

    public boolean login(String username, String password) {
        this.mUser = allUsers.login(username, password);
        return this.mUser != null;
    }

    public boolean signup(String username, String password, String firstname, String lastname) {
        allUsers.addUser(username, password, firstname, lastname);
        return true;
    }

    public String getUser(String username) {
        if (allUsers.searchUser(username))
            return allUsers.getUser(username).toString();
        else
            return null;
    }

    public ArrayList<Student> getStudents() {
        return allUsers.getStudents();
    }

    public ArrayList<Advisor> getAdvisors() {
        return allUsers.getAdvisors();
    }

    public ArrayList<Admin> getAdmins() {
        return allUsers.getAdmins();
    }

    public ArrayList<Course> getCourses() {
        return allCourses.getCourses();
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
}
