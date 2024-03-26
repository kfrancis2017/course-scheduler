package test;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import degreeswork.Advisor;
import degreeswork.Student;
import degreeswork.User;
import degreeswork.UserList;

public class testUserList {
    
    private UserList userList;

    @Before
    public void setUp() {
        userList = UserList.getInstance();
    }

    @Test
    public void testAddUser() {
        User student = new Student("john123", "password", "John", "Doe");
        Assert.assertTrue(userList.addUser(student));
        Assert.assertTrue(userList.searchUser("john123"));
    }

    @Test
    public void testAddUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new Student("john123", "password", "John", "Doe"));
        users.add(new Advisor("jane456", "password", "Jane", "Smith"));
        userList.addUsers(users);
        Assert.assertTrue(userList.searchUser("john123"));
        Assert.assertTrue(userList.searchUser("jane456"));
    }

    @Test
    public void testSearchUser() {
        User student = new Student("john123", "password", "John", "Doe");
        userList.addUser(student);
        Assert.assertTrue(userList.searchUser("john123"));
        Assert.assertFalse(userList.searchUser("invalidUser"));
    }

    @Test
    public void testGetUser() {
        User student = new Student("john12", "password", "John", "Doe");
        userList.addUser(student);
        Assert.assertEquals(student, userList.getUser("john12"));
    }

    @Test
    public void testGetStudents() {
        userList.clear();
        userList.addUser("john123", "password", "John", "Doe", false);
        userList.addUser("jane456", "password", "Jane", "Smith", true);
        userList.addUser("sam789", "password", "Sam", "Johnson", false);
        Assert.assertEquals(2, userList.getStudents().size());
    }

    @Test
    public void testGetAdvisors() {
        userList.addUser("john123", "password", "John", "Doe", false);
        userList.addUser("jane456", "password", "Jane", "Smith", true);
        userList.addUser("sam789", "password", "Sam", "Johnson", false);
        Assert.assertEquals(1, userList.getAdvisors().size());
    }

    @Test
    public void testLogin() {
        User student = new Student("john12345", "password", "John", "Doe");
        userList.addUser(student);
        Assert.assertEquals(student, userList.login("john12345", "password"));
        Assert.assertNull(userList.login("john12345", "wrongPassword"));
        Assert.assertNull(userList.login("invalidUser", "password"));
    }

    @Test
    public void testModifyUser() {
        User student = new Student("john123456", "password", "John", "Doe");
        userList.addUser(student);
        User newStudent = new Student("john123456", "newPassword", "John", "Doe");
        userList.modifyUser(student, newStudent);
        Assert.assertEquals("newPassword", userList.getUser("john123456").getPassword());
    }
}
