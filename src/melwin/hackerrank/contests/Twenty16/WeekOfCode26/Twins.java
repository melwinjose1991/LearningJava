package melwin.hackerrank.contests.Twenty16.WeekOfCode26;

import java.util.Scanner;

public class Twins {

	public static boolean isPrime(int n) {
		if(n==1) return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		int count = 0;
		for (int i = n; i < m - 1; i++) {
			if (i % 2 != 0 && isPrime(i) && isPrime(i + 2)) {
				count++;
			}
		}

		System.out.println(count);
	}

}
