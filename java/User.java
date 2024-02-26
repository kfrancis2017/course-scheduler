package java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    
    private String username;
    private String password;

    private String lastLogin;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public String firstname;
    public String lastname;

    /**
     * Initializes new User with specified params and sets lastLogin to current date/time
     * @param username The User's username
     * @param password The User's password
     * @param firstname The User's first name
     * @param lastname The User's last name
     */
    public User(String username, String password, String firstname, String lastname) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.lastLogin = LocalDateTime.now().format(formatter);
    }

    /**
     * Edit attributes of the User's profile
     * @param details 
     * @return A boolean value depending on the success of the profile update
     */
    public boolean updateProfile(String details) {
        lastLogin = LocalDateTime.now().format(formatter);
        return true;
    }

    /**
     * Sets password to a new String value
     * @return A boolean value depending on the success of the password change.
     */
    public boolean changePassword(String password) {
        if (this.password == password)
            return false;
        this.password = password;
        return true;
    }

    /**
     * Verifies if String enter is equal to the password
     * @param password The inputted password
     * @return A boolean value depending on the equivalence of the passwords
     */
    public boolean checkPassword(String password) {
        if (this.password == password)
            return true;
        return false;
    }

    /**
     * Returns String of profile details
     * @return String representation of the profile details
     */
    public String viewProfile() {
        return "Username: " + this.username
                + "\nPassword: " + this.password
                + "\nFirst Name: " + this.firstname
                + "\nLast Name: " + this.lastname
                + "\nLast Login: " + this.lastLogin;
    }

    public String getUsername() {
        return username;
    }


}
