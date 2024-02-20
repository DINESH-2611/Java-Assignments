package Assignment1;

import java.util.Scanner;

public class Q3 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the Highest range");
		int n=sc.nextInt();
		double random=Math.random()*100;
		int randomNo=(int)random;
		System.out.println(randomNo);
	}

}
