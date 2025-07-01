package day0.ex01;

import java.util.Scanner;

public class Program {
	public static void main(String[] argv) {
		Scanner input = new Scanner(System.in);
		if (!input.hasNextInt())
			exitError();
		int num = input.nextInt();
		input.close();

		if (num < 2 || num > Integer.MAX_VALUE)
			exitError();

		int steps = 0;
		boolean result = true;

		int sqrt = 0;
		for (int i = 1; i * i <= num; i++)
			sqrt = i;

		for (int divider = 2; divider <= sqrt; divider++) {
			steps++;
			if (num % divider == 0)	{
				result = false;
				break;
			}
		}

		System.out.printf("%b %d\n", result, steps);
	}

	private static void exitError() {
		System.err.println("IllegalArgument");
		System.exit(-1);
	}
}
