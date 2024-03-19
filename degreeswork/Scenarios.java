package degreeswork;
import java.util.Scanner;

public class Scenarios {
    public static void main(String[] args) {
        DegreeWorks degreeworks = new DegreeWorks();
        System.out.println("Welcome to DegreeWorks, a DegreeWorks that works!");
       // testScenario1(degreeworks);
        testScenario2(degreeworks);
    }

    public static void testScenario1(DegreeWorks degreeworks) {
        //Login
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username: ");
        String userName = input.nextLine();  // Read user input
        System.out.println("Enter password: ");
        String password = input.nextLine();  // Read user input
        if(degreeworks.login(userName, password)) {
            System.out.println("Login successful!");
            System.out.println("Here is your current progress in your degree:");
            degreeworks.viewRecord();
            System.out.println("Here is your remaining courseload:");
            degreeworks.getRequirements("Computer Science");
            System.out.println("Would you like to pick courses? Press 1 for yes.");
            if(input.nextLine().equals("1")) {
                @SuppressWarnings("unused")
                boolean next = true;
                while(next = true) {
                    System.out.println("Write the course code of the desired course.");
                    String chosenCourseID = input.nextLine();
                    degreeworks.addStudentCourse(chosenCourseID);
                    System.out.println("Enter new course? Press 1 for yes.");
                    if(input.nextLine().equals("1")) {
                        next = true;
                    } else {
                        next = false;
                        System.out.println("Goodbye!");
                    input.close();
                    System.exit(0);
                    }
                }
            } else {
                System.out.println("Goodbye!");
                input.close();
                System.exit(0);
            }
            System.out.println("Here are your Application Areas: ");
            //Method to print out all Application Areas
            

        } else {
            System.out.println("Wrong credentials!");
            input.close();
            System.exit(0);
        }
    }

    @SuppressWarnings("resource")
    public static void testScenario2(DegreeWorks degreeworks) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let's make an account.");
        System.out.println("Enter username: ");
        String userName = input.nextLine();  // Read user input
        System.out.println("Enter password: ");
        String pass = input.nextLine();  // Read user input
        System.out.println("Enter first name: ");
        String first = input.nextLine();  // Read user input
        System.out.println("Enter lasts name: ");
        String last = input.nextLine();  // Read user input
        degreeworks.advisorSignup(userName, pass, first, last);
      //  Advisor current = degreeworks.advisorLogin(userName, pass);
        Advisor current = new Advisor(userName, pass, first, last);

        System.out.println("What's your specialization?");
        current.setAdvisorSpecialization(input.nextLine());

        System.out.println("You have no students add a student");
        String student = input.nextLine();
        
        current.addAdvisee(student);
        Student advisee = current.getAdvisee(student);
        System.out.println(current.getAdviseeDetails(advisee));

        // System.out.println("Add notes");
        // String notes = input.nextLine();
        
      //  current.addAdvisingSession(current.getAdvisee(userName), notes);

       // System.out.println(current.getAdviseeDetails(advisee));

        DataWriter.SaveAllUsers();
        
        

        
    }
}
