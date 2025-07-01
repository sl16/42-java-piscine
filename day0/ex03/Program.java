package day0.ex03;

import java.util.Scanner;

public class Program {
	private static int weekNum = 1;
	private static String weeklyGrades;
	private static Scanner scanner;

	public static void main(String[] argv) {
		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			if (scanner.nextInt() == 42)
				//end and calculate
			parseWeek();
			parseGrades();
		}

	}

	private static void calculateAndExit() {
		
	}

	private static void parseWeek() {
		if (scanner.next().equals("Week")) {
			if (scanner.nextInt() == weekNum)
				weekNum++;
			else
				exitError();
		}
	}

	private static void parseGrades() {
		int lowestGrade = 9;
		int currentGrade;
		for (int i = 0; i < 5; i++) {
			if (!scanner.hasNextInt())
				exitError();
			currentGrade = scanner.nextInt();
			lowestGrade = currentGrade < lowestGrade ? currentGrade : lowestGrade;
		}
		weeklyGrades += lowestGrade + " ";
	}

	private static void exitError() {
		System.err.println("IllegalArgument");
		System.exit(-1);
	}
}
