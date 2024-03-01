package Assignment6;

import java.util.Scanner;

public class CountVowels {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the string");
		String s=sc.next();
		int count=0;
		for (int i = 0; i <s.length(); i++) {
			if(isVowel(s.charAt(i)))
				count++;
		}
		System.out.println("No of vowels in the given string is "+count);
		
	}
	
	public static boolean isVowel(char c) {
		return "AEIOUaeiou".indexOf(c)!=-1;
	}

}
