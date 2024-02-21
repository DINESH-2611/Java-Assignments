package Assignment2;

import java.util.Scanner;

public class Q2 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enetr the a,b,c values of quadratic equation");
		System.out.println("Enter a value");
		double a=sc.nextDouble();
		System.out.println("Enter b value");
		double b=sc.nextDouble();
		System.out.println("Enter c value");
		double c=sc.nextDouble();
		
		double discriminant=b*b-4*a*c;
		if(discriminant>0) {
			double root1=(-b+(Math.sqrt(discriminant))/2*a);
			double root2=(-b-(Math.sqrt(discriminant))/2*a);
			System.out.println(root1);
			System.out.println(root2);
		}else if(discriminant==0) {
			double root=-b/2*a;
			System.out.println(root);
			System.out.println(root);
		}else {
			System.out.println("The equation has no real root");
		}
	}


}
