package Assignment6;

import java.util.Iterator;
import java.util.Scanner;

public class EmailValidator {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the email ");
		String s = sc.next();
		if (validateEmail(s))
			System.out.println("The given email is valid");
		else
			System.out.println("The given email is Invalid");

	}

	public static boolean validateEmail(String s) {

//		for (int i = 0; i < s.length(); i++) {
//			if(s.charAt(i)>='A' && s.charAt(i)<='Z')
//				return false;
//		}
//		for (int i = 0; i < s.length(); i++) {
//			if(s.charAt(i)=='.' && s.charAt(i+1)=='.')
//				return false;
//		}
//		System.out.println(37);
	String[] s3=s.split("@");
	if(s3.length!=2)
		return false;
	String s1=s3[0];
	if(s1.isEmpty() || s1.charAt(0)=='.' || s1.charAt(s1.length()-1)=='.')
		return false;
	
	for (int i = 0; i < s1.length()-1; i++) {
		if(i<s.length()-1 && s1.charAt(i)=='.' && s.charAt(i+1)=='.')
			return false;
		if(!(Character.isDigit(s.charAt(i)) || Character.isLetter(s1.charAt(i)) ||s.charAt(i)=='.' ))
			return false;
			
	}
	String s2=s3[1];
	if(s2.charAt(0)=='.' || s2.charAt(s2.length()-1)=='.')
		return false;
	int count=0;
	for(int i=0;i<s2.length();i++) {
		if(i<s2.length()-1 && s2.charAt(i)=='.' && s2.charAt(i+1)=='.')
			return false;
		if(s2.charAt(i)=='.')
			count++;
		if(!(Character.isLowerCase(s2.charAt(i) )|| s2.charAt(i)=='.'))
			return false;
	}
	if(!(count==1 || count==2))
		return false;

	
	return true;
	}

}
