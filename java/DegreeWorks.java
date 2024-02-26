package java;

public class DegreeWorks {
    
    private User user;
    private CourseList mCourseList;
    private MajorList mProgramList;
    private UserList mUserList;

    public DegreeWorks(UserList users) {
        mUserList = users;
    }

    public boolean login(String username, String password) {
        if (mUserList.searchUser(username)) {
            if (mUserList.getUser(username).checkPassword(password))
                return true;
            System.out.println("Incorrect password");
        }
        System.out.println("Incorrect username");
        return false;
    }

    public boolean signup(String username, String password, String firstname, String lastname) {
        mUserList.addUsers(username, password, firstname, lastname);
        return true;
    }
}
