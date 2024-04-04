package test;

import java.sql.DriverAction;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import degreeswork.Course;
import degreeswork.CourseList;
import degreeswork.Student;
import degreeswork.UserList;
import degreeswork.Major;
import degreeswork.MajorList;
import degreeswork.Scheduler;
import degreeswork.DataLoader;

public class testScheduler {
    public static void main(String[] args) {
        DataLoader.getAllCourses();
        ArrayList<Course> courses = CourseList.getInstance().getCourses();

        DataLoader.getAllMajors();
        DataLoader.getAllAdvisors();
        DataLoader.getAllStudents();

        UserList users = UserList.getInstance();
        ArrayList<Major> majors = MajorList.getInstance().getMajors();
        Student student = users.getStudents().get(0);
        Major major = student.getMajor();

        Scheduler scheduler = new Scheduler(major, student, courses);
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
