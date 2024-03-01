package Assignment6;

import java.util.Scanner;

public class ReverseCharacters {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the string");
		String s=sc.next(),res="";
		
		for (int i = s.length()-1; i>=0; i--) {
			res+=s.charAt(i);
		}
		System.out.println(s);
		System.out.println(res);
		

}
}
