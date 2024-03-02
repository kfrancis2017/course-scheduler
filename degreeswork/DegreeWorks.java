package degreeswork;

public class DegreeWorks {

    private User mUser;
    private UserList mUserList;

    public DegreeWorks(UserList users) {
        mUserList = users;

    }

    public DegreeWorks() {
        mUserList = new UserList();
        DataLoader loader = new DataLoader();
        mUserList = loader.getAllStudents();
    }

    public boolean login(String username, String password) {
       this.mUser = mUserList.login(username, password);
       return true;
    }
    
    public boolean signup(String username, String password, String firstname, String lastname) {
        mUserList.addUsers(username, password, firstname, lastname);
        return true;
    }

    public String getUser(String username) {
        return mUserList.getUser(username).toString();
    }
}
