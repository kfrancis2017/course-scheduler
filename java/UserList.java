package java;
import java.util.ArrayList;

public class UserList {
    private static ArrayList<User> users;

    /**
     * Initializes a static UserList
     */
    public UserList() {
        users = new ArrayList<>();
    }

    /**
     * Adds User to the list
     * @param user User to be added
     */
    public void addUsers(User user) {
        
    }

    /**
     * 
     * @param userDB
     */
    public void updateUserList(String userDB) {
        
    }

    public boolean updateDB() {
        return false;
    }

    /**
     * Searches for a User in the list
     * @param username The User's username
     * @return A boolean value depending on the success of the search
     */
    public boolean searchUser(String username) {
        return false;
    }

    /**
     * Returns a User from the list
     * @param username The User's username
     * @return A User representing the specified User
     */
    public User getUser(String username) {
        return null;
    }

    /**
     * Accesses and modifies a User in the list
     * @param user The specified User
     */
    public void modifyUser(User user) {
        
    }

}

