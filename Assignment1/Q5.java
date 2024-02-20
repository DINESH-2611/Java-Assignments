package Assignment1;

public class Q5 {
	public static void main(String[] args) {
		int x=10,y=5,temp;
		//Using temp variable
		System.out.println(x);
		System.out.println(y);
		temp=x;
		x=y;
		y=x;
		System.out.println(x);
		System.out.println(y);
		
		//without using temp variable
		x=10;
		y=5;
		System.out.println(x);
		System.out.println(y);
		x=x+y;
		y=x-y;
		x=x-y;
		System.out.println(x);
		System.out.println(y);
		
		
	}

}
