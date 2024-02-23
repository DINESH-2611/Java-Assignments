package Assignment4;

import java.util.Scanner;

public class PrimeNumbersInRange {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the starting range");
		int start = sc.nextInt();
		System.out.println("Enter the ending range");
		int end = sc.nextInt();
		System.out.println("Prime numbers between " + start + " and " + end);
		for (int i = start; i <= end; i++) {
			if (isPrime(i))
				System.out.print(i + " ");
		}

	}

	public static boolean isPrime(int n) {
		if (n == 0 || n == 1)
			return false;

		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
