package test;

import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

import degreeswork.User;

public class testUser {
    
    @Test
    public void testConstructor() {
        User user = new User("john123", "password", "John", "Doe");
        Assert.assertNotNull(user.getUserID());
        Assert.assertEquals("john123", user.getUsername());
        Assert.assertEquals("password", user.getPassword());
        Assert.assertEquals("John", user.getFirstName());
        Assert.assertEquals("Doe", user.getLastName());
    }

    @Test
    public void testUpdateProfile() {
        User user = new User("john123", "password", "John", "Doe");
        String newDetails = "Updated details";
        Assert.assertTrue(user.updateProfile(newDetails));
    }

    @Test
    public void testChangePassword() {
        User user = new User("john123", "password", "John", "Doe");
        String newPassword = "newPassword";
        Assert.assertTrue(user.changePassword(newPassword));
        Assert.assertEquals(newPassword, user.getPassword());
    }

    @Test
    public void testCheckPassword() {
        User user = new User("john123", "password", "John", "Doe");
        String correctPassword = "password";
        String incorrectPassword = "incorrect";
        Assert.assertTrue(user.checkPassword(correctPassword));
        Assert.assertFalse(user.checkPassword(incorrectPassword));
    }

    @Test
    public void testToString() {
        User user = new User("john123", "password", "John", "Doe");
        String expectedString = "Username: john123\n" +
                                "Password: password\n" +
                                "First Name: John\n" +
                                "Last Name: Doe\n" +
                                "Last Login: ";
        String del = user.toString();
        Assert.assertEquals(expectedString, del.substring(0, del.length() - 16)); // Ignore the last login value as it changes
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setUserID(UUID.randomUUID());
        user.setUsername("john123");
        user.setPassword("password");
        user.setEmail("john@example.com");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setAccountStatus("active");

        Assert.assertNotNull(user.getUserID());
        Assert.assertEquals("john123", user.getUsername());
        Assert.assertEquals("password", user.getPassword());
        Assert.assertEquals("john@example.com", user.getEmail());
        Assert.assertEquals("John", user.getFirstName());
        Assert.assertEquals("Doe", user.getLastName());
        Assert.assertEquals("active", user.getAccountStatus());
    }
}
