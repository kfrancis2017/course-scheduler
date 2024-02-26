package degreeswork;

import java.util.ArrayList;

public class UserList {
    private static ArrayList<User> users;

    /**
     * Initializes a static UserList
     */
    public UserList() {
        users = new ArrayList<User>();
    }

    /**
     * Adds User to the list
     * @param user User to be added
     */
    public void addUsers(String username, String password, String firstname, String lastname) {
        if (!searchUser(username))
            users.add(new User(username, password, firstname, lastname));
    }

    /**
     * Searches for a User in the list
     * @param username The User's username
     * @return A boolean value depending on the success of the search
     */
    public boolean searchUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }

    /**
     * Returns a User from the list
     * @param username The User's username
     * @return A User representing the specified User
     */
    public User getUser(String username) {
        if (searchUser(username)) {
            for (User user : users) {
                if (user.getUsername().equals(username))
                    return user;
            }
        }
        return null;
    }

    public User getUser(String username, String password) {
        return null;
    }

    /**
     * Uses username and password to login (return) a User
     * @param username The User's username
     * @param password The User's password
     * @return A User if a one exists with specified username and password
     */
    public User login(String username, String password) {
        if (searchUser(username) && getUser(username).checkPassword(password))
            return getUser(username);
        System.out.println("Username or password incorrect");
        return null;
    }

    /**
     * Accesses and modifies a User in the list
     * @param user The specified User
     */
    public void modifyUser(User user) {
        
    }

}

