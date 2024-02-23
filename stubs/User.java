package stubs;

public class User {
    
    private String username;
    private String password;
    private String lastLogin;

    public String firstname;
    public String lastname;

    public boolean updateProfile(String details) {
        return true;
    }

    public boolean changePassword() {
        return true;
    }

    public boolean checkPassword(String password) {
        return true;
    }

    public String viewProfile() {
        return null;
    }


}
