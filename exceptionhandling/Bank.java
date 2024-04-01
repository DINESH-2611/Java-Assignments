package exceptionhandling;

import java.util.Scanner;

public class Bank {
    private double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String msg){
        super(msg);
    }
}
class Withdraw{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Bank bank=new Bank(2000);
        System.out.println("Enter the amount to withdraw");
        double amount=scanner.nextDouble();
        if(amount> bank.getBalance()){
           try {
               throw new InsufficientBalanceException("Indufficient balance");
           }catch (InsufficientBalanceException e){
               e.printStackTrace();
//               System.out.println(e);
               System.out.println(e.getMessage());
           }
        }
    }
}
