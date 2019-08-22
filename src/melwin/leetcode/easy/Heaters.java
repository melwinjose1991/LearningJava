package melwin.leetcode.easy;

import java.util.Arrays;

// Arrays | Binary Search

public class Heaters {
	public static int findRadius(int[] houses, int[] heaters) {
		int global_min = Integer.MIN_VALUE;
		for (int i = 0; i < houses.length; i++) {
			Arrays.sort(heaters);
			int local_min;
			int index = Arrays.binarySearch(heaters, houses[i]);
			// System.out.println("@ " + houses[i] + " - index:" + index);
			if (index < 0) {
				index = -index - 1;
				int left_dist = (index - 1 >= 0) ? Math.abs(houses[i] - heaters[index - 1]) : Integer.MAX_VALUE;
				int right_dist = (index <= heaters.length - 1) ? Math.abs(houses[i] - heaters[index])
						: Integer.MAX_VALUE;
				// System.out.println("\t" + left_dist + "-" + right_dist);
				local_min = Math.min(left_dist, right_dist);
			} else {
				local_min = 0;
			}
			// System.out.println("\t" + local_min);
			global_min = Math.max(global_min, local_min);
		}
		return global_min;
	}

	public static void main(String[] args) {
		int[] houses = { 1, 2, 3, 4 };
		int[] heaters = { 1, 4 };
		System.out.println(findRadius(houses, heaters));

		houses = new int[] { 1, 2, 3 };
		heaters = new int[] { 2 };
		System.out.println(findRadius(houses, heaters));
	}

}
