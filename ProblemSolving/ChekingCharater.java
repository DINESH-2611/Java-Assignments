package ProblemSolving;

import java.util.Scanner;

public class ChekingCharater {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the string");
		String s=sc.next();
		System.out.println("Enter the character to check");
		char ch=sc.next().charAt(0);
		System.out.println(check(s, ch));
		
	}
	public static boolean check(String s,char ch) {
		if(s.length()==0)
			return false;
		char c=s.charAt(0);
		if(c==ch)
			return true;
		else
			return check(s.substring(1),ch);
	}

}
