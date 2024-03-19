package degreeswork;
import java.util.ArrayList;

public class Major {
    private String name;
    private ArrayList<Course> courses;

    public Major(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return name;
    }

}
