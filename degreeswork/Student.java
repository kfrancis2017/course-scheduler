package degreeswork;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    private ArrayList<String> currentCourses;
    private Major major;
    private ArrayList<String> advisingNotes;
    private String program;
    private String advisor;
    private double majorGPA;
    private double overallGPA;
    private double programCompletionPercentage;
    private double coreCompletionPercentage;
    private double degreeCompletionPercentage;
    private ArrayList<Course> finishedCourses;
    public ArrayList<String> dashboardWarnings;

    public Student() {
        // Initialize all attributes with default values
        this.currentCourses = new ArrayList<String>();
        this.major = null; // Assuming 'null' means no major assigned yet.
        this.advisingNotes = new ArrayList<>();
        this.program = ""; // Assuming empty string means no program assigned yet.
        this.advisor = ""; // Assuming empty string means no advisor assigned yet.
        this.majorGPA = 0.0;
        this.overallGPA = 0.0;
        this.programCompletionPercentage = 0.0;
        this.coreCompletionPercentage = 0.0;
        this.degreeCompletionPercentage = 0.0;
        this.finishedCourses = new ArrayList<>();
        this.dashboardWarnings = new ArrayList<>();
    }

    // Setters

     public void setUserID(UUID userID) {
        super.setUserID(userID); // Assuming the userID is handled in the User class
    }

    public void setUsername(String username) {
        super.setUsername(username); // Assuming the username is handled in the User class
    }

    public void setPassword(String password) {
        super.setPassword(password); // Assuming the password is handled in the User class
    }

    public void setEmail(String email) {
        super.setEmail(email); // Assuming the email is handled in the User class
    }

    public void setFirstName(String firstName) {
        super.setFirstName(firstName); // Assuming the firstName is handled in the User class
    }

    public void setLastName(String lastName) {
        super.setLastName(lastName); // Assuming the lastName is handled in the User class
    }

    public void setCurrentCourses(ArrayList<String> currentCourses) {
        this.currentCourses = currentCourses;
    }

    public void setMajor(Major major) {
        this.major = major; // This assumes Major is a class. Adjust if it's a different type.
    }

    public void setAdvisingNotes(ArrayList<String> advisingNotes) {
        this.advisingNotes = advisingNotes; // Assuming sessionNotes map to advisingNotes
    }

    public void addAdvisingNotes(String advisingNotes) {
        this.advisingNotes.add(advisingNotes); // Assuming sessionNotes map to advisingNotes
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setCurrentAdvisor(UUID currentAdvisor) {
        this.advisor = currentAdvisor.toString(); // Assuming the advisor is stored as a String
    }

    public void setMajorGPA(double majorGPA) {
        this.majorGPA = majorGPA;
    }

    public void setOverallGPA(double overallGPA) {
        this.overallGPA = overallGPA;
    }

    public void setMajorCompletionPercentage(double majorCompletionPercentage) {
        this.programCompletionPercentage = majorCompletionPercentage; // Check the corresponding attribute
    }

    public void setCoreCompletionPercentage(double coreCompletionPercentage) {
        this.coreCompletionPercentage = coreCompletionPercentage;
    }

    public void setDegreeCompletionPercentage(double degreeCompletionPercentage) {
        this.degreeCompletionPercentage = degreeCompletionPercentage;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public void setProgramCompletionPercentage(double programCompletionPercentage) {
        this.programCompletionPercentage = programCompletionPercentage;
    }

    public void setFinishedCourses(ArrayList<Course> finishedCourses) {
        this.finishedCourses = finishedCourses;
    }

    public void setDashboardWarnings(ArrayList<String> dashboardWarnings) {
        this.dashboardWarnings = dashboardWarnings;
    }


    public String viewCourseDetails(String courseID) {
       
        return "";
    }

    public String viewProgramRequirements() {
        
        return ""; 
    }

    public void changeProgram(String newData) {
        
    }

    public void updateStudentTranscript(String courseID, String grade) {
        
    }

    public void createSchedule() {
        
    }

    public void viewRecord() {
        
    }
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Student{");
    sb.append("\nuserID=").append(super.getUserID());
    sb.append(", \nusername='").append(getUsername()).append('\'');
    sb.append(", \nemail='").append(getEmail()).append('\'');
    sb.append(", \nfirstName='").append(getFirstName()).append('\'');
    sb.append(", \nlastName='").append(getLastName()).append('\'');
    sb.append(", \ncurrentCourses=").append(currentCourses);
    sb.append(", \nmajor=").append(major);
    sb.append(", \nadvisingNotes=").append(advisingNotes);
    sb.append(", \nprogram='").append(program).append('\'');
    sb.append(", \nadvisor='").append(advisor).append('\'');
    sb.append(", \nmajorGPA=").append(majorGPA);
    sb.append(", \noverallGPA=").append(overallGPA);
    sb.append(", \nprogramCompletionPercentage=").append(programCompletionPercentage);
    sb.append(", \ncoreCompletionPercentage=").append(coreCompletionPercentage);
    sb.append(", \ndegreeCompletionPercentage=").append(degreeCompletionPercentage);
    sb.append(", \nfinishedCourses=").append(finishedCourses);
    sb.append(", \ndashboardWarnings=").append(dashboardWarnings);
    sb.append('}');
    return sb.toString();
}


}
