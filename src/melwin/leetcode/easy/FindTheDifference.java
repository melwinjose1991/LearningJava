package melwin.leetcode.easy;

// 389 - Find The Difference

public class FindTheDifference {

	public char findTheDifference(String s, String t) {
		int n = t.length();
		char c = t.charAt(n - 1);
		for (int i = 0; i < n - 1; ++i) {
			c ^= s.charAt(i);
			c ^= t.charAt(i);
		}
		return c;
	}

	public static void main(String[] args) {
	}

}
