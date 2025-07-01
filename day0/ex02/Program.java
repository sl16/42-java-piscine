package day0.ex02;

import java.util.Scanner;

public class Program {
	public static void main(String[] argv) {
		int total_sum = 0;

		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			if (!input.hasNextInt())
				exitError();
			
			int num = input.nextInt();
			if (num < 2)
				exitError();

			if (isPrimeNum(calculateSumOfDigits(num)))
				total_sum++;

			if (num == 42)
				break;
		}
		input.close();

		System.out.printf("Count of coffee requests: %d\n", total_sum);
	}

	private static int calculateSumOfDigits(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return (sum);
	}
	
	private static int calculateSquareRoot(int num) {
		int sqrt = 0;
		for (int i = 1; i * i <= num; i++)
			sqrt = i;

		return (sqrt);
	}

	private static boolean isPrimeNum(int num) {
		for (int divider = 2; divider <= calculateSquareRoot(num); divider++) {
			if (num % divider == 0)	{
				return (false);
			}
		}
		return (true);
	}

	private static void exitError() {
		System.err.println("IllegalArgument");
		System.exit(-1);
	}
}
