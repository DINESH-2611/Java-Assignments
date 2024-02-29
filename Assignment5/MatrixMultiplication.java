package Assignment5;

import java.util.Arrays;

public class MatrixMultiplication {
	public static void main(String[] args) {
		int[][] a= {{1,2,3},{4,5,6}};
		int[][] b= {{1,2},{3,4}};
		int[][] res=new int[2][2];
		if(a[0].length==b.length) {
			res=new int[a.length][b[0].length];
			int sum=0;
			for(int i=0;i<a.length;i++) {
				for (int j = 0; j < res.length; j++) {
					for (int k = 0; k <b.length; k++) {
						res[i][j]+=a[i][k]*b[k][j];
		
					}
					
				
				}
			}
			for(int[] i:res)
				System.out.println(Arrays.toString(i));
		}else
			System.out.println("We can't multiply the given two matrix");
		
	}

}
