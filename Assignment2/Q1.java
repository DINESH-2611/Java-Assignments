package Assignment2;

import java.util.Scanner;

public class Q1 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the celcius");
		double celcius=sc.nextDouble();
		double fahrenheit=(celcius*9/5)+32;
		System.out.println("Fahrenheit:"+fahrenheit);
	}

}
