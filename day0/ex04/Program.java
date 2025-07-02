package day0.ex04;

import java.util.Scanner;

public class Program {
	private static Scanner scanner;
	private static char[] input;
	private static int[] frequency;
	private static int maxFrequency;
	private static int[] topTenFrequency;
	private static char[] topTenChars;
	
	public static void main(String[] arvg) {
		scanner = new Scanner(System.in);
		String str = scanner.next();
		scanner.close();

		if (str.length() > 999)
			exitError();

		input = str.toCharArray();
		storeInArr();
		findTopTen();

		printResult();
	}

	private static void printResult() {
		maxFrequency = topTenFrequency[0];
		int scaledStep;
		if (maxFrequency / 10 > 9)
			scaledStep = maxFrequency / 10;
		else
			scaledStep = 1;

		System.out.printf("top ten frequency length: %d\n", topTenFrequency.length);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < topTenFrequency.length; j++) {
				if (topTenFrequency[j] == 0)
					System.out.printf("  ");
				else if (topTenFrequency[j] >= maxFrequency - (i * scaledStep))
					System.out.printf("# ");
				else
					System.out.printf(" ");
			}
			System.out.printf("\n");
		}
		
		for (int i = 0; i < topTenChars.length; i++)
			System.out.printf("%c ", topTenChars[i]);
		System.out.println();
	}

	private static void findTopTen() {
		topTenFrequency = new int[10];
		topTenChars = new char[10];

		for (int i = 0; i < 10; i++) {
			int highest = 0;
			int index = -1;

			for (int j = 0; j < frequency.length; j++) {
				if (frequency[j] > highest) {
					highest = frequency[j];
					index = j;
				}
			}

			if (index != -1) {
				topTenFrequency[i] = highest;
				topTenChars[i] = (char) index;
				frequency[index] = 0;
			}
		}
	}

	private static void storeInArr() {
		frequency = new int[65536];
		for (int i = 0; i < input.length; i++) {
			frequency[input[i]]++;
		}
	}

	private static void exitError() {
		System.err.println("IllegalArgument");
		System.exit(-1);
	}
}
