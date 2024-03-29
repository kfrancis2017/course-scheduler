package degreeswork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
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

    private boolean isPrerequisiteCompleted(ArrayList<ArrayList<String>> prerequisites, ArrayList <Course> c_courses) {
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

            if (!compCourses.contains(course)) {//if completed course does NOT contain the course
                if(isPrerequisiteCompleted(course.getPrereq(), compCourses)){//if all prereqs are completed
                    needToTake.add(course);
                }else{//if NOT ALL prereqs are completed
                    needToTake.add(course);
                    for (ArrayList<String> prereqList : course.getPrereq()) {
                        
                        if (prereqList.size() == 1) {// If there's only one prerequisite

                            String prereq = prereqList.get(0); // Get the prerequisite course ID
                            // Check if the course hasn't been completed or already checked
                            if (!compCourses.contains(allCourses.get(prereq)) && !needToTake.contains(allCourses.get(prereq))) {
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
                                needToTake.add(allCourses.get(prereqList.get(0))); // Add the first one to the list of needed courses
                            }
                        }
                    }
                }
                
            }
        }

        return needToTake;
    }
    public ArrayList<ArrayList<Course>> createSchedule() {
        
        ArrayList<ArrayList<Course>> schedule = new ArrayList<>();
        ArrayList<Course> needToTake = new ArrayList<>();
        for (ArrayList<Course> reqCourses : major.getCourses()) {
            needToTake.addAll(getPre_ReqCourses(reqCourses, completedCourses)); // getCompletedCourses(reqCourses) = getCompletedCourses(reqCourses, completedCourses);
        }
        //delete duplicates in needToTake
        needToTake = new ArrayList<>(new LinkedHashSet<>(needToTake));

        
        // Sorting courses based on prerequisites (simplified version, consider using topological sort for complex cases)
        // Assuming courses are added in dependency order <- THIS IS NOT TRUE necessarily
        ArrayList<Course> sortedCourses = new ArrayList<>();
        //need to create a combined list of sorted course and completed cuorses
        ArrayList<Course> combinedList = new ArrayList<>();
        ArrayList<ArrayList<Course>> infty_creditList = new ArrayList<>();

        combinedList.addAll(completedCourses);
        while (!needToTake.isEmpty()) {
            ArrayList<Course> nsCourses = new ArrayList<>();
            for (int i = 0; i < needToTake.size(); i++) {
                Course course = needToTake.get(i);
                if (isPrerequisiteCompleted(course.getPrereq(), combinedList)) {
                    sortedCourses.add(course);
                    nsCourses.add(course);
                    needToTake.remove(i);
                    i--; // Adjust index after removal
                }
            }
            combinedList.addAll(nsCourses);
            infty_creditList.add(nsCourses);
        }
        
        // Schedule courses without exceeding max credits per semester
        // int maxCredits = 18;
        // ArrayList<Course> semesterCourses = new ArrayList<>();
        // int semesterCredits = 0;

        // //need for loopto change to lovcation based(susing i)

        // for (int i = 0; i < infty_creditList.size(); i++) {
        //     ArrayList<Course> courses = infty_creditList.get(i);
        //     //check if all courses in the semester are less than max credits
        //     //if so, continue as normal and add credits to schedule in order.
        //     //else we need to go into special condition where we look at next semester and
        //     // current one and see which class we can move without causing a pre-req issue. 
        //     // if (semesterCredits + courses.stream().mapToInt(c -> c.getHours()).sum() <= maxCredits) {
        //         for(Course course : courses) {
        //             if (semesterCredits + course.getHours() <= maxCredits) {
        //                 semesterCourses.add(course);
        //                 semesterCredits += course.getHours();
        //             } else {
        //                 schedule.add(new ArrayList<>(semesterCourses));
        //                 semesterCourses.clear();
        //                 semesterCourses.add(course);
        //                 semesterCredits = course.getHours();
        //             }
        //         }
        //     // }else{//now we need to "simulate" moving a class to the next semester and how it affects pre-req.
        //     //     //make "finixhed courses" all the prior semester courses(i-1,2,3...n)
        //     //     ArrayList<Course> coursesToMove = new ArrayList<>();
        //     //     ArrayList<Course> tempfinishedCourses = new ArrayList<>();
        //     //     for(int j = 0; j < i; j++) {
        //     //         tempfinishedCourses.addAll(infty_creditList.get(j));
        //     //     }
        //     //     ArrayList<Course> pre_req_from_next_sem = getPre_ReqCourses(infty_creditList.get(i), tempfinishedCourses); 

        //     //     //if any of the pre-reqs from pre_req_next_sem do not atch a certain class in courses, move it to next semester.
        //     //     //repeat until credit hour is met.
        //     //     while(semesterCredits < maxCredits) {
        //     //         for(Course course : courses) {
        //     //             if(!pre_req_from_next_sem.contains(course)) {
        //     //                 coursesToMove.add(course);
        //     //                 courses.remove(course);
        //     //             }
        //     //         }
        //     //         pre_req_from_next_sem = getPre_ReqCourses(semesterCourses, tempfinishedCourses);
        //     //         for(Course course : coursesToMove) {
        //     //             semesterCourses.add(course);
        //     //             semesterCredits += course.getHours();
        //     //         }
        //     //         coursesToMove.clear();
        //     //     }
        //     // }



        // }
        // if (!semesterCourses.isEmpty()) schedule.add(semesterCourses);
        
        return infty_creditList;
    }
}
