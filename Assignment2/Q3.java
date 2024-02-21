package Assignment2;

import java.util.Scanner;

public class Q3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter no1");
		int a=sc.nextInt();
		System.out.println("Enter no2");
		int b=sc.nextInt();
		
		//Bitwise AND
		int and=a&b;
		System.out.println("a&b: "+and);
		
		//Bitwise OR
		int or=a|b;
		System.out.println("a|b: "+or);
		
//		Bitwise XOR
		int xor=a^b;
		System.out.println("a^b: "+xor);
		
		//Bitwise NOT
		int not=~a;
		System.out.println("~a: "+not);
		
		//LeftShift
		int leftShift=a<<2;
		System.out.println("a<<2: "+leftShift);
		
		//RightShift
		int rightShift=a>>1;
		System.out.println("a>>2: "+rightShift);
		
		//Unsigned RightShift
		int unsignRightShift=a>>>2;
		System.out.println("a>>>2: "+unsignRightShift);
		
}

}
