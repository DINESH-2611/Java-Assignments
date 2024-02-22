package Assignment3;


import java.util.Scanner;

public class NoOfDays {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the month in Uppercase Strings like 'JAN'");
		String month = sc.next();
		System.out.println("Enter the year");
		int year = sc.nextInt();
		int res=noOfDays(month, year);
		if(res!=0)
			System.out.println(res+" days");
		else
			System.out.println("invalid input");
	}

	public static int noOfDays(String month, int year) {
		switch (month) {

		case "JAN", "MAR", "MAY", "JUL", "AUG", "OCT", "DEC":
			return 31;

		case "APR", "JUN", "SEP", "NOV":
			return 30;
		
		case "FEB":{
			if(isLeap(year))
				return 29;
			else
				return 28;
			
		}
		default:return 0;
		}
	}
	
	public static boolean isLeap(int year) {
		return (year%4==0 && year%100!=0 ) || year%400==0;
	}
	

}
