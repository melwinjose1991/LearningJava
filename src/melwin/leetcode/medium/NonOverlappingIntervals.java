package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

// Intervals | XXX | Sort by end time

public class NonOverlappingIntervals {
	public static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[1] - arg1[1];
			}
		});
		int prev_end = intervals[0][1];
		int non_overlapping_intervals = 1;
		for (int i = 1; i < intervals.length; i++) {
			if (prev_end <= intervals[i][0]) {
				prev_end = intervals[i][1];
				non_overlapping_intervals++;
			}
		}
		return intervals.length - non_overlapping_intervals;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		System.out.println(eraseOverlapIntervals(intervals));
	}

}
