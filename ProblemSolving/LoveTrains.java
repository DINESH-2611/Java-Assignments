package ProblemSolving;

import java.util.Scanner;

public class LoveTrains {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the string");
		String s = sc.next();
		if(s.length()%2==0) {
			System.out.println("Enter the string with odd length");
			return;
		}
		System.out.println(loveTrain(s));

	}

	public static String loveTrain(String s) {
		String res = "";
		int r = (s.length() / 2) + 1;
		for (int i = 0; i < s.length(); i++) {
			String s1 = "";
			if (i > s.length() / 2) {
				s1 = s.substring(i, i + 1);
				s1 = s1.repeat(r++);
			} else if (i == s.length() / 2) {
				r = 1;
				s1 = s.substring(i, i + 1);
				s1 = s1.repeat(r++);
			} else {
				s1 = s.substring(i, i + 1);
				s1 = s1.repeat(r--);
			}
			res += s1;
		}
		return res;

	}
}
