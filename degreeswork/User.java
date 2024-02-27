package degreeswork;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class User {
    
    private UUID userID;
    private String username;
    private String password;
    private String email;
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

    public User(){
        //creating default values
        this.username="";
        this.password="";
        this.firstname="";
        this.lastname="";
        this.lastLogin="";
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
        if (this.password.equals(password))
            return true;
        return false;
    }

    /**
     * Returns String of profile details
     * @return String representation of the profile details
     */
    public String toString() {
        return "Username: " + this.username
                + "\nPassword: " + this.password
                + "\nFirst Name: " + this.firstname
                + "\nLast Name: " + this.lastname
                + "\nLast Login: " + this.lastLogin;
    }

    public String getUsername() {
        return username;
    }

    //Setters
        // Setter for userID
    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Setter for firstName
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }

    // Setter for lastName
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public UUID getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }
}
