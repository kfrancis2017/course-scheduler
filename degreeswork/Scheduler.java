package degreeswork;

import java.util.ArrayList;

public class Scheduler {
    private int maxCreditsPerSemester;
    private static CourseList courses = CourseList.getInstance();
    

    public void calculateTotalCreditHours(CourseList schedule) {
        
    }

    public double calculateGPA() {
        return 0.0;
    }

    public Major loadMajor(String majorDB) {
        return null;
    }

    public static ArrayList<String> createSchedule(Student student) {
        // Create the arraylist that will hold the plan
        ArrayList<ArrayList<Course>> plan = new ArrayList<ArrayList<Course>>(); 

        // Load student's major
        Major major = student.getMajor();
        ArrayList<Course> majorCourses = major.getCourses();

        // Loads student's finished courses, which contains courseID, grade, and semester taken
        ArrayList<ArrayList<String>> finCourDetails = student.getFinishedCourses();

        ArrayList<Course> finishedCourses = new ArrayList<Course>();

        // Put finished courses into an arraylist
        for (ArrayList<String> list : finCourDetails) {
            finishedCourses.add(courses.findCourseByCode(list.get(0)));
        }

        // Set up 8 semesters
        for (int i = 0; i < 8; i++) {
            ArrayList<Course> sem = new ArrayList<Course>();
            plan.add(sem);
        }

        // Add finished courses to their appropriate semester
        for (ArrayList<String> list : finCourDetails) {
            plan.get(Integer.parseInt(list.get(2))).add(courses.findCourseByCode(list.get(0)));
        }

        // Fill an array of courses that need to be taken still to fufill major
        ArrayList<Course> todo = new ArrayList<Course>();

        if ()






 


        return null;
    }

    public double currentGPA() {
        return 0.0;
    }
}
