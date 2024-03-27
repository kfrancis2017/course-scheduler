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

    public Major loadMajor(String majorDB) {
        return null;
    }

    public static void createSchedule(Student student) {
        // Create the arraylist that will hold the plan
        ArrayList<ArrayList<Course>> plan = new ArrayList<ArrayList<Course>>(); 

        // Load student's major
        Major major = student.getMajor();
        System.out.println(major.getName());
        ArrayList<ArrayList<Course>> majorCourses = major.getCourses();
        for (ArrayList<Course> list : majorCourses) {
            System.out.println(list.get(0).getCourseID());
        }
        // Loads student's finished courses, which contains courseID, grade, and semester taken
        ArrayList<ArrayList<String>> finCourDetails = student.getFinishedCourses();

        for (ArrayList<String> list : finCourDetails) {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }

        ArrayList<Course> finishedCourses = new ArrayList<Course>();

        // Put finished courses into an arraylist
        for (ArrayList<String> list : finCourDetails) {
            finishedCourses.add(courses.findCourseByCode(list.get(0)));
        }

        for (Course course : finishedCourses) {
            System.out.println(course.getCourseID());
        }
        // Set up 8 semesters
        for (int i = 0; i < 8; i++) {
            ArrayList<Course> sem = new ArrayList<Course>();
            plan.add(sem);
        }

        // Add finished courses to their appropriate semester
        for (ArrayList<String> list : finCourDetails) {
            plan.get(Integer.parseInt(list.get(2))-1).add(courses.findCourseByCode(list.get(0)));
        }

        for (ArrayList<Course> list : plan) {
            System.out.println(list.get(0).getCourseID());
        }

        // Creates an arraylist of courses that need to be taken still to fufill major
        ArrayList<Course> todo = new ArrayList<Course>();

        // Fills todo list with courses from major map
        for (ArrayList<Course> options : majorCourses) {
            for (Course fin : finishedCourses) {
                // Checks if student has already finished a course found on the major map
                if (!options.get(0).toString().equals(fin.toString())) 
                    todo.add(options.get(0));
                
            }
        }

        // Fill out the plan with todo list
        for (ArrayList<Course> sem : plan) {
            int semHours = 0;
            // Tally up credits of finished courses if present
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
                // Adds the course at the top of the todo list to the plan
                sem.add(todo.get(0));

                // Add the added courses credit hours to the semester total
                semHours += todo.get(0).getHours();

                // Remove the course after adding to plan
                todo.remove(0);

                // Shift up the remaining courses
                for (int i = 0; i < todo.size(); i++) {
                    todo.set(i, todo.get(i+1));
                }
                } else {
                    break;
                }
            }
        }

        // Beginning text file creation

        // Create string for file name
        String fileName = student.getUsername() + "Plan.txt";

        // Write ArrayList contents to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < plan.size(); i++) {
                writer.write("Semester " + (i+1) + ":\n");
                writer.write("__________________\n");
                for (int j = 0; j < plan.get(i).size(); j++) {
                    writer.write(plan.get(i).get(i).toString() +"\n");
                }
                writer.newLine(); // Add a newline after each item
            }
        } catch (IOException e) {

        }
    }

    public double currentGPA() {
        return 0.0;
    }
}
