package Assignment3;

import java.util.Scanner;

public class StudentsGrade {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter the mark");
		int mark=sc.nextInt();
		String res=grade(mark);
		System.out.println("The Grade of given Student is: "+res);
		
	}
	
	public static String grade(int mark) {
		if(mark>=90)
			return " grade";
		else if(mark>80 && mark<90)
			return "A grade";
		else if(mark>60 && mark<=80)
			return "B grade";
	    else if(mark>=40 && mark<=600)
		    return "C grade";
	    else
	    	return "No grade";
	}

}
