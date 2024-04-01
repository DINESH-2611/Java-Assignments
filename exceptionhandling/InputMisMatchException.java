package exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMisMatchException {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter ph no");
        try {
            long phNo=scanner.nextLong();
            System.out.println(phNo);
        }catch (InputMismatchException e){
            System.out.println("Type mismatch");
            System.out.println(e);
        }
    }
}
