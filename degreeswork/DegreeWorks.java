package degreeswork;

import java.util.ArrayList;

public class DegreeWorks {

    private User mUser;
    private UserList allUsers;

    public DegreeWorks(UserList users) {
        this.allUsers = users;
    }

    public DegreeWorks() {
        DataLoader loader = new DataLoader();
        this.allUsers = new UserList();
        
        // Combine all users into one list
        this.allUsers.addUsers(loader.getAllStudents());
        this.allUsers.addUsers(loader.getAllAdvisors());
        this.allUsers.addUsers(loader.getAllAdmins());
    }

    public boolean login(String username, String password) {
       this.mUser = allUsers.login(username, password);
       if(this.mUser==null)
        return false;
       else
        return true;
    }
    
    public boolean signup(String username, String password, String firstname, String lastname) {
        allUsers.addUser(username, password, firstname, lastname);
        return true;
    }

    public String getUser(String username) {
        if(allUsers.searchUser(username))
            return allUsers.getUser(username).toString();
        else
            return null;
    }

    public void printUserList() {
        System.out.println(allUsers.toString());
    }
}
