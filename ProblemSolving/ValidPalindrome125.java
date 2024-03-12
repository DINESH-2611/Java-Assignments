package ProblemSolving;

public class ValidPalindrome125 {
	public boolean isPalindrome(String s) {
		String s1 = "";
		String rev = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'
					|| s.charAt(i) >= '0' && s.charAt(i) <= '9')
				s1 += s.charAt(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(s1);
		rev = sb.reverse().toString();

		if (s1.equalsIgnoreCase(rev))
			return true;
		else
			return false;
	}


}
