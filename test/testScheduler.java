package test;

import java.util.ArrayList;

import javax.xml.crypto.Data;

import degreeswork.DataLoader;
import degreeswork.Scheduler;
import degreeswork.Student;
import degreeswork.UserList;

public class testScheduler {
       public static void main(String[] args) {
        DataLoader.getAllCourses();
        DataLoader.getAllMajors();
        DataLoader.getAllStudents();
        DataLoader.getAllAdvisors();

        UserList users = UserList.getInstance();
        ArrayList<Student> students = users.getStudents();
        Student student = students.get(0);

        // Create a schedule for the sample student
        Scheduler.createSchedule(student);

        // Display message indicating schedule creation success
        System.out.println("Schedule created successfully for " + student.getUsername());
    }
}
