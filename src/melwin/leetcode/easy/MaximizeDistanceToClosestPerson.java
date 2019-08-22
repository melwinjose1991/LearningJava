package melwin.leetcode.easy;

// DP | Arrays | Preprocessing

public class MaximizeDistanceToClosestPerson {
	public static int maxDistToClosest(int[] seats) {
		int last_one_index = -1, max_dist = 1;
		int[] dp = new int[seats.length];
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				last_one_index = i;
			} else {
				if (last_one_index != -1) {
					dp[i] = i - last_one_index;
				} else {
					dp[i] = Integer.MAX_VALUE;
				}
			}
		}
		last_one_index = -1;
		for (int i = seats.length - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				last_one_index = i;
			} else {
				if (last_one_index != -1) {
					dp[i] = Math.min(dp[i], last_one_index - i);
				}
				max_dist = Math.max(max_dist, dp[i]);
			}
		}
		// System.out.println(Arrays.toString(dp));
		return max_dist;
	}

	public static void main(String[] args) {
		int[] seats = { 1, 0, 0, 0, 1, 0, 1 };
		System.out.println(maxDistToClosest(seats));

		seats = new int[] { 1, 0, 0, 0 };
		System.out.println(maxDistToClosest(seats));

		seats = new int[] { 1, 0 };
		System.out.println(maxDistToClosest(seats));

		seats = new int[] { 0, 1 };
		System.out.println(maxDistToClosest(seats));
	}

}
