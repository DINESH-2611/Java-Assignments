package Assignment2;

import java.util.Scanner;

public class Q4 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter weight in kilograms");
		double weight=sc.nextDouble();
		System.out.println("Enter Height in meter");
		double height=sc.nextDouble();
		
		double bmi=weight/(height*height);
		System.out.printf("%.2f",bmi);
	}

}
