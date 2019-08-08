package melwin.leetcode.easy;

// DP | 0-D storage

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		int max_profit = 0;
		int prev_min = Integer.MAX_VALUE;
		for (int p : prices) {
			prev_min = Math.min(prev_min, p);
			max_profit = Math.max(max_profit, p - prev_min);
		}
		return max_profit;
	}

	public static void main(String[] args) {
	}

}
