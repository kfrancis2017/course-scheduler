package stubs;

public class Admin extends User {
    private String officeLocation;

    public Admin() {
        
    }

    public void createUser(User userInfo) {
        
    }

    public boolean changeUserType(String username, String newType) {
        return false;
    }

    public boolean manageCourse(String courseID, String action) {
        return false;
    }

    public User getUserInfo(String username) {
        return null;
    }

    public boolean manageUser(User user, String action) {
        return false;
    }

    public void assignAdvisor(String advisorUsername, String studentUsername) {
        
    }
}
