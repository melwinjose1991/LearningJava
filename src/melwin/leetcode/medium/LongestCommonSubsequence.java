package melwin.leetcode.medium;

// DP | 2D Storage

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String s1, String s2) {
		String text1 = (s1.length() <= s2.length()) ? s1 : s2;
		String text2 = (text1.equals(s1)) ? s2 : s1;
		int[][] dp = new int[text1.length()][text2.length()];
		for (int i = 0; i < text1.length(); i++) {
			for (int j = 0; j < text2.length(); j++) {
				if (text1.charAt(i) == text2.charAt(j)) {
					int diagonal = ((i - 1 >= 0 && j - 1 >= 0)) ? dp[i - 1][j - 1] : 0;
					dp[i][j] = diagonal + 1;
					// System.out.print(dp[i][j] + " ");
				} else {
					int diagonal = ((i - 1 >= 0 && j - 1 >= 0)) ? dp[i - 1][j - 1] : 0;
					int left = (j - 1 >= 0) ? dp[i][j - 1] : 0;
					int top = (i - 1 >= 0) ? dp[i - 1][j] : 0;
					dp[i][j] = Math.max(Math.max(diagonal, left), top);
					// System.out.print(dp[i][j] + " ");
				}
			}
			// System.out.println();
		}
		return dp[text1.length() - 1][text2.length() - 1];
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcde", "ace"));
		System.out.println(longestCommonSubsequence("abc", "abc"));
		System.out.println(longestCommonSubsequence("abc", "def"));

		System.out.println(longestCommonSubsequence("psnw", "vozsh"));
		System.out.println(longestCommonSubsequence("ezupkr", "ubmrapg"));
	}

}
