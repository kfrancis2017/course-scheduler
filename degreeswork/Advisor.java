package degreeswork;

import java.util.ArrayList;

public class Advisor extends User {

    private ArrayList<String> adviseeList;
    private String advisorSpecialization;

    public Advisor() {
        // Initialize the adviseeList to prevent NullPointerException
        this.adviseeList = new ArrayList<>();
    }

    public ArrayList<String> getAdviseeList() {
        return this.adviseeList;
    }

    public String getAdviseeDetails(String username) {
        UserList userList = UserList.getInstance(); // Access the singleton UserList instance
        User user = userList.getUser(username); // Use the provided method to get a User object
        
        if (user != null) {
            // Format user details into a string. Adjust formatting as needed.
            return String.format("Username: %s, Name: %s %s", user.getUsername(), user.getFirstName(), user.getLastName());
        } else {
            return "User not found";
        }
    }

    public void addAdvisee(String username) {
        adviseeList.add(username);
    }


    public String getAdvisorSpecialization() {
        return this.advisorSpecialization;
    }

    public void addAdvisingSession(Student student, String sessionNotes) {
        student.addAdvisingNotes(this.getUsername() + " said: " + sessionNotes + " on " + new java.util.Date());
    }

    public void setAdviseeList(ArrayList<String> advisees) {
        this.adviseeList = advisees; // This corrects the previous method.
    }

    public void addAdvisee(Student student) {
        // Ensure adviseeList is initialized
        if (this.adviseeList == null) {
            this.adviseeList = new ArrayList<>();
        }
        this.adviseeList.add(student.getUsername());
    }

    public void setAdvisorSpecialization(String specialization) {
        this.advisorSpecialization = specialization;
    }
}
