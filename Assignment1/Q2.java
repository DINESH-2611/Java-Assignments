package Assignment1;

import java.util.Scanner;

public class Q2 {
	static Scanner sc=new Scanner(System.in);
	enum Day{
		SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	}
	public static void main(String[] args) {
		System.out.println("Enter the nth day of the week");
		int n=sc.nextInt();
		if(n<=0 || n>7)
			System.out.println("Enter n value between 1 and 7");
		else
		    System.out.println(Day.values()[n-1]);
	}

}
