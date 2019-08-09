package melwin.leetcode.medium;

// DP | 2D Storage

public class PalindromicSubstrings {
	public static int countSubstrings(String s) {
		int n = s.length();
		int res = 0;
		boolean[][] dp = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
				if (dp[i][j])
					++res;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

}
