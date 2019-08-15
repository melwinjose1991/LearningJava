package melwin.leetcode.medium;

// DP | 2D Storage

public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		if(s.length()==0)
			return s;
			
		boolean[][] dp = new boolean[s.length()][s.length()];
		StringBuilder s_sb = new StringBuilder(s);
		int start_index = 0, end_index = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (i == j) {
					dp[i][j] = true;

				} else if (j - i == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j)) ? dp[i+1][j-1] : false;
				}

				if (dp[i][j]) {
					if (j - i > end_index - start_index) {
						start_index = i;
						end_index = j;
					}
				}
			}
		}
		return s_sb.substring(start_index, end_index + 1);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("aba"));
		System.out.println(longestPalindrome("aaa"));
		System.out.println(longestPalindrome("aa"));
		System.out.println(longestPalindrome("abc"));
		
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
	}

}
