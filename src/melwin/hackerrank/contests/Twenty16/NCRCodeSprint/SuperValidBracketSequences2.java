package melwin.hackerrank.contests.Twenty16.NCRCodeSprint;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * ||Factorial|| ||nCr|| ||Narayana_Number|| ||MOD||
 */

public class SuperValidBracketSequences2 {

	private static int n, k;

	private static long[] factorials = new long[201];
	private static int mod = 1000000007;
	private static BigInteger MOD = BigInteger.valueOf(1000000007);

	private static void calculateFactorials() {
		long f = 1;
		for (int i = 1; i < factorials.length; i++) {
			f = (f * i) % mod;
			factorials[i] = f;
		}
	}

	private static long nCk(int n, int k) {
		if (n < k) {
			return 0;
		}

		long a = k == 0 ? 1 : BigInteger.valueOf(factorials[k]).modInverse(MOD).longValue();
		long b = (n - k == 0) ? 1 : BigInteger.valueOf(factorials[n - k]).modInverse(MOD).longValue();

		return factorials[n] * a % mod * b % mod;

	}

	private static long narayanNumber(int n, int k) {
		long a = BigInteger.valueOf(n).modInverse(MOD).longValue();
		return (nCk(n, k) % mod * nCk(n, k - 1) % mod * a % mod) % mod;
	}

	private static long func(int n, int k) {
		long sum = 0;
		for (int i = k; i <= n; i++) {
			sum = (sum + (narayanNumber(n, i))) % mod;
		}
		return sum;
	}

	public static void main(String[] args) {
		calculateFactorials();

		Scanner in = new Scanner(System.in);
		int q = Integer.parseInt(in.nextLine());

		for (int i = 1; i <= q; i++) {
			String input = in.nextLine();
			n = Integer.parseInt(input.split(" ")[0]);
			k = Integer.parseInt(input.split(" ")[1]);
			if (n % 2 != 0 || n == k) {
				// invalid no of parenthesis
				System.out.println("0");
			} else {
				if (k == 1)
					System.out.println(func(n / 2, k));
				else
					System.out.println(func(n / 2, (k + 2) / 2));
			}
		}

	}

}
