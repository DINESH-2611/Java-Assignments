package Assignment3;

import java.util.Scanner;

public class Factorial {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the no");
		int n=sc.nextInt();
		int fact=1;
		while(n>1) {
			fact*=n;
			n--;
		}
		System.out.println("Factorial of given number: "+fact);
	}

}
