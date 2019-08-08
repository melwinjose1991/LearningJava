package melwin.leetcode.easy;

public class IsSubsequence {
	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0)
			return true;
		if (t.length() == 0)
			return false;

		boolean[][] dp = new boolean[2][t.length()];
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < t.length(); j++) {
				if (s.charAt(i) == t.charAt(j)) {
					dp[1][j] = (i > 0 && j > 0) ? dp[0][j - 1] : true;
				} else {
					dp[1][j] = (j > 0) ? dp[1][j - 1] : false;
				}
			}
			for (int k = 0; k < t.length(); k++) {
				// System.out.print(dp[1][k]+" ");
				dp[0][k] = dp[1][k];
				dp[1][k] = false;
			}
			// System.out.println();
		}
		return dp[0][t.length() - 1];
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "axbxc"));
		System.out.println(isSubsequence("ayc", "axbxc"));
	}

}
