package model;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    private ArrayList<String> currentCourses;
    private ArrayList<Course> completedCourses;
    private Major major;
    private long currentSemester;
    private ArrayList<String> advisingNotes;
    private String program;
    private String advisor;
    private ArrayList<ArrayList<String>> finishedCourses;
    public ArrayList<String> dashboardWarnings;

    public Student() {
        // Initialize all attributes with default values
        this.currentCourses = new ArrayList<String>();
        this.major = null; // Assuming 'null' means no major assigned yet.
        this.currentSemester = 1;
        this.advisingNotes = new ArrayList<String>();
        this.program = ""; // Assuming empty string means no program assigned yet.
        this.advisor = " "; // Assuming empty string means no advisor assigned yet.
        this.finishedCourses = new ArrayList<ArrayList<String>>();
        this.dashboardWarnings = new ArrayList<String>();
    }

    public Student(String username, String password, String firstname, String lastname) {
        super(username, password, firstname, lastname);
        // Initialize all attributes with default values
        this.currentCourses = new ArrayList<String>();
        this.major = new Major("undecided"); // Assuming 'null' means no major assigned yet.
        this.currentSemester = 1;
        this.advisingNotes = new ArrayList<String>();
        this.program = ""; // Assuming empty string means no program assigned yet.
        this.advisor = " "; // Assuming empty string means no advisor assigned yet.
        this.finishedCourses = new ArrayList<ArrayList<String>>();
        this.dashboardWarnings = new ArrayList<String>();
    }

    public void setCurrentCourses(ArrayList<String> currentCourses) {
        this.currentCourses = currentCourses;
    }

    public void setMajor(Major major) {
        this.major = major; // This assumes Major is a class. Adjust if it's a different type.
    }

    public void setCurrentSemester(long currentSemester) {
        this.currentSemester = currentSemester;
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

    public void setFinCourse(ArrayList<ArrayList<String>> finishedCourses) {
        this.finishedCourses = finishedCourses;
    }

    public void setFinishedCourses(ArrayList<ArrayList<String>> finishedCourses) {
    
        // Iterate through the lists of course names and grades
        for (int i = 0; i < finishedCourses.size(); i++) {
            // Create a new list to store the course name and the corresponding grade
            ArrayList<String> courseWithGrade = finishedCourses.get(i);
            courseWithGrade.add(courseWithGrade.get(0)); // Add course name
            courseWithGrade.add(courseWithGrade.get(1));      // Add grade
            courseWithGrade.add(courseWithGrade.get(2));
    
            // Add the courseWithGrade list to the finishedCourses list
            this.finishedCourses.add(courseWithGrade);
        }
    }

    // Used in DataLoader
    public void addFinishedCourse(String courseID, String grade, String semester) {
        // Create a new ArrayList to store the course and grade
        ArrayList<String> courseWithGrade = new ArrayList<>();
        
        // Add the course ID and grade to the list
        courseWithGrade.add(courseID); // First element is the course ID
        courseWithGrade.add(grade);    // Second element is the grade
        courseWithGrade.add(semester);   // Third element is the semester the semester the course was completed
        
        // Add this course and grade list to the list of finished courses
        finishedCourses.add(courseWithGrade);
    }
    
    public void setDashboardWarnings(ArrayList<String> dashboardWarnings) {
        this.dashboardWarnings = dashboardWarnings;
    }
    
    public ArrayList<String> getCurrentCourses() {
        return new ArrayList<>(this.currentCourses); // Provides a copy of the currentCourses list
    }

    public ArrayList<Course> getCompletedCourses() {
        return new ArrayList<>(this.completedCourses); // Provides a copy of the completedCourses list
    }

    public void setCompletedCourses(ArrayList<Course> completedCourses) {
        this.completedCourses = completedCourses;
    }

    public Major getMajor() {
        return this.major; // Returns the major
    }

    public long getCurrentSemester() {
        return this.currentSemester;
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
    
    public void updateFinishedCourseObjects(ArrayList<Course> allCourses) {
        if(this.completedCourses != null) {
            this.completedCourses.clear();
        }
        ArrayList<Course> finishedCourseObjects = new ArrayList<>();
        for (ArrayList<String> semesterCourses : this.getFinishedCourses()) {
            for (String courseID : semesterCourses) {
                for (Course course : allCourses) {
                    if (course.getCourseID().equals(courseID)) {
                        finishedCourseObjects.add(course);
                        break;
                    }
                }
            }
        }
        this.completedCourses = finishedCourseObjects; 
    }

    public void updateCurrentCourseObjects(ArrayList<Course> allCourses) {
        if(this.completedCourses != null) {
            this.completedCourses.clear();
        }        
        updateFinishedCourseObjects(allCourses);
        ArrayList<Course> finishedCourses = this.completedCourses;
        for (String currentCourse : this.getCurrentCourses()) {
            for (Course course : allCourses) {
                if (course.getCourseID().equals(currentCourse)) {
                    finishedCourses.add(course);
                    break;
                }
            }
        }
        this.completedCourses = finishedCourses;
    }

    public void updateBothObjects(ArrayList<Course> allCourses) {
        updateFinishedCourseObjects(allCourses);
        updateCurrentCourseObjects(allCourses);
    }

    public ArrayList<Course> getFinishedCourseObjects(ArrayList<Course> allCourses) {
        updateFinishedCourseObjects(allCourses);
        return this.completedCourses; // Provides a copy of the completedCourses list WITH JUST FINISHED
    }

    public ArrayList<Course> getCurrentCourseObjects(ArrayList<Course> allCourses) {
        updateCurrentCourseObjects(allCourses);
        return this.completedCourses; // Provides a copy of the completedCourses list WITH JUST CURRENT
    }

    public ArrayList<Course> getBothCourseObjects(ArrayList<Course> allCourses) {
        updateBothObjects(allCourses);
        return this.completedCourses; // Provides a copy of the completedCourses list WITH BOTH
    }
    

    public ArrayList<String> getDashboardWarnings() {
        return new ArrayList<>(this.dashboardWarnings); // Provides a copy of the dashboardWarnings list
    }

    public void updateStudentTranscript(String courseID, String grade) {
        boolean courseFound = false;
        for (ArrayList<String> course : finishedCourses) {
            if (course.get(0).equals(courseID)) { // Assuming first element is the courseID
                course.set(1, grade); // Update the grade
                courseFound = true;
                break;
            }
        }

        if (!courseFound) {
            // If the course is not found, add a new entry for it
            ArrayList<String> newCourseEntry = new ArrayList<>();
            newCourseEntry.add(courseID);
            newCourseEntry.add(grade);
            finishedCourses.add(newCourseEntry);
        }
    }

    public void viewRecord() {
        System.out.println("Student Record for: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Major: " + (this.major != null ? this.major.getName() : "Undeclared"));
        System.out.println("Program: " + this.program);
        System.out.println("Completed Courses:");
        for (ArrayList<String> courseEntry : finishedCourses) {
            // Assuming the format is [CourseID, Grade]
            System.out.println(courseEntry.get(0) + "\t" + courseEntry.get(1)); // Prints in the format "EMCH101 \t A"
        }
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

    public ArrayList<String> getStudentInfo() {
        ArrayList<String> info = new ArrayList<>();

        info.add("Semester: " + getCurrentSemester());
        info.add("Major: " + getMajor());
        info.add("Program: " + getProgram());
        info.add("Email: " + getEmail());

        return info;
    }

    public ArrayList<String> getTranscript() {
        ArrayList<String> transcript = new ArrayList<>();

        for (ArrayList<String> finCourse : this.finishedCourses) {
            String add = finCourse.get(0) + ", " + finCourse.get(1) + ", Semester: " + finCourse.get(2);

            transcript.add(add);
        }

        return transcript;
    }

    public int getHours() {
        int hours = 0;

        CourseList courseList = CourseList.getInstance();

        for (ArrayList<String> list : finishedCourses) {
            Course c = courseList.findCourseByCode(list.get(0));
            if (c == null) {
                hours += 3;
                continue;
            }
            hours += c.getHours();
        }

        return hours;
    }
    
}