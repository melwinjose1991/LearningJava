package melwin.hackerrank.contests.Twenty16.UniversityCodeSprint;

import java.util.Scanner;

public class MiniMaxSum {

	public static void main(String[] args) {
		long total = 0, min, max, n;
		Scanner in = new Scanner(System.in);
		total = min = max = n = in.nextLong();
		for (int i = 0; i < 4; i++) {
			n = in.nextInt();
			if (n > max) {
				max = n;
			}
			if (n < min) {
				min = n;
			}
			total += n;
		}
		System.out.println((total-max)+" "+(total-min));
	}

}
