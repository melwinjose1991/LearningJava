package melwin.hackerrank.contests.Twenty16.WeekOfCode26;

import java.util.Scanner;

public class ArmyGame {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		if (n % 2 != 0)
			n++;
		if (m % 2 != 0)
			m++;
		int drops = (m * n) / 4;
		System.out.print(drops);
	}

}
