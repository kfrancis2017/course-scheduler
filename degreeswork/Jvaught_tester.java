package degreeswork;

public class Jvaught_tester {
    public static void main(String[] args) {
        DegreeWorks degreeworks = new DegreeWorks();
        System.out.println("Welcome to DegreeWorks, a DegreeWorks that works!");
        // Instead of directly reading from Scanner, pass sample data as arguments
        // You can replace these values with any other values as needed
        //testScenario1(degreeworks, "username1", "password1");
        testScenario2(degreeworks, "fake_user", "password2", "John", "Doe");
    }

    public static void testScenario1(DegreeWorks degreeworks, String userName, String password) {
        // No Scanner here, just use the passed arguments
        if (degreeworks.login(userName, password)) {
            System.out.println("Login successful!");
            System.out.println("Here is your current progress in your degree:");
            degreeworks.viewRecord();
            System.out.println("Here is your remaining courseload:");
            degreeworks.getRequirements("Computer Science");

            // Simulate the user choosing to pick courses and entering course codes
            // This array could be populated with actual course codes as needed
            String[] courseCodes = {"CS101", "CS102", "CS103"};
            for (String courseCode : courseCodes) {
                degreeworks.addStudentCourse(courseCode);
                System.out.println("Added course: " + courseCode);
            }

            System.out.println("Here are your Application Areas: ");
            // Method to print out all Application Areas
        } else {
            System.out.println("Wrong credentials!");
        }
    }

    public static void testScenario2(DegreeWorks degreeworks, String userName, String password, String firstName, String lastName) {
        // No Scanner here, just use the passed arguments
        degreeworks.signup(userName, password, firstName, lastName, true);//true mean advisor
        Advisor current = new Advisor(userName, password, firstName, lastName);

        System.out.println("Set your specialization (e.g., 'Software Engineering'):");
        String specialization = "Software Engineering"; // Replace with actual specialization
        current.setAdvisorSpecialization(specialization);

        System.out.println("Adding a student (use student's name, e.g., 'Alice Smith'):");
        String studentName = "asmith12"; // Replace with actual student name
        //create a new student here to add to the list
        degreeworks.signup("asmith12", "password", "Alice", "Smith", false);
        current.addAdvisee(studentName);
        Student advisee = current.getAdvisee(studentName);
        System.out.println(current.getAdviseeDetails(advisee));

        // Instead of reading notes from user input, set a fixed note
        String notes = "Meeting discussed progress and future courses."; // Replace with the actual note content you want
        current.addAdvisingSession(current.getAdvisee(studentName), notes);
        System.out.println(current.getAdviseeDetails(advisee));

        DataWriter.SaveAllUsers();
        

    }
}
