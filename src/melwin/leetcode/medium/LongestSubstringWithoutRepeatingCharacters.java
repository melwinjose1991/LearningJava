package melwin.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// Hash Set | String

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int max_len = 0;
		for (int i = 0, j = 0; i < s.length() && j < s.length();) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				set.add(c);
				max_len = Math.max(max_len, j - i + 1);
				j++;
			} else {
				while (s.charAt(i) != c) {
					set.remove(s.charAt(i++));
				}
				i++;
				j++;
			}
		}
		return max_len;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(lengthOfLongestSubstring("aabc"));
	}

}
