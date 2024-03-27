package degreeswork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Scheduler {
    private int maxCreditsPerSemester;
    private static CourseList courses = CourseList.getInstance();
    public void calculateTotalCreditHours(CourseList schedule) { 
    }

    public double calculateGPA() {
        return 0.0;
    }

    public static void createSchedule(Student student) {
        ArrayList<ArrayList<Course>> plan = new ArrayList<ArrayList<Course>>(); 
        Major major = student.getMajor();
        System.out.println(major.getName());
        ArrayList<ArrayList<Course>> majorCourses = major.getCourses();
        for (ArrayList<Course> list : majorCourses) {
            for (Course course : list) {
                System.out.println(course.toString());
            }
        }
        ArrayList<ArrayList<String>> finCourDetails = student.getFinishedCourses();

        for (ArrayList<String> list : finCourDetails) {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
        ArrayList<Course> finishedCourses = new ArrayList<Course>();
        for (ArrayList<String> list : finCourDetails) {
            finishedCourses.add(courses.findCourseByCode(list.get(0)));
        }
        for (Course course : finishedCourses) {
            System.out.println(course.getCourseID());
        }
        for (int i = 0; i < 8; i++) {
            ArrayList<Course> sem = new ArrayList<Course>();
            plan.add(sem);
        }
        for (ArrayList<String> list : finCourDetails) {
            plan.get(Integer.parseInt(list.get(2))-1).add(courses.findCourseByCode(list.get(0)));
        }
        for (ArrayList<Course> list : plan) {
            System.out.println(list.get(0).getCourseID());
        }
        ArrayList<Course> todo = new ArrayList<Course>();
        for (ArrayList<Course> options : majorCourses) {
            for (Course fin : finishedCourses) {
                if (!options.get(0).toString().equals(fin.toString())) 
                    todo.add(options.get(0));
                
            }
        }
        for (ArrayList<Course> sem : plan) {
            int semHours = 0;
            if (sem.size() != 0) {
                for (int i = 0; i < sem.size(); i++) {
                    Course course = sem.get(i);
                    if(course != null) {
                        semHours += course.getHours();
                    } else {
                        break;
                    }
                }
            }
            while (semHours < 15) {
                if (!todo.isEmpty()) {
                sem.add(todo.get(0));
                semHours += todo.get(0).getHours();
                todo.remove(0);
                for (int i = 0; i < todo.size(); i++) {
                    todo.set(i, todo.get(i+1));
                }
                } else {
                    break;
                }
            }
        }
        String fileName = student.getUsername() + "Plan.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < plan.size(); i++) {
                writer.write("Semester " + (i+1) + ":\n");
                writer.write("__________________\n");
                for (int j = 0; j < plan.get(i).size(); j++) {
                    writer.write(plan.get(i).get(i).toString() +"\n");
                }
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public double currentGPA() {
        return 0.0;
    }
}
