package Assignment4;

import java.util.Scanner;

public class SumOfEvenNumbers {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the size of the array");
		int n=sc.nextInt();
		
		int[] a=new int[n];
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter the elements in the array");
			a[i]=sc.nextInt();
		}
		
		int sum=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]%2!=0)
				continue;
			sum+=a[i];
				
		}
		
		System.out.println("Sum of even numbers "+sum);

}
}
