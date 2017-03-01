package melwin.hackerrank.contests.Twenty17.UniversityCodeSprint_Feb;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOfTwoStacks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int x = in.nextInt();

			int score = 0;
			int[][] DP = new int[2][n + 1];
			ArrayList<Integer> A = new ArrayList<>(n);
			ArrayList<Integer> B = new ArrayList<>(m);

			for (int j = 0; j < n; j++)
				A.add(in.nextInt());

			for (int j = 0; j < m; j++)
				B.add(in.nextInt());

			for (int i = 0; i <= m; i++) {
				for (int j = 0; j <= n; j++) {
					if (i == 0 || j == 0) {
						if (i == 0 && j == 0) {
							DP[i][j] = 0;
						} else if (i == 0) {
							DP[0][j] = DP[0][j - 1] + A.get(j - 1);
							if (DP[0][j] <= x && (i + j > score)) {
								score = i + j;
							}
						} else {
							DP[1][j] = DP[0][j] + B.get(i - 1);
							if (DP[1][j] <= x && (i + j > score)) {
								score = i + j;
							}
						}
					} else {
						DP[1][j] = DP[0][j] + B.get(i - 1);
						if (DP[1][j] <= x && (i + j > score)) {
							score = i + j;
						}
					}
				}
				if (i != 0)
					for (int k = 0; k <= n; k++)
						DP[0][k] = DP[1][k];
				//printDPRow(DP[0], n + 1);
			}
			System.out.println(score);
		}
	}

	public static void printDPRow(int DP[], int m) {
		for (int i = 0; i < m; i++) {
			System.out.print(DP[i] + " ");
		}
		System.out.println();
	}
}
