package degreeswork;

public class AdvisorTest{

    public static void main (String[] args){
        test("dfrancis");
    }



    private static void test(String advisorName){

        Advisor advisor = (Advisor)UserList.getInstance().getUser(advisorName);

        if(!UserList.getInstance().searchUser(advisorName)){
            System.out.println("Not exsting");
            return;
        }

    }
}

