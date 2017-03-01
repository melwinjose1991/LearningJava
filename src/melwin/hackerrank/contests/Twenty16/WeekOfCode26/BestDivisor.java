package melwin.hackerrank.contests.Twenty16.WeekOfCode26;

import java.util.Scanner;

public class BestDivisor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int max_sum = 0, best = -1;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				String divisor_string = "" + i;
				int sum = 0;
				for (int j = 0; j < divisor_string.length(); j++)
					sum += (divisor_string.charAt(j) - '0');
				if (sum > max_sum) {
					max_sum = sum;
					best = i;
				}
			}
		}
		System.out.println(best);
	}

}
