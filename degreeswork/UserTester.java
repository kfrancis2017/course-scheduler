package degreeswork;

public class UserTester {
    public static void main(String[] args) {
        // Create a new User object
        User user = new User("johndoe", "123456", "John", "Doe");
        System.out.println("User created:");
        System.out.println(user);

        // Change the user's password
        boolean passwordChanged = user.changePassword("654321");
        System.out.println("\nPassword changed: " + passwordChanged);
        
        // Attempt to change the password to the same password
        passwordChanged = user.changePassword("654321");
        System.out.println("Attempt to change to same password: " + passwordChanged);

        // Check if the new password is correct
        boolean passwordCorrect = user.checkPassword("6543217");
        System.out.println("\nNew password is correct: " + passwordCorrect);

        // Update profile details
        boolean profileUpdated = user.updateProfile("New details");
        System.out.println("\nProfile updated: " + profileUpdated);
        
        // Print the updated user details
        System.out.println("\nUpdated User details:");
        System.out.println(user);
    }
}
