package melwin.leetcode.hard;

// 72. Edit Distance - O(mn)/O(m) - ~ LCS

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();

		int[] dp = new int[m + 1];
		for (int i = 1; i <= m; i++)
			dp[i] = i;

		for (int j = 1; j <= n; j++) {
			int pre = dp[0];
			dp[0] = j;
			for (int i = 1; i <= m; i++) {
				int temp = dp[i];
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i] = pre;
				else
					dp[i] = Math.min(pre + 1, Math.min(dp[i] + 1, dp[i - 1] + 1));
				pre = temp;
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
	}

}
