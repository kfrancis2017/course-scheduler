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

    public boolean addUser(User user) {
        if (!searchUser(user.getUsername()))
            return users.add(user);
        return false;
    }
    
    public void addUsers(ArrayList<User> users) {
        for (User user : users) {
            addUser(user);
        }
    }

    public void addUser(String username, String password, String firstname, String lastname) {
        addUser(new User(username, password, firstname, lastname));
    }

    public boolean searchUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public User getUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        return students;
    }

    public ArrayList<Advisor> getAdvisors() {
        ArrayList<Advisor> advisors = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Advisor) {
                advisors.add((Advisor) user);
            }
        }
        return advisors;
    }

    public ArrayList<Admin> getAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Admin) {
                admins.add((Admin) user);
            }
        }
        return admins;
    }

    public User login(String username, String password) {
        if (searchUser(username)){
            if (getUser(username).checkPassword(password)){
                return getUser(username);
            }
        }
        return null;
    }

    public void modifyUser(User user, User newUser) {
        int index = users.indexOf(user);
        if (index != -1) {
            users.set(index, newUser);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (User user : this.getUsers()) {
            result.append(user.getFirstName()).append("\t");
            result.append(user.getLastName()).append("\n");
        }
        return result.toString();
    }

}

