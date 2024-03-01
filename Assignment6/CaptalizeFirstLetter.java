package Assignment6;

import java.util.Scanner;

public class CaptalizeFirstLetter {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the string");
		String s=sc.nextLine(),res="";
		String[] s1=s.split(" ");
		for (int i =0; i<s1.length; i++) {
			if(i!=s1.length-1)
			    res+=captalize(s1[i])+" ";
			else
				res+=captalize(s1[i]);
		}
		
		System.out.println(s);
		System.out.println(res);
	}
	
	public static String captalize(String s) {
		
		if(s.charAt(0)>='a' && s.charAt(0)<='z') {
			String res="";
			for (int i = 0; i <s.length(); i++) {
				if(i==0)
					res+=(char)(s.charAt(i)-32);
				else
					res+=s.charAt(i);
			}
			return res;
			}else
			return s;
			
			
		}
	

}
