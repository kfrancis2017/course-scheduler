package model;
import java.util.ArrayList;

public class SchedulerTest {
    public static void main(String[] args) {
        //Load all courses
        DataLoader.getAllCourses();
        ArrayList<Course> courses = CourseList.getInstance().getCourses();

        // Load majors from DataLoader
        DataLoader.getAllMajors();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();

        // Create student and set their major and finished courses
        Student student = new Student("username", "password", "First", "Last");
        student.setMajor(majors.get(0));
        ArrayList<ArrayList<String>> finishedCourses = new ArrayList<>();
        student.setFinishedCourses(finishedCourses);

        // Create scheduler and generate schedule
        Scheduler scheduler = new Scheduler(majors.get(0), student, courses);
        ArrayList<ArrayList<Course>> schedule = scheduler.createSchedule();

        // Print schedule
        System.out.println("Generated Schedule for " + student.getFirstName() + " " + student.getLastName() + ":");
        for (int semester = 0; semester < schedule.size(); semester++) {
            System.out.println("\n Semester " + (semester + 1) + ":");
            for (Course course : schedule.get(semester)) {
                System.out.println(course.getTitle() + " (" + course.getCourseID() + ")");
            }
        }
    }
}
