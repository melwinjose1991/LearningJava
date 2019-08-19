package melwin.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {
	public static int[] findRightInterval(int[][] intervals) {
		int[][] map = new int[intervals.length][2];
		int[] start_times = new int[intervals.length];
		int[] result = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			map[i][0] = intervals[i][0];
			map[i][1] = i;
			start_times[i] = intervals[i][0];
		}
		Arrays.sort(start_times);
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});
		// System.out.println(Arrays.toString(start_times));
		// System.out.println(Arrays.toString(map));

		for (int i = 0; i < intervals.length; i++) {
			int index = Arrays.binarySearch(start_times, intervals[i][1]);
			if (index < 0 && (-index - 1) == start_times.length)
				result[i] = -1;
			else {
				if (index >= 0)
					result[i] = map[index][1];
				else
					result[i] = map[-index - 1][1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// int[] x = { 1, 3, 5 };
		// System.out.println(Arrays.binarySearch(x, 6));

		int[][] intervals = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		System.out.println(Arrays.toString(findRightInterval(intervals)));
		
		intervals = new int[][]{ { 1, 4 }, { 2, 3 }, { 3, 4 } };
		System.out.println(Arrays.toString(findRightInterval(intervals)));

	}

}
