package Assignment2;

import java.util.Scanner;

public class Q5 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the time in Seconds");
		int time=sc.nextInt();
		
		int hour=time/3600;
		int remaing=time%3600;
		int min=remaing/60;
		int sec=remaing%60;
		
		String format=String.format("%02d:%02d:%02d",hour,min,sec);
		System.out.println("HH:MM:SS --> "+format);
	}

}
