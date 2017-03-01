package melwin.hackerrank.contests.Twenty17.UniversityCodeSprint_Feb;

import java.util.Scanner;

public class BreakingTheRecords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int min_score = 0, max_score = 0, min_breaks = 0, max_breaks = 0;
		int[] score = new int[n];
		for (int score_i = 0; score_i < n; score_i++) {
			score[score_i] = in.nextInt();
			if (score_i != 0) {
				if (score[score_i] > max_score) {
					max_score = score[score_i];
					max_breaks++;
				}
				if (score[score_i] < min_score) {
					min_score = score[score_i];
					min_breaks++;
				}
			} else {
				min_score = max_score = score[score_i];
			}
		}
		System.out.println(max_breaks+" "+min_breaks);
	}
}
