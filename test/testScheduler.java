package test;

import java.util.ArrayList;

import degreeswork.Course;
import degreeswork.Student;
import degreeswork.User;
import degreeswork.UserList;
import degreeswork.Major;
import degreeswork.Scheduler;

public class testScheduler {
    public static void main(String[] args) {
        Major major = new Major("Computer Science");
        Student student = new Student("john123", "password", "John", "Doe");
        Scheduler scheduler = new Scheduler(major, student, major.getCourseList());
        ArrayList<ArrayList<Course>> schedule = scheduler.createSchedule();


       System.out.println("Generated Schedule for " + student.getFirstName() + " " + student.getLastName() + ":");
       
       for (int semester = 0; semester < schedule.size(); semester++) {
           System.out.println("\n Semester " + (semester + 1) + ":");
           for (Course course : schedule.get(semester)) {
               System.out.println(course.getTitle() + " (" + course.getCourseID() + ")");
           }
       }
    }
}
