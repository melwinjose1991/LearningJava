package melwin.leetcode.medium;

import java.util.HashSet;

// 3. Longest Substring Without Repeating Characters

public class LongestSubstringWithoutRepeatingCharacter {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int max_len = 0;
		HashSet<Character> set = new HashSet<Character>();

		for (int i = 0, j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				set.add(c);
			} else {
				max_len = Math.max(max_len, set.size());
				while (i < j && s.charAt(i) != c) {
					set.remove(s.charAt(i));
					i++;
				}
				i++;
			}
		}

		max_len = Math.max(max_len, set.size());

		return max_len;
	}

	public static void main(String[] args) {
	}

}
