package day0.ex03;

import java.util.Scanner;

public class Program {
	private static int weekNum = 1;
	private static String weeklyGrades = "";
	public static final int MAX_WEEKS = 18;
	private static Scanner scanner;

	public static void main(String[] argv) {
		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			if (weekNum > MAX_WEEKS)
				calculateAndExit();
			if (!scanner.hasNextInt()) {
				if (scanner.next().equals("Week"))
					parseWeek();
				else
					exitError();
			}			
			parseGrades();
		}
		scanner.close();
	}

	private static void calculateAndExit() {
		Scanner gradeScanner = new Scanner(weeklyGrades);

		int weeklyGrade;
		int i = 1;
		while (gradeScanner.hasNextInt()) {
			weeklyGrade = gradeScanner.nextInt();
			System.out.printf("Week %d: ", i++);
			for (int j = 0; j < weeklyGrade; j++)
				System.out.print("=");
			System.out.print(">\n");
		}
		gradeScanner.close();
		if (scanner != null)
			scanner.close();
		System.exit(0);
	}

	private static void parseWeek() {
		int tmp = scanner.nextInt();
		if (tmp == 42)
			calculateAndExit();
		if (tmp != weekNum)
			exitError();
	}

	private static void parseGrades() {
		int lowestGrade = 9;
		int currentGrade;
		for (int i = 0; i < 5; i++) {
			if (!scanner.hasNextInt())
				exitError();
			currentGrade = scanner.nextInt();
			if (currentGrade == 42)
				calculateAndExit();
			if (currentGrade < 1 || currentGrade > 9)
				exitError();
			lowestGrade = currentGrade < lowestGrade ? currentGrade : lowestGrade;
		}
		weeklyGrades += lowestGrade + " ";
		weekNum++;
	}

	private static void exitError() {
		System.err.println("IllegalArgument");
		System.exit(-1);
	}
}
