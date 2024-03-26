package degreeswork;

import java.util.ArrayList;

public class MajorList {
    private static MajorList MajorList;
    private ArrayList<Major> Majors;

    public MajorList() {
        Majors = new ArrayList<Major>();
    }

    public MajorList(ArrayList<Major> Majors) {
        this.Majors = Majors;
    }

    public static MajorList getInstance() {
        if (MajorList == null)
            MajorList = new MajorList();
        return MajorList;
    }

    public boolean addMajor(Major Major) {
        if (Major == null || getMajorByName(Major.getName()) != null)
            return false;
        Majors.add(Major);
        return true;
    }
    
    public boolean modifyMajor(Major newMajor, Major oldMajor) {
        if (newMajor == oldMajor)
            return false;
        int index = Majors.indexOf(oldMajor);
        if(index != -1) {  // old Major exists
            Majors.set(index, newMajor);
            return true;
        }
        return false;
    }

    public boolean deleteMajor(Major Major) {
        return Majors.remove(Major);
    }

    public Major getMajorByName(String MajorName) {
        Major currentMajor = null;
        for (Major major : Majors) {
            if (major.getName().equals(MajorName)) {
                currentMajor = major;
                break; 
            }
        }
        return currentMajor;
    }

    public ArrayList<Major> getMajors() {
        return Majors;
    }


    public void clear() {
        Majors.clear(); // Clears the list of all majors
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Major Major : Majors) {
            sb.append(Major.getName());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String allToString() {
        StringBuilder sb = new StringBuilder();
        for (Major Major : Majors) {
            sb.append(Major.toString());
            sb.append("\n");
        }
        return sb.toString();        
    }
    

    //TODO CHECK THIS BEFORE running
    public CourseList listCoursesForMajor(String majorName, Student student) {
        Major major = getMajorByName(majorName);
        CourseList list = new CourseList();
        if (major != null) {
            System.out.println("Courses for major: " + majorName);
            for (ArrayList<Course> courseList : major.getCourses()) { // Changed from Course to ArrayList<Course>
                for (Course course : courseList) { // Additional loop to iterate over ArrayList<Course>
                    if (!student.getCurrentCourses().contains(course.getCourseID())) {
                        list.addCourse(course);
                    }
                }
            }
        } else {
            System.out.println("Major '" + majorName + "' not found.");
        }
        return list;
    }
    
    
}
