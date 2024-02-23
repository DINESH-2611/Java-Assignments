package Assignment4;

import java.util.Iterator;
import java.util.Scanner;

public class SecondOccurence {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the size of the array");
		int n=sc.nextInt();
		
		int[] a=new int[n];
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter the elements in the array");
			a[i]=sc.nextInt();
		}
		System.out.println("Enter the target number");
		int target=sc.nextInt();
		int res=secondoccurence(a, target);
		System.out.println("Index of the second occurence of "+target+" is "+res);
	}
	
	public static int secondoccurence(int[] a,int target) {
		
		int count=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]==target) {
				count++;
				if(count==2) {
					return i;
				}
			}
		}
		return -1;
	}

}
