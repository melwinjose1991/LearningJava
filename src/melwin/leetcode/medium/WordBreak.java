package melwin.leetcode.medium;

import java.util.List;

// 139 - Word Break - O(mn) - DP to store if characters till ith
// position is somehow breakable

public class WordBreak {

	public boolean wordBreak(String s, List<String> dict) {
		boolean[] f = new boolean[s.length() + 1];

		f[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (String str : dict) {
				if (str.length() <= i) {
					if (f[i - str.length()]) {
						if (s.substring(i - str.length(), i).equals(str)) {
							f[i] = true;
							break;
						}
					}
				}
			}
		}

		return f[s.length()];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
