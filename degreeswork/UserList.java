package degreeswork;

import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<User>();
    }

    public static UserList getInstance() {
        if (userList == null)
            userList = new UserList();
        return userList;
    }

    public void addUsers(String username, String password, String firstname, String lastname) {
        if (!searchUser(username))
            users.add(new User(username, password, firstname, lastname));
    }

    public void addStudent(Student student) {
        if (!searchUser(student.getUsername()))
            users.add(student);
        //TODO add error message in UI if user exists
    }

    public void addAdvisor(Advisor advisor) {
        if (!searchUser(advisor.getUsername())){
            users.add(advisor);
        }
        //TODO add error message in UI if user exists
    }
    
    public boolean searchUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }

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

    public ArrayList<User> getUsers() {
        return users;
    }

    public User login(String username, String password) {
        if (searchUser(username)){
            System.out.println("User exists");
            if (getUser(username).checkPassword(password)){
                System.out.println("Password matches");
                return getUser(username);
            }
        }
        return null;
    }

    public void modifyUser(User user) {
        
    }

}

