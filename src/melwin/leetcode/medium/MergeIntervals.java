package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Intervals | XXX | Sort by start time

public class MergeIntervals {
	public static int[][] merge(int[][] intervals) {
		if (intervals.length == 0)
			return intervals;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});
		int[] prev_interval = intervals[0];
		List<int[]> result = new ArrayList<int[]>();
		for (int i = 1; i < intervals.length; i++) {
			if (prev_interval[1] >= intervals[i][0]) {
				prev_interval[1] = Math.max(intervals[i][1], prev_interval[1]);
			} else {
				// System.out.println(Arrays.toString(prev_interval));
				result.add(new int[] { prev_interval[0], prev_interval[1] });
				prev_interval[0] = intervals[i][0];
				prev_interval[1] = intervals[i][1];
			}
		}
		// System.out.println(Arrays.toString(prev_interval));
		result.add(new int[] { prev_interval[0], prev_interval[1] });

		int[][] result_int = new int[result.size()][2];
		for (int i = 0; i < result.size(); i++) {
			result_int[i][0] = result.get(i)[0];
			result_int[i][1] = result.get(i)[1];
		}
		return result_int;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		Arrays.toString(merge(intervals));

		intervals = new int[][] { { 1, 4 }, { 4, 5 } };
		Arrays.toString(merge(intervals));
	}

}
