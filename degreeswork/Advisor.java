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

    public void addAdvisingSession(User student) {
        //ok
    }

    public void setAdviseeList(ArrayList<String> advisees) {
        this.adviseeList = new ArrayList<>();
    }

    public void setAdvisorSpecialization(String string) {
        this.advisorSpecialization = string;
    }
}
