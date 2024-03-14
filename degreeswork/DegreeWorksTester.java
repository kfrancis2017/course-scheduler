package degreeswork;
import java.util.ArrayList;

public class DegreeWorksTester {

    public static void main(String[] args) {
        // Initialize UserList and DegreeWorks instances for testing
        DegreeWorks degreeWorks = new DegreeWorks();
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
        System.out.println("Printing User List");

        degreeWorks.printUserList();
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
        // Running test cases
        testSignup(degreeWorks);
        testDatabaseLogin(degreeWorks);
        testLogin(degreeWorks);
        testGetUser(degreeWorks);
        testGetStudents(degreeWorks);
        testGetAdvisors(degreeWorks);
        testGetAdmins(degreeWorks);
        testGetCourses(degreeWorks);
        testAddCourse(degreeWorks);
        testRemoveCourse(degreeWorks);
        testUpdateCourse(degreeWorks);
    }

    private static void testSignup(DegreeWorks degreeWorks) {
        System.out.println("Testing Signup Functionality\n");

        boolean signupTest1 = degreeWorks.signup("newUser1", "pass123", "John", "Doe");
        boolean signupTest2 = degreeWorks.signup("newUser2", "pass456", "Jane", "Smith");
        System.out.println("Signup Test 1 (expected true): " + signupTest1);
        System.out.println("Signup Test 2 (expected true): " + signupTest2);
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
    }

    private static void testDatabaseLogin(DegreeWorks degreeWorks) {
        System.out.println("Testing Database Login Functionality\n");
        boolean databaseLoginTest1 = degreeWorks.login("dspears", "iluvdogs2004");
        boolean databaseLoginTest2 = degreeWorks.login("dfrancis", "31459");
        System.out.println("Database Login Test 1 (expected true): " + databaseLoginTest1);
        System.out.println("Database Login Test 2 (expected true): " + databaseLoginTest2);
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
    }

    private static void testLogin(DegreeWorks degreeWorks) {
        System.out.println("Testing NewUser Login Functionality\n");
        boolean loginTest1 = degreeWorks.login("newUser1", "pass123");
        boolean loginTest2 = degreeWorks.login("nonExistentUser", "pass789");
        System.out.println("Login Test 1 (expected true): " + loginTest1);
        System.out.println("Login Test 2 (expected false, no such user): " + loginTest2);
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
    }

    private static void testGetUser(DegreeWorks degreeWorks) {
        System.out.println("Testing GetUser Functionality\n");
        String getUserTest1 = degreeWorks.getUser("newUser1");
        String getUserTest2 = degreeWorks.getUser("newUser2");
        String getUserTest3 = degreeWorks.getUser("nonExistentUser");
        System.out.println("Get User Test 1 (expected details of newUser1): " + getUserTest1);
        System.out.println("Get User Test 2 (expected details of newUser2): " + getUserTest2);
        System.out.println("Get User Test 3 (expected null or 'User not found'): " + getUserTest3);
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
    }

    private static void testGetStudents(DegreeWorks degreeWorks) {
        System.out.println("Testing getStudents Functionality\n");
        ArrayList<Student> students = degreeWorks.getStudents();
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getUsername() + ": " + student.getFirstName() + " " + student.getLastName());
        }
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
    }

    private static void testGetAdvisors(DegreeWorks degreeWorks) {
        System.out.println("Testing getAdvisors Functionality\n");
        ArrayList<Advisor> advisors = degreeWorks.getAdvisors();
        System.out.println("Advisors:");
        for (Advisor advisor : advisors) {
            System.out.println(advisor.getUsername() + ": " + advisor.getFirstName() + " " + advisor.getLastName());
        }
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
    }

    private static void testGetAdmins(DegreeWorks degreeWorks) {
        System.out.println("Testing getAdmins Functionality\n");
        ArrayList<Admin> admins = degreeWorks.getAdmins();
        System.out.println("Admins:");
        for (Admin admin : admins) {
            System.out.println(admin.getUsername() + ": " + admin.getFirstName() + " " + admin.getLastName());
        }
        System.out.println("*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*+*\n");
    }
}
