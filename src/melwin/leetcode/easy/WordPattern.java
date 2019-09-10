package melwin.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// String | HashMap | HashSet

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		HashMap<Character, String> mapping = new HashMap<>();
		Set<String> mapped_str = new HashSet<>();
		String[] s = str.split(" ");
		if (pattern.length() != s.length)
			return false;
		for (int i = 0; i < pattern.length() && i < s.length; i++) {
			char p = pattern.charAt(i);
			if (mapping.containsKey(p)) {
				if (mapping.get(p).equals(s[i])) {
					continue;
				} else {
					return false;
				}
			} else {
				if (mapped_str.contains(s[i]))
					return false;
				else {
					mapping.put(p, s[i]);
					mapped_str.add(s[i]);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
	}

}
