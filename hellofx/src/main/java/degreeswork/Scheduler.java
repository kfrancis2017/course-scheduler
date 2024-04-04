package degreeswork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
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

    private boolean isPrerequisiteCompleted(ArrayList<ArrayList<String>> prerequisites, ArrayList<Course> c_courses) {
        for (ArrayList<String> orPrereqs : prerequisites) {
            boolean orComplete = false;
            for (String prereqID : orPrereqs) {
                for (Course completed : c_courses) {
                    if (completed.getCourseID().equals(prereqID)) {
                        orComplete = true;
                        break;
                    }
                }
                if (orComplete)
                    break; // At least one of the OR prerequisites is completed
            }
            if (!orComplete)
                return false; // None of the OR prerequisites are completed
        }
        return true; // All prerequisites are completed
    }

    public ArrayList<Course> getPre_ReqCourses(ArrayList<Course> reqCourses, ArrayList<Course> compCourses) {

        ArrayList<Course> needToTake = new ArrayList<>();

        for (Course course : reqCourses) {

            if (!compCourses.contains(course)) {// if completed course does NOT contain the course
                if (isPrerequisiteCompleted(course.getPrereqClean(), compCourses)) {// if all prereqs are completed
                    needToTake.add(course);
                } else {// if NOT ALL prereqs are completed
                    needToTake.add(course);
                    for (ArrayList<String> prereqList : course.getPrereqClean()) {

                        if (prereqList.size() == 1) {// If there's only one prerequisite

                            String prereq = prereqList.get(0); // Get the prerequisite course ID
                            // Check if the course hasn't been completed or already checked
                            if (!compCourses.contains(allCourses.get(prereq))
                                    && !needToTake.contains(allCourses.get(prereq))) {
                                
                                //need to remove any characters after the tab, if the tab exists:
                                int index = prereq.indexOf('\t');
                                if (index != -1) {
                                    prereq = prereq.substring(0, index);
                                }
                                needToTake.add(allCourses.get(prereq)); // Add to the list of needed courses
                            }
                        } else { // If there are multiple prerequisites
                            // Check if any of the prerequisites have been completed
                            boolean anyPrereqCompleted = false;
                            for (String prereq : prereqList) {
                                if (compCourses.contains(allCourses.get(prereq))) {
                                    anyPrereqCompleted = true;
                                    break;
                                }
                            }
                            // If none of the prerequisites have been completed
                            if (!anyPrereqCompleted && !needToTake.contains(allCourses.get(prereqList.get(0)))) {
                                needToTake.add(allCourses.get(prereqList.get(0))); // Add the first one to the list of
                                                                                   // needed courses
                            }
                        }
                    }
                }

            }
        }

        return needToTake;
    }

    public ArrayList<ArrayList<Course>> createSchedule() {
        ArrayList<ArrayList<Course>> semesterPlans = new ArrayList<>();
        ArrayList<Course> requiredCourses = new ArrayList<>(); // Courses required for the major
        // Aggregate required courses, considering prerequisites
        for (ArrayList<Course> majorCourses : major.getCourses()) {
            requiredCourses.addAll(getPre_ReqCourses(majorCourses, completedCourses));
        }
        // Remove duplicates and then remove null values
        requiredCourses = new ArrayList<>(new LinkedHashSet<>(requiredCourses));
        requiredCourses.removeIf(Objects::isNull);


        ArrayList<Course> allEligibleCourses = new ArrayList<>(); // To track completed and scheduled courses
        allEligibleCourses.addAll(completedCourses);

        while (!requiredCourses.isEmpty()) {
            ArrayList<Course> semesterCourses = new ArrayList<>(); // Courses to take in the upcoming semester
            for (Iterator<Course> it = requiredCourses.iterator(); it.hasNext();) {
                Course course = it.next();
                if (isPrerequisiteCompleted(course.getPrereqClean(), allEligibleCourses)) {
                    semesterCourses.add(course);
                    it.remove(); // Remove the course as it's now scheduled
                }
            }
            allEligibleCourses.addAll(semesterCourses); // Update the list of eligible courses
            semesterPlans.add(semesterCourses); // Add the semester's courses to the plan
        }

        // TODO: Adjust scheduling algorithm to consider max number of credits per
        // semester

        return semesterPlans;
    }

}
