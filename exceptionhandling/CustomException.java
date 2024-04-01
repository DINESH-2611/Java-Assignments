package exceptionhandling;

import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the age");
        int age=scanner.nextInt();
        if(age<18){
            try {
                throw new NotEligibleForVoteException("Not eligible for vote");
            }catch (NotEligibleForVoteException e){
                System.out.println(e);
            }
        }else{
            try {
                throw new EligibleForVoteException("Eligible for vote");
            }catch (EligibleForVoteException e){
                System.out.println(e);
            }
        }
    }
}
class EligibleForVoteException extends RuntimeException{
    public EligibleForVoteException(String msg){
        super(msg);
    }
}
class NotEligibleForVoteException extends RuntimeException{
    public NotEligibleForVoteException(String msg){
        super(msg);
    }
}
