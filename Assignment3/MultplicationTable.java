package Assignment3;

import java.util.Scanner;

public class MultplicationTable {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the no");
		int n=sc.nextInt();
		int i=1;
		while(i<11) {
			System.out.println(i+"*"+n+"="+n*i);
			i++;
		}
	}

}
