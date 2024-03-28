package degreeswork;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {
    private Major major;
    private ArrayList<Course> completedCourses;
    private HashMap<String, Course> allCourses; // Assuming this maps course IDs to Course objects
    
    public Scheduler(Major major, Student student, ArrayList<Course> allCoursesList) {
        this.major = major;
        this.completedCourses = student.getFinishedCourseObjects(allCoursesList);
        this.allCourses = new HashMap<>();
        for (Course course : allCoursesList) {
            this.allCourses.put(course.getCourseID(), course);
        }
    }
    
    private boolean isPrerequisiteCompleted(ArrayList<ArrayList<String>> prerequisites) {
        for (ArrayList<String> orPrereqs : prerequisites) {
            boolean orComplete = false;
            for (String prereqID : orPrereqs) {
                for (Course completed : completedCourses) {
                    if (completed.getCourseID().equals(prereqID)) {
                        orComplete = true;
                        break;
                    }
                }
                if (orComplete) break; // At least one of the OR prerequisites is completed
            }
            if (!orComplete) return false; // None of the OR prerequisites are completed
        }
        return true; // All prerequisites are completed
    }
    
    public ArrayList<ArrayList<Course>> createSchedule() {
        ArrayList<ArrayList<Course>> schedule = new ArrayList<>();
        ArrayList<Course> needToTake = new ArrayList<>();
        for (ArrayList<Course> reqCourses : major.getCourses()) {
            for (Course course : reqCourses) {
                if (!completedCourses.contains(course) && isPrerequisiteCompleted(course.getPrereq())) {
                    needToTake.add(course);
                }
            }
        }
        
        // Sorting courses based on prerequisites (simplified version, consider using topological sort for complex cases)
        // Assuming courses are added in dependency order <- THIS IS NOT TRUE necessarily
        ArrayList<Course> sortedCourses = new ArrayList<>();
        while (!needToTake.isEmpty()) {
            for (int i = 0; i < needToTake.size(); i++) {
                Course course = needToTake.get(i);
                if (isPrerequisiteCompleted(course.getPrereq())) {
                    sortedCourses.add(course);
                    needToTake.remove(i);
                    i--; // Adjust index after removal
                }
            }
        }
        
        // Schedule courses without exceeding max credits per semester
        int maxCredits = 18;
        ArrayList<Course> semesterCourses = new ArrayList<>();
        int semesterCredits = 0;
        for (Course course : sortedCourses) {
            if (semesterCredits + course.getHours() <= maxCredits) {
                semesterCourses.add(course);
                semesterCredits += course.getHours();
            } else {
                schedule.add(new ArrayList<>(semesterCourses));
                semesterCourses.clear();
                semesterCourses.add(course);
                semesterCredits = course.getHours();
            }
        }
        if (!semesterCourses.isEmpty()) schedule.add(semesterCourses);
        
        return schedule;
    }
}
