package degreeswork;

public class DegreeWorksTester {

    public static void main(String[] args) {
        // Initialize UserList and DegreeWorks instances for testing
        DegreeWorks degreeWorks = new DegreeWorks();
        degreeWorks.printUserList();

        // Test cases for signup method
        boolean signupTest1 = degreeWorks.signup("newUser1", "pass123", "John", "Doe");
        boolean signupTest2 = degreeWorks.signup("newUser2", "pass456", "Jane", "Smith");


        System.out.println("Signup Test 1 (expected true): " + signupTest1);
        System.out.println("Signup Test 2 (expected true): " + signupTest2);

        //login to database User
        boolean signupTest3 = degreeWorks.login("dspears", "iluvdogs2004");
        System.out.println("Database Login Test 1 (expected true): " + signupTest3);

        //login to database User
        boolean signupTest4 = degreeWorks.login("dfrancis", "31459");
        System.out.println("Database Login Test 2 (expected true): " + signupTest4);

        // Test cases for login method
        boolean loginTest1 = degreeWorks.login("newUser1", "pass123");
        boolean loginTest2 = degreeWorks.login("nonExistentUser", "pass789");

        System.out.println("Login Test 1 (expected true): " + loginTest1);
        System.out.println("Login Test 2 (expected false, no such user): " + loginTest2);

        // Test cases for getUser method
        String getUserTest1 = degreeWorks.getUser("newUser1");
        String getUserTest2 = degreeWorks.getUser("newUser2");
        //String getUserTest3 = degreeWorks.getUser("nonExistentUser");

        System.out.println("Get User Test 1 (expected details of newUser1): " + getUserTest1);
        System.out.println("Get User Test 2 (expected details of newUser2): " + getUserTest2);
        //System.out.println("Get User Test 3 (expected null or 'User not found'): " + getUserTest3);
//TODO add advisor, add advisee, test advisor login, get all
    }
}

