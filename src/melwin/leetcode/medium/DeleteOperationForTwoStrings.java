package melwin.leetcode.medium;

// DP | 2D Storage

public class DeleteOperationForTwoStrings {
	public static int minDistance(String word1, String word2) {
		if (word1.length() == 0 || word2.length() == 0) {
			return Math.max(word1.length(), word2.length());
		}

		int[][] dp = new int[word1.length()][word2.length()];
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					dp[i][j] = (i == 0 || j == 0) ? 1 : dp[i - 1][j - 1] + 1;
				} else {
					int left = (j - 1 < 0) ? 0 : dp[i][j - 1];
					int top = (i - 1 < 0) ? 0 : dp[i - 1][j];
					dp[i][j] = Math.max(left, top);
				}
			}
			// System.out.println(Arrays.toString(dp[i]));
		}
		return word1.length() + word2.length() - 2 * dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		System.out.println(minDistance("sea", "eat"));
	}

}
