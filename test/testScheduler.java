package test;

import java.util.ArrayList;
import java.util.Scanner;

import degreeswork.Course;
import degreeswork.DataLoader;
import degreeswork.Student;
import degreeswork.User;
import degreeswork.UserList;
import degreeswork.Major;
import degreeswork.MajorList;
import degreeswork.Scheduler;

public class testScheduler {

    private static UserList users = UserList.getInstance();
    private static MajorList majors = MajorList.getInstance();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        DataLoader.loadAll();

        // System.out.println("Available Majors:");
        // for (Major major : majors.getMajors()) {
        //     System.out.println(major.toString());
        // }

        System.out.println("Available students:");
        for (Student student : users.getStudents()) {
            System.out.println(student.getUsername());
        }
    
        System.out.print("Enter Student username: ");
        String username = input.nextLine();

        Student student = users.getStudent(username);
        Major major = student.getMajor();

        System.out.println(student.getMajor().toString());
        System.out.println(student.getMajor().getCourseList());

        
        Scheduler scheduler = new Scheduler(major, student, major.getCourseList());
        ArrayList<ArrayList<Course>> schedule = scheduler.createSchedule();

        System.out.println(major.toString());
        System.out.println(schedule.get(0).get(0).getCourseID());

       System.out.println("Generated Schedule for " + student.getFirstName() + " " + student.getLastName() + ":");
       
       for (int semester = 0; semester < schedule.size(); semester++) {
           System.out.println("\n Semester " + (semester + 1) + ":");
           for (Course course : schedule.get(semester)) {
               System.out.println(course.getTitle() + " (" + course.getCourseID() + ")");
           }
       }
    }
}
