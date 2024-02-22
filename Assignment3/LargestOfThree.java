package Assignment3;

import java.util.Scanner;

public class LargestOfThree {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter no1");
		int n1=sc.nextInt();
		System.out.println("Enter no2");
		int n2=sc.nextInt();
		System.out.println("Enter no3");
		int n3=sc.nextInt();
		int res=(n1>n2)?((n1>n3)?n1:n3):(n2>n3)?n2:n3;
		System.out.println("Largest of three numbers "+res);
	}

}
