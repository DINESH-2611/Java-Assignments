package Assignment5;

import java.util.Arrays;
import java.util.Scanner;

public class RightRotation {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		int[] a=new int[n];
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter the elements in the array");
			a[i]=sc.nextInt();
		}
		System.out.println("Enter the no of positions need to rotate ");
		int k=sc.nextInt();
		System.out.println("Before rotating "+Arrays.toString(a));
		for (int i = 0; i <k; i++) {
			int first=a[a.length-1];
			for (int j = a.length-1; j>0; j--) {
				a[j]=a[j-1];
			}a[0]=first;
		}
		System.out.println("After rotating "+Arrays.toString(a));
	}

}
