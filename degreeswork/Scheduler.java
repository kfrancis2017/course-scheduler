package degreeswork;

import java.util.ArrayList;

public class Scheduler {
    private int maxCreditsPerSemester;
    private CourseList courses;
    private CourseList userCompletedCourses;

    public void calculateTotalCreditHours(CourseList schedule) {
        
    }

    public double calculateGPA() {
        return 0.0;
    }

    public Major loadMajor(String majorDB) {
        return null;
    }

    public static ArrayList<String> createSchedule(Student student) {
        ArrayList<String> plan = new ArrayList<String>();

        for (ArrayList<String> entry : student.getFinishedCourses()) {
            plan.add(entry.get(0) + " Semester: " + entry.get(2));
        }

        for (String course : student.getCurrentCourses()) {
            plan.add(course + " Semester: " + student.getCurrentSemester());
        }


        return plan;
    }

    public double currentGPA() {
        return 0.0;
    }
}
