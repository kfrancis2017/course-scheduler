package degreeswork;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> df1e12c52766743bf2636f66ded6808648e723c8
public class AdvisorTest{

    public static void main (String[] args){
        test("dfrancis");
    }



    private static void test(String advisorName){

<<<<<<< HEAD
        DataLoader.getAllAdvisors();

        Advisor advisor = (Advisor)UserList.getInstance().getUser(advisorName);

        if(!UserList.getInstance().searchUser(advisor.getUsername())){
=======
        Advisor advisor = (Advisor)UserList.getInstance().getUser(advisorName);

        if(!UserList.getInstance().searchUser(advisorName)){
>>>>>>> df1e12c52766743bf2636f66ded6808648e723c8
            System.out.println("Not exsting");
            return;
        }

    }
<<<<<<< HEAD
}
=======
}

>>>>>>> df1e12c52766743bf2636f66ded6808648e723c8
