package degreeswork;
import java.util.ArrayList;

public class Major {
    private String name;
    private String id;
    private ArrayList<Course> courses;

    public Major(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
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
