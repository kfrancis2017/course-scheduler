package degreeswork;
import java.util.ArrayList;

public class Major {
    private String name;
    private ArrayList<ArrayList<Course>> courses;

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

    @Override
    public String toString() {
        return name;
    }

}
