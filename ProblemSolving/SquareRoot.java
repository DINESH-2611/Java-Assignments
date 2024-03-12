package ProblemSolving;

import java.util.Scanner;

public class SquareRoot {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the number");
		int n=sc.nextInt();
		System.out.println(squareRoot(n));
	}
	
	public static int squareRoot(int n) {
		int sqrt=1;
		while(n>sqrt*sqrt) 
			sqrt++;
		if(n==sqrt*sqrt)
			return sqrt;
		return (sqrt*sqrt-n<n-(sqrt-1)*(sqrt-1))?sqrt:sqrt-1;
	}

}
