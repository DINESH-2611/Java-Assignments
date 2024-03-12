package ProblemSolving;

import java.util.Scanner;

public class Expression3xPlus1 {
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the number");
		int n=sc.nextInt();
		print(n);
	}
	
	public static void print(int n) {
		while(n!=1) {
			if(n%2==0) {
				n/=2;
				System.out.print(n+" ");
			}else {
				n=3*n+1;
				System.out.print(n+" ");
			}
		}
	}

}
