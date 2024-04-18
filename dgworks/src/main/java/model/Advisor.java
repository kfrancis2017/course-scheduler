package model;

import java.util.ArrayList;

public class Advisor extends User {
    private ArrayList<String> adviseeList;
    private String advisorSpecialization;

    public Advisor() {
        super(); 
        // Initialize the adviseeList to prevent NullPointerException
        this.adviseeList = new ArrayList<>();
    }

    public Advisor(String user, String pass, String first, String last) {
        super(user, pass, first, last ); 
        // Initialize the adviseeList to prevent NullPointerException
        this.adviseeList = new ArrayList<>();
    }

    public ArrayList<String> getAdviseeList() {
        return adviseeList;
    }

    public Student getAdvisee(String user) {
        for(String userName : adviseeList){
            if(userName.equals(user)){
                UserList users = UserList.getInstance();
                ArrayList<Student> list = users.getStudents();
                for(Student student : list) {
                    if(student.getUsername().equals(user)) {
                        return student;
                    }
                }
            }
        }
        return null;
    }

    public String getAdviseeDetails(Student student) {
        UserList userList = UserList.getInstance(); // Access the singleton UserList instance
       // User user = userList.getUser(username); // Use the provided method to get a User object
        
       // if (student != null) {
            // Format user details into a string. Adjust formatting as needed.
            
            return student.toString();

          //  return String.format("Username: %s, Name: %s %s", user.getUsername(), user.getFirstName(), user.getLastName()) + ;
        // } else {
        //     return "User not found";
        // }
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
        
        // Check if student is already an advisee
        if (!adviseeList.contains(student.getUsername())) {
            this.adviseeList.add(student.getUsername());
            DataWriter.SaveAllUsers();
        }
    }
    
    public void setAdvisorSpecialization(String specialization) {
        this.advisorSpecialization = specialization;
    }
}
