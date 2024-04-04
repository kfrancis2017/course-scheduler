package degreeswork;
import java.util.ArrayList;

public class Major {
    private String name;
    private ArrayList<ArrayList<Course>> courses;
    private ArrayList<Course> courseList;

    public Major(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public void addCourse(Course course) {
        ArrayList<Course> addTo = new ArrayList<Course>();
        addTo.add(course);
        courses.add(addTo);
    }

    public ArrayList<ArrayList<Course>> getCourses() {
        return courses;
    }

    public ArrayList<Course> getCourseList() {
        ArrayList<Course> courseList = new ArrayList<>();
        for (ArrayList<Course> innerList : courses) {
            if (innerList.size() > 1) {
                courseList.addAll(innerList);
            } else {
                Course electiveCourse = new Course("Elective", "ELCV","Elective",null, null, "", false, 0);
                courseList.add(electiveCourse);
            }
        }
        return courseList;
    }

    @Override
    public String toString() {
        return name;
    }

}
