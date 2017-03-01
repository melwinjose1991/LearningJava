package melwin.hackerrank.contests.Twenty16.NCRCodeSprint;

import java.util.Scanner;

public class CountingMistakes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int previous = 0;
		int mistakes = 0;
		for (int i = 1; i <= n; i++) {
			int current = in.nextInt();
			if (current - previous != 1)
				mistakes++;
			previous = current;
		}
		System.out.println(mistakes);
	}
}
