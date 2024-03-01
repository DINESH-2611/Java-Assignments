package Assignment6;

import java.util.Scanner;

public class ReverseWords {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the string");
		String s=sc.nextLine(),res="";
		String[] s1=s.split(" ");
		for (int i = s1.length-1; i >=0; i--) {
			if(i==0)
				res+=s1[i];
			else
				res+=s1[i]+" ";
		}
		System.out.println(s);
		System.out.println(res);

}
}
