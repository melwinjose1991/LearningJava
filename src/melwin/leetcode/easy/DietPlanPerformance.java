package melwin.leetcode.easy;

// Arrays | Sliding Window

public class DietPlanPerformance {
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
		int points = 0, sum = 0;
		for (int i = 0; i < calories.length; i++) {
			sum += calories[i];
			if (i >= k) {
				sum -= calories[i - k];
			}
			if (i >= k - 1) {
				if (sum > upper)
					points++;
				if (sum < lower)
					points--;
			}
		}
		return points;
	}

	public static void main(String[] args) {
	}

}
