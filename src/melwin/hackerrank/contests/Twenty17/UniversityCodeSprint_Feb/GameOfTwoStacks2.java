package melwin.hackerrank.contests.Twenty17.UniversityCodeSprint_Feb;

import java.util.ArrayList;
import java.util.Scanner;

// O(n) solution : https://www.hackerrank.com/contests/university-codesprint-2/challenges/game-of-two-stacks/editorial
// 					1. Add everything in A till this sum <= threshold
//					2. Start adding from B
//								if sum > threshold, then start removing from A

// O(m*n) solution : timed-out : 15/30
public class GameOfTwoStacks2 {

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
				int toggle_one = i % 2;
				int toggle_two = (i + 1) % 2;
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
							DP[toggle_one][j] = DP[toggle_two][j] + B.get(i - 1);
							if (DP[toggle_one][j] <= x && (i + j > score)) {
								score = i + j;
							}
						}
					} else {
						DP[toggle_one][j] = DP[toggle_two][j] + B.get(i - 1);
						if (DP[toggle_one][j] <= x && (i + j > score)) {
							score = i + j;
						}
					}
				}
				//printDPRow(DP[toggle_one], n + 1);
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
