package day0.ex00;

public class Program {
	public static void main(String[] argv) {
		int sum = 0;
		int num = 479598;
		// int num = 1_1_1_1_1_1;

		sum += num % 10;
		num = num / 10;

		sum += num % 10;
		num = num / 10;

		sum += num % 10;
		num = num / 10;

		sum += num % 10;
		num = num / 10;

		sum += num % 10;
		num = num / 10;

		sum += num % 10;
		num = num / 10;

		System.out.println(sum);
	}
}