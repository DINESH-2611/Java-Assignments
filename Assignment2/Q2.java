package Assignment2;

import java.util.Scanner;

public class Q2 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enetr the a,b,c values of quadratic equation");
		System.out.println("Enter a value");
		int a=sc.nextInt();
		System.out.println("Enter b value");
		int b=sc.nextInt();
		System.out.println("Enter c value");
		int c=sc.nextInt();
		
		int discriminant=b*b-4*a*c;
		if(discriminant>0) {
			int root1=(int)(-b+(Math.sqrt(discriminant)))/2*a;
			int root2=(int)(-b-(Math.sqrt(discriminant)))/2*a;
			System.out.println(root1);
			System.out.println(root2);
		}else if(discriminant==0) {
			int root=-b/2*a;
			System.out.println(root);
			System.out.println(root);
		}else {
			System.out.println("The equation has no real root");
		}
	}


}
