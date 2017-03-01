package melwin.codinginterview.F_RecursionAndDP;

import java.util.Arrays;

/*
 * Chapter 8	:	Recursion and Dynamic Programming
 * Question 8.1	:	Triple Step
 */
public class TripleStep {

	private static int[] memo;

	private static int autoPlay(int n) {
		if (n <= 0) {
			if (n == 0)
				return 1;
			return 0;
		}

		if (memo[n] != -1)
			return memo[n];

		memo[n] = autoPlay(n - 1) + autoPlay(n - 2) + autoPlay(n - 3);
		return memo[n];
	}

	public static void main(String[] args) {
		int n = 10;
		memo = new int[n + 1];
		Arrays.fill(memo, -1);

		System.out.println(autoPlay(n));
	}

}
