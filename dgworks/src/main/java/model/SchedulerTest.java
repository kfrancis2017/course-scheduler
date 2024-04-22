package model;
import java.util.ArrayList;

public class SchedulerTest {
    public static void main(String[] args) {
        DegreeWorks dg = DegreeWorks.getInstance();
        //Load all courses
        DataLoader.getAllCourses();
        ArrayList<Course> courses = CourseList.getInstance().getCourses();

        // Load majors from DataLoader
        DataLoader.getAllMajors();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();

        // Create student and set their major and finished courses
        Student student = dg.getStudent("bwest");
        // Create scheduler and generate schedule
        Scheduler scheduler = new Scheduler(student.getMajor(), student, courses);
        ArrayList<ArrayList<Course>> schedule = scheduler.createNextSchedule(student);

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
