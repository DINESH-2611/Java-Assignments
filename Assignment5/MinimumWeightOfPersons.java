package Assignment5;

import java.util.Scanner;

public class MinimumWeightOfPersons {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the no of persons");
		int noOfPerson=sc.nextInt();
		int[][] persons=new int[noOfPerson][];
		int[] minWeight=new int[noOfPerson];
		int min=Integer.MAX_VALUE;
		for (int i = 0; i < persons.length; i++) {
			System.out.println("Enter the no of weights for the Person"+(i+1));
			int noOfWeight=sc.nextInt();
			persons[i]=new int[noOfWeight];
			for (int j = 0; j < persons[i].length; j++) {
				System.out.println("Enter the weights of the person "+(i+1));
				persons[i][j]=sc.nextInt();
			    if(persons[i][j]<min)
			    	min=persons[i][j];
			}
			minWeight[i]=min;
			min=Integer.MAX_VALUE;
		}
		System.out.println("Enter the nth person whose minimum weight needs to be displayed ");
		int n=sc.nextInt();
		for(int i=0;i<minWeight.length;i++) {
			if(i+1==n)
				System.out.println("The minimum weight of the person "+n+" is"+minWeight[i]);
		}

	}

}
