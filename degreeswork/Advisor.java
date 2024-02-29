package degreeswork;

import java.util.ArrayList;

public class Advisor extends User {
    
    private ArrayList<Student> adviseeList;
    private String advisorSpecialization;

    public Advisor() {

    }

    public ArrayList<Student> getAdviseeList() {
        return this.adviseeList;
    }

    public void monitorProgress(String username) {

    }

    public void addAdvisingSession(User student) {
        //ok
    }

    public void createSechedule(String username) {
        //Should NOT be here.
    }

    public void getStudentInfo(User student) {
        //what the f does this do?
    }

    public void setAdviseeList(ArrayList<String> advisees) {
        this.adviseeList = new ArrayList<>();
    }

    public void setAdvisorSpecialization(String string) {
        this.advisorSpecialization = string;
    }
}
