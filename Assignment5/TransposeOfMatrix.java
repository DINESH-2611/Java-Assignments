package Assignment5;

import java.util.Arrays;
import java.util.Scanner;

public class TransposeOfMatrix {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter no of rows");
		int row=sc.nextInt();
		System.out.println("Enter nof of columns");
		int column=sc.nextInt();
		int[][] a=new int[row][column];
		for (int i = 0; i < a.length; i++) { 
			for (int j = 0; j <column; j++) {
				
				a[i][j]=sc.nextInt();
			}
		}
		if(row==column) {
			System.out.println("Before Tranpose");
			for(int[] i:a) {
				for(int j:i) {
					System.out.print(j+" ");}
			    System.out.println();}
			for (int i = 0; i < a.length; i++) {
				for (int j = i; j < a[i].length; j++) {
					int temp=a[i][j];
					a[i][j]=a[j][i];
					a[j][i]=temp;
				}
			}
			System.out.println("After Tranpose");
			for(int[] i:a) {
				for(int j:i) {
					System.out.print(j+" ");}
			    System.out.println(); }
		}else {
			System.out.println("Before Tranpose");
			for(int[] i:a) {
				for(int j:i) {
					System.out.print(j+" ");}
			    System.out.println();}
			int[][] b=new int[column][row];
			for (int i = 0; i <row; i++) {
				for (int j = 0; j <column; j++) {
					b[j][i]=a[i][j];
				}
			}
			System.out.println("After Tranpose");
			for(int[] i:b) {
				for(int j:i) {
					System.out.print(j+" ");}
			 System.out.println();}

}
}
}
