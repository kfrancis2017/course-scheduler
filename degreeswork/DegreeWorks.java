package degreeswork;

public class DegreeWorks {
    
    // private User user;
    // private CourseList mCourseList;
    // private MajorList mProgramList;
    private UserList mUserList;

    public DegreeWorks(UserList users) {
        mUserList = users;
    }

    public DegreeWorks() {
        mUserList = new UserList();
        mUserList.addUsers("admin", "admin", "admin", "admin");
        mUserList.addUsers("student", "student", "student", "student");
        mUserList.addUsers("jvaught", "DoremInc1.", "Jacob", "Vaught");
    }

    /**
     * Uses UserList's login method
     * @param username The User's username
     * @param password The User's password
     */
    public void login(String username, String password) {
        mUserList.login(username, password);


        // if (mUserList.searchUser(username)) {
        //     User user = mUserList.getUser(username); // Get the user object
        //     if (user.checkPassword(password)) {
        //         System.out.println("Login successful for username: " + username);
        //         return true;
        //     } else {
        //         System.out.println("Login attempt for username: " + username + " - Incorrect password.");
        //         System.out.println(password + " - Incorrect password. Expected: "+user.password);
        //     }
        // } else {
        //     System.out.println("Login attempt with non-existing username: " + username);
        // }
        // return false;
    }
    

    public boolean signup(String username, String password, String firstname, String lastname) {
        mUserList.addUsers(username, password, firstname, lastname);
        System.out.println("Sign up successful for username: " + username);
        if(mUserList.searchUser(username)) {
            System.out.println(mUserList.getUser(username).viewProfile());
        }
        return true;
    }
    public String getUser(String username) {
        return mUserList.getUser(username).viewProfile();
    }
}
