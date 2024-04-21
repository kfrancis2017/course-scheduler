package model;

import java.util.*;

import javafx.scene.chart.PieChart.Data;

/**
 * The Scheduler class is responsible for managing and scheduling courses for a student based on their major
 * and courses completed. It determines which courses a student needs to take next.
 */
public class Scheduler {
    private Major major; // Major object for the student
    private ArrayList<Course> completedCourses; // List of courses the student has completed
    private HashMap<String, Course> allCourses; // Maps course IDs to Course objects

    /**
     * Constructs a new Scheduler instance.
     *
     * @param major The major of the student.
     * @param student The student for whom the schedule is being created.
     * @param allCoursesList A list of all available courses.
     */
    public Scheduler(Major major, Student student, ArrayList<Course> allCoursesList) {
        this.major = major;
        student.updateFinishedCourseObjects(allCoursesList);
        this.completedCourses = student.getFinishedCourseObjects(allCoursesList);
        this.allCourses = new HashMap<>();
        for (Course course : allCoursesList) {
            this.allCourses.put(course.getCourseID(), course);
        }
    }

    /**
     * Determines if all required prerequisites for a course are completed.
     *
     * @param prerequisites A list of prerequisite course ID lists (OR conditions).
     * @param completedCourses A list of courses that the student has already completed.
     * @return true if all prerequisites are met, false otherwise.
     */
    private boolean isPrerequisiteCompleted(ArrayList<ArrayList<String>> prerequisites, ArrayList<Course> completedCourses) {
        for (ArrayList<String> orPrereqs : prerequisites) {
            boolean orComplete = false;
            for (String prereqID : orPrereqs) {
                for (Course completed : completedCourses) {
                    if (completed.getCourseID().equals(prereqID)) {
                        orComplete = true;
                        break;
                    }
                }
                if (orComplete)
                    break;
            }
            if (!orComplete)
                return false;
        }
        return true;
    }

    /**
     * Retrieves a list of courses that need to be taken, considering unmet prerequisites.
     *
     * @param requiredCourses A list of required courses.
     * @param completedCourses A list of courses the student has completed.
     * @return A list of courses still needed to meet prerequisites and graduation requirements.
     */
    public ArrayList<Course> getPre_ReqCourses(ArrayList<Course> requiredCourses, ArrayList<Course> completedCourses) {
        ArrayList<Course> needToTake = new ArrayList<>();
        for (Course course : requiredCourses) {
            if (!completedCourses.contains(course)) {
                if (isPrerequisiteCompleted(course.getPrereqClean(), completedCourses)) {
                    needToTake.add(course);
                } else {
                    needToTake.add(course);
                    for (ArrayList<String> prereqList : course.getPrereqClean()) {
                        if (prereqList.size() == 1) {
                            String prereq = prereqList.get(0);
                            int index = prereq.indexOf('\t');
                            if (index != -1) {
                                prereq = prereq.substring(0, index);
                            }
                            if (!completedCourses.contains(allCourses.get(prereq))
                                    && !needToTake.contains(allCourses.get(prereq))) {
                                needToTake.add(allCourses.get(prereq));
                            }
                        } else {
                            boolean anyPrereqCompleted = false;
                            for (String prereq : prereqList) {
                                if (completedCourses.contains(allCourses.get(prereq))) {
                                    anyPrereqCompleted = true;
                                    break;
                                }
                            }
                            if (!anyPrereqCompleted && !needToTake.contains(allCourses.get(prereqList.get(0)))) {
                                needToTake.add(allCourses.get(prereqList.get(0)));
                            }
                        }
                    }
                }
            }
        }
        return needToTake;
    }

    /**
     * Creates a complete course schedule for the student.
     *
     * @return An ArrayList containing ArrayLists of Courses, which represents different semesters or terms.
     */
    public ArrayList<ArrayList<Course>> createSchedule() {
        ArrayList<Course> requiredCourses = new ArrayList<>();
        for (ArrayList<Course> majorCourses : major.getCourses()) {
            requiredCourses.addAll(getPre_ReqCourses(majorCourses, completedCourses));
        }
        requiredCourses = new ArrayList<>(new LinkedHashSet<>(requiredCourses));

        CourseDAG courseDAG = new CourseDAG();
        for (Course course : requiredCourses) {
            courseDAG.addNode(course);
        }

        for (Course course : requiredCourses) {
            for (ArrayList<String> prereqList : course.getPrereqClean()) {
                Course prereqCourse = allCourses.get(prereqList.get(0));
                if (prereqCourse != null) {
                    courseDAG.addAncestor(prereqCourse, course);
                }
            }
        }
        List<List<Course>> sortedCourseLists = courseDAG.sortByChildrenAndAncestors();
        return convertListToListOfArrayLists(sortedCourseLists);
    }

        /**
     * Creates a course schedule for the student FAST FORWARD ONE SEMESTER.
     *
     * @return An ArrayList containing ArrayLists of Courses, which represents different semesters or terms.
     */
    public ArrayList<ArrayList<Course>> createNextSchedule(Student student) {
        ArrayList<Course> requiredCourses = new ArrayList<>();
        DataLoader.getAllCourses();
        CourseList courses = CourseList.getInstance();
        student.updateBothObjects(courses.getCourses());
        this.completedCourses = student.getBothCourseObjects(courses.getCourses());
        for (ArrayList<Course> majorCourses : major.getCourses()) {
            requiredCourses.addAll(getPre_ReqCourses(majorCourses, completedCourses));
        }
        requiredCourses = new ArrayList<>(new LinkedHashSet<>(requiredCourses));

        CourseDAG courseDAG = new CourseDAG();
        for (Course course : requiredCourses) {
            courseDAG.addNode(course);
        }

        for (Course course : requiredCourses) {
            for (ArrayList<String> prereqList : course.getPrereqClean()) {
                Course prereqCourse = allCourses.get(prereqList.get(0));
                if (prereqCourse != null) {
                    courseDAG.addAncestor(prereqCourse, course);
                }
            }
        }
        List<List<Course>> sortedCourseLists = courseDAG.sortByChildrenAndAncestors();
        return convertListToListOfArrayLists(sortedCourseLists);
    }


    /**
     * Converts a List of Lists of Courses into an ArrayList of ArrayLists of Courses.
     *
     * @param list A List of Lists containing Courses.
     * @return An ArrayList of ArrayLists containing the same Courses as the input list.
     */
    public ArrayList<ArrayList<Course>> convertListToListOfArrayLists(List<List<Course>> list) {
        ArrayList<ArrayList<Course>> result = new ArrayList<>();
        for (List<Course> innerList : list) {
            result.add(new ArrayList<>(innerList));
        }
        return result;
    }
}
