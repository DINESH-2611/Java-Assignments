package exceptionhandling;

public class DivideByZero {
    public static void main(String[] args) {
       try {
           System.out.println(5/0);
       }catch (ArithmeticException e){
           System.out.println(e);
       }
        System.out.println("We can't divide a number by zero");
    }
}
