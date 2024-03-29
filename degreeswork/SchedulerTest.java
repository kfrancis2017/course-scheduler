package degreeswork;

import java.util.ArrayList;
import java.util.Arrays;

public class SchedulerTest {
    public static void main(String[] args) {
        // Create some courses with prerequisites
        Course engl101 = new Course("Critical Reading and Composition", "ENGL101", "", new ArrayList<>(), new ArrayList<>(), "", false, 3);
        Course math141 = new Course("Calculus I", "MATH141", "", new ArrayList<>(), new ArrayList<>(), "", false, 4);
        Course chem111 = new Course("General Chemistry I", "CHEM111", "", new ArrayList<>(), new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> math142Prereqs = new ArrayList<>();
        math142Prereqs.add(new ArrayList<>(Arrays.asList("MATH141"))); // Prerequisite for MATH142 is MATH141
        Course math142 = new Course("Calculus II", "MATH142", "", math142Prereqs, new ArrayList<>(), "", false, 4);

        ArrayList<ArrayList<String>> phys211Prereqs = new ArrayList<>();
        phys211Prereqs.add(new ArrayList<>(Arrays.asList("MATH141"))); // Prerequisite for PHYS211 is MATH141
        Course phys211 = new Course("Essentials of Physics I", "PHYS211", "", phys211Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch200Prereqs = new ArrayList<>();
        emch200Prereqs.add(new ArrayList<>(Arrays.asList("MATH141"))); // Prerequisite for EMCH200 is MATH141
        Course emch200 = new Course("Statics", "EMCH200", "", emch200Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch201Prereqs = new ArrayList<>();
        emch201Prereqs.add(new ArrayList<>(Arrays.asList("MATH141"))); // Prerequisite for EMCH201 is MATH141; corequisite MATH142
        emch201Prereqs.add(new ArrayList<>(Arrays.asList("MATH142"))); // Adding as prerequisite for simplification
        Course emch201 = new Course("Intro. to Applied Numerical Methods", "EMCH201", "", emch201Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> math241Prereqs = new ArrayList<>();
        math241Prereqs.add(new ArrayList<>(Arrays.asList("MATH142"))); // Prerequisite for MATH241 is MATH142
        Course math241 = new Course("Vector Calculus", "MATH241", "", math241Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch260Prereqs = new ArrayList<>();
        emch260Prereqs.add(new ArrayList<>(Arrays.asList("MATH241", "EMCH200"))); // Prerequisites for EMCH260 are MATH241 and EMCH200
        Course emch260 = new Course("Solid Mechanics", "EMCH260", "", emch260Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch290Prereqs = new ArrayList<>();
        emch290Prereqs.add(new ArrayList<>(Arrays.asList("PHYS211", "MATH142"))); // Prerequisites for EMCH290 are PHYS211 and MATH142
        Course emch290 = new Course("Thermodynamics", "EMCH290", "", emch290Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> math242Prereqs = new ArrayList<>();
        math242Prereqs.add(new ArrayList<>(Arrays.asList("MATH142"))); // Prerequisite for MATH242 is MATH142
        Course math242 = new Course("Elementary Differential Equations", "MATH242", "", math242Prereqs, new ArrayList<>(), "", false, 3);
        
        ArrayList<ArrayList<String>> elct220Prereqs = new ArrayList<>();
        elct220Prereqs.add(new ArrayList<>(Arrays.asList("MATH142"))); // Prerequisite for ELCT220 is MATH142
        Course elct220 = new Course("Electrical Engineering for Non-Majors", "ELCT220", "", elct220Prereqs, new ArrayList<>(), "", false, 3);
        
        // Semester Four Courses
        ArrayList<ArrayList<String>> emch310Prereqs = new ArrayList<>();
        emch310Prereqs.add(new ArrayList<>(Arrays.asList("MATH242", "EMCH200"))); // Prerequisites for EMCH310 are MATH242 and EMCH200
        Course emch310 = new Course("Dynamics", "EMCH310", "", emch310Prereqs, new ArrayList<>(), "", false, 3);
        
        ArrayList<ArrayList<String>> emch360Prereqs = new ArrayList<>();
        emch360Prereqs.add(new ArrayList<>(Arrays.asList("EMCH200"))); // Prerequisite for EMCH360 is EMCH200
        emch360Prereqs.add(new ArrayList<>(Arrays.asList("MATH242"))); // Adding MATH242 as prerequisite for simplification
        emch360Prereqs.add(new ArrayList<>(Arrays.asList("EMCH290"))); // And EMCH290
        Course emch360 = new Course("Fluid Mechanics", "EMCH360", "", emch360Prereqs, new ArrayList<>(), "", false, 3);
        
        // Semester Five Courses
        ArrayList<ArrayList<String>> emch361Prereqs = new ArrayList<>();
        emch361Prereqs.add(new ArrayList<>(Arrays.asList("EMCH290", "EMCH260", "EMCH201", "ELCT220"))); // Prerequisites for EMCH361
        Course emch361 = new Course("Mechanical Engineering Lab I", "EMCH361", "", emch361Prereqs, new ArrayList<>(), "", false, 3);
        
        ArrayList<ArrayList<String>> emch368Prereqs = new ArrayList<>();
        emch368Prereqs.add(new ArrayList<>(Arrays.asList( "ELCT220", "EMCH260"))); // Prerequisites for EMCH368
        Course emch368 = new Course("Mechatronics", "EMCH368", "", emch368Prereqs, new ArrayList<>(), "", false, 4);

        // Semester Six Courses
        ArrayList<ArrayList<String>> emch332Prereqs = new ArrayList<>();
        emch332Prereqs.add(new ArrayList<>(Arrays.asList("EMCH310"))); // Prerequisite for EMCH332 is EMCH310
        Course emch332 = new Course("Kinematics", "EMCH332", "", emch332Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch354Prereqs = new ArrayList<>();
        emch354Prereqs.add(new ArrayList<>(Arrays.asList("EMCH360"))); // Prerequisite for EMCH354 is EMCH360
        Course emch354 = new Course("Heat Transfer", "EMCH354", "", emch354Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch362Prereqs = new ArrayList<>();
        emch362Prereqs.add(new ArrayList<>(Arrays.asList("EMCH361"))); // Prerequisite for EMCH362 is EMCH361
        Course emch362 = new Course("Mechanical Engineering Lab II", "EMCH362", "", emch362Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch367Prereqs = new ArrayList<>();
        emch367Prereqs.add(new ArrayList<>(Arrays.asList("EMCH368", "EMCH310"))); // Prerequisites for EMCH367 are EMCH368 and EMCH310
        Course emch367 = new Course("Controls", "EMCH367", "", emch367Prereqs, new ArrayList<>(), "", false, 3);

        // Semester Seven Courses
        ArrayList<ArrayList<String>> emch327Prereqs = new ArrayList<>();
        emch327Prereqs.add(new ArrayList<>(Arrays.asList("EMCH260"))); // Prerequisite for EMCH327 is EMCH260
        Course emch327 = new Course("Machine Design", "EMCH327", "", emch327Prereqs, new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch427Prereqs = new ArrayList<>();
        emch427Prereqs.add(new ArrayList<>(Arrays.asList("EMCH332", "EMCH354", "EMCH362"))); // Prerequisites for EMCH427 include EMCH332, EMCH354, and EMCH362
        Course emch427 = new Course("Design I", "EMCH427", "", emch427Prereqs, new ArrayList<>(), "", false, 3);

        // Semester Eight Courses
        ArrayList<ArrayList<String>> emch428Prereqs = new ArrayList<>();
        emch428Prereqs.add(new ArrayList<>(Arrays.asList("EMCH427"))); // Prerequisite for EMCH428 is EMCH427
        Course emch428 = new Course("Design II", "EMCH428", "", emch428Prereqs, new ArrayList<>(), "", false, 3);

        // EMCH 371 - Materials
        ArrayList<ArrayList<String>> emch371Prereqs = new ArrayList<>();
        emch371Prereqs.add(new ArrayList<>(Arrays.asList("EMCH260"))); // Prerequisite for EMCH371 is EMCH260
        Course emch371 = new Course("Materials", "EMCH371", "", emch371Prereqs, new ArrayList<>(), "", false, 3);

        // EMCH 377 - Manufacturing
        ArrayList<ArrayList<String>> emch377Prereqs = new ArrayList<>();
        emch377Prereqs.add(new ArrayList<>(Arrays.asList("EMCH371"))); // Prerequisite for EMCH377 is EMCH371
        Course emch377 = new Course("Manufacturing", "EMCH377", "", emch377Prereqs, new ArrayList<>(), "", false, 3);

        Course emch380 = new Course("Project Management", "EMCH380", "", new ArrayList<>(), new ArrayList<>(), "", false, 3);

        ArrayList<ArrayList<String>> emch101Prereqs = new ArrayList<>(); // Assuming no prerequisites for this introductory course
        Course emch101 = new Course(
            "Intro. to Mechanical Engineering", // Title
            "EMCH101", // CourseID
            "An introductory course covering the basics of mechanical engineering, including principles, career paths, and academic expectations.", // Description
            emch101Prereqs, // Prerequisites
            new ArrayList<>(), // Corequisites
            "", // Area of Study Requirement, if any
            false, // Holds, assuming no holds
            3 // Credit hours
        );

        // First, ensure the major is initialized
        Major mechE = new Major("Mechanical Engineering");

        // Now, add each course to the Mechanical Engineering major
        mechE.addCourse(engl101);
        mechE.addCourse(emch101);
        mechE.addCourse(math141);
        mechE.addCourse(chem111);
        mechE.addCourse(math142);
        mechE.addCourse(phys211);
        mechE.addCourse(emch200);
        mechE.addCourse(emch201);
        mechE.addCourse(math241);
        mechE.addCourse(emch260);
        mechE.addCourse(emch290);
        mechE.addCourse(math242);
        mechE.addCourse(elct220);
        mechE.addCourse(emch310);
        mechE.addCourse(emch360);
        mechE.addCourse(emch361);
        mechE.addCourse(emch368);
        mechE.addCourse(emch332);
        mechE.addCourse(emch354);
        mechE.addCourse(emch362);
        mechE.addCourse(emch367);
        mechE.addCourse(emch327);
        mechE.addCourse(emch427);
        mechE.addCourse(emch428);
        mechE.addCourse(emch371);
        mechE.addCourse(emch377);
        mechE.addCourse(emch380);

        // Initialize the allCourses list and add all courses to it
        ArrayList<Course> allCourses = new ArrayList<>();

        allCourses.addAll(Arrays.asList(
            engl101, emch101, math141, chem111, math142, phys211, emch200, emch201,
            math241, emch260, emch290, math242, elct220, emch310, emch360,
            emch361, emch368, emch332, emch354, emch362, emch367, emch327,
            emch427, emch428, emch371, emch377, emch380
        ));


        // Create a list of completed courses (simulate student records)
        ArrayList<Course> completedCourses = new ArrayList<>();
        completedCourses.add(emch101); // And EMCH 101 for an intro course


        ArrayList<String> completedCourseIDs = new ArrayList<>();
        for (Course course : completedCourses) {
            completedCourseIDs.add(course.getCourseID());
        }
        
        // Create student and set their major
        Student student = new Student("username", "password", "First", "Last");
        student.setMajor(mechE);
        
        // Since setFinishedCourses expects an ArrayList<ArrayList<String>>,
        // we need to wrap our list of course IDs in another ArrayList
        ArrayList<ArrayList<String>> finishedCourses = new ArrayList<>();
        finishedCourses.add(completedCourseIDs); // Add the list of completed course IDs as a single entry
        
        // Set the finished courses for the student
        student.setFinishedCourses(finishedCourses);

       // Create the scheduler with the Student object
       Scheduler scheduler = new Scheduler(mechE, student, allCourses);

       // Generate and print the schedule
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
