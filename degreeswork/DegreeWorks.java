package degreeswork;

import java.util.ArrayList;

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
       if(this.mUser==null)
        return false;
       else
        return true;
    }
    
    public boolean signup(String username, String password, String firstname, String lastname) {
        mUserList.addUsers(username, password, firstname, lastname);
        return true;
    }

    public String getUser(String username) {
        if(mUserList.searchUser(username))
            return mUserList.getUser(username).toString();
        else
            return null;
    }

    public void printUserList() {
        //create for loop here to print all user.getEmail() in the array list. 
        ArrayList<User> arr=mUserList.getUsers();
        for (User user : arr) {
            System.out.println(user.getEmail());
        }

    }
}
