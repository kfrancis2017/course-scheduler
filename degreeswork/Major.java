package degreeswork;
import java.util.ArrayList;

public class Major {
    private String name;
    private ArrayList<ArrayList<Course>> courses;

    public Major(String name) {
        this.name = name;
        this.courses = new ArrayList<ArrayList<Course>>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(ArrayList<Course> list) {
        courses.add(list);
    }

    public ArrayList<ArrayList<Course>> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return name;
    }

}
