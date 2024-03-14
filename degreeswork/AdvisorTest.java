package degreeswork;

import java.util.ArrayList;

public class AdvisorTest{

    public static void main (String[] args){
        test("dfrancis");
    }



    private static void test(String advisorName){

        DataLoader.getAllAdvisors();

        Advisor advisor = (Advisor)UserList.getInstance().getUser(advisorName);

        if(!UserList.getInstance().searchUser(advisor.getUsername())){
            System.out.println("Not exsting");
            return;
        }

    }
}
