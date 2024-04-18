package model;
import java.util.ArrayList;


public class Scenarios {
    public UserList userList = UserList.getInstance();
    public ArrayList<Advisor> advisorList = userList.getAdvisors();
    public ArrayList<Student> studentList = userList.getStudents();
    public Advisor advisor = advisorList.get(0);
    public Student student = studentList.get(0);
    public Student student2 = studentList.get(1);
   public Student student3 = studentList.get(2);



    public static void main(String[] args) {
        DataLoader.getAllAdvisors();
        DataLoader.getAllStudents();
        UserList userList = UserList.getInstance();
        ArrayList<Advisor> advisorList = userList.getAdvisors();
        ArrayList<Student> studentList = userList.getStudents();
        Advisor advisor = advisorList.get(0);
        Student student = studentList.get(0);
        Student student2 = studentList.get(1);
        Student student3 = studentList.get(2);

        Scenarios scenarios = new Scenarios();
        scenarios.run();
    }

    public void run() {
        System.out.println("Running scenario...");
        System.out.println("Advisor: " + advisor.getFirstName() + " " + advisor.getLastName());
        System.out.println("Advisee List: " + advisor.getAdviseeList());
        System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Adding student to advisee list...");
        advisor.addAdvisee(student);
        advisor.addAdvisee(student2);
        advisor.addAdvisee(student3);

        System.out.println("New Advisee List: " + advisor.getAdviseeList());
    }
}
