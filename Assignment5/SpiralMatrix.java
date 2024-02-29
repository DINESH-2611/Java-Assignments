package Assignment5;

import java.util.Scanner;

public class SpiralMatrix {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter n");
		int n=sc.nextInt();
		int[][] spiralMatrix=new int[n][n];
		int rowStart=0,rowEnd=n-1,colStart=0,colEnd=n-1;
		int spiral=1;
		while(rowStart<rowEnd) {
			for(int i=rowStart;i<=rowEnd;i++) {
				spiralMatrix[rowStart][i]=spiral++;
			}
			rowStart++;
			for(int i=rowStart;i<=colEnd;i++) {
				spiralMatrix[i][colEnd]=spiral++;
			}
			colEnd--;
			for(int i=colEnd;i>=colStart;i--) {
				spiralMatrix[rowEnd][i]=spiral++;
			}
			rowEnd--;
			for(int i=rowEnd;i>=rowStart;i--) {
				spiralMatrix[i][colStart]=spiral++;
			}
			colStart++;
		}
		
		for(int[] i:spiralMatrix ) {
			for(int j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
	}

}
