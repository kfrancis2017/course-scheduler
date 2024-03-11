package degreeswork;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    private ArrayList<String> currentCourses;
    private Major major;
    private ArrayList<String> advisingNotes;
    private String program;
    private String advisor;
    private ArrayList<ArrayList<String>> finishedCourses;
    public ArrayList<String> dashboardWarnings;

    public Student() {
        // Initialize all attributes with default values
        this.currentCourses = new ArrayList<String>();
        this.major = null; // Assuming 'null' means no major assigned yet.
        this.advisingNotes = new ArrayList<>();
        this.program = ""; // Assuming empty string means no program assigned yet.
        this.advisor = ""; // Assuming empty string means no advisor assigned yet.
        this.finishedCourses = new ArrayList<>();
        this.dashboardWarnings = new ArrayList<>();
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

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public void setFinishedCourses(ArrayList<String> courseNames, ArrayList<String> grades) {
        // Check if courseNames and grades have the same length
        if (courseNames.size() != grades.size()) {
            throw new IllegalArgumentException("Course names and grades must be of equal length");
        }
    
        // Initialize the finishedCourses list
        this.finishedCourses = new ArrayList<>();
    
        // Iterate through the lists of course names and grades
        for (int i = 0; i < courseNames.size(); i++) {
            // Create a new list to store the course name and the corresponding grade
            ArrayList<String> courseWithGrade = new ArrayList<>();
            courseWithGrade.add(courseNames.get(i)); // Add course name
            courseWithGrade.add(grades.get(i));      // Add grade
    
            // Add the courseWithGrade list to the finishedCourses list
            this.finishedCourses.add(courseWithGrade);
        }
    }

    public void addFinishedCourse(String courseID, String grade) {
        // Create a new ArrayList to store the course and grade
        ArrayList<String> courseWithGrade = new ArrayList<>();
        
        // Add the course ID and grade to the list
        courseWithGrade.add(courseID); // First element is the course ID
        courseWithGrade.add(grade);    // Second element is the grade
        
        // Add this course and grade list to the list of finished courses
        finishedCourses.add(courseWithGrade);
    }
    
    public void setDashboardWarnings(ArrayList<String> dashboardWarnings) {
        this.dashboardWarnings = dashboardWarnings;
    }

    public void createSchedule() {
        //TODO LAST 
    }

    public ArrayList<String> getCurrentCourses() {
        return new ArrayList<>(this.currentCourses); // Provides a copy of the currentCourses list
    }

    public Major getMajor() {
        return this.major; // Returns the major
    }

    public ArrayList<String> getAdvisingNotes() {
        return new ArrayList<>(this.advisingNotes); // Provides a copy of the advisingNotes list
    }

    public String getProgram() {
        return this.program; // Returns the program name
    }

    public String getAdvisor() {
        return this.advisor; // Returns the advisor ID
    }

    public ArrayList<ArrayList<String>> getFinishedCourses() {
        // Provides a deep copy of the finishedCourses list to avoid privacy leaks
        ArrayList<ArrayList<String>> copyOfFinishedCourses = new ArrayList<>();
        for (ArrayList<String> courseGradePair : this.finishedCourses) {
            // Create a new list from each pair (to prevent modification of the original lists)
            copyOfFinishedCourses.add(new ArrayList<>(courseGradePair));
        }
        return copyOfFinishedCourses;
    }
    
    public ArrayList<String> getDashboardWarnings() {
        return new ArrayList<>(this.dashboardWarnings); // Provides a copy of the dashboardWarnings list
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
        sb.append(", \nfinishedCourses=").append(finishedCourses);
        sb.append(", \ndashboardWarnings=").append(dashboardWarnings);
        sb.append('}');
        return sb.toString();
    }


}
