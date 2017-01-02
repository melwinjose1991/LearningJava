package melwin.leetcode;

import java.util.HashMap;

// ||STRING|| ||O(n)|| ||DOUBLE_POINTER||
// ||HASHMAP|| ||LEETCODE||

public class Analyzed_MinimumWindowSubstring {

	public String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		String result = "";

		// character counter for t
		HashMap<Character, Integer> t_map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (t_map.containsKey(c)) {
				t_map.put(c, t_map.get(c) + 1);
			} else {
				t_map.put(c, 1);
			}
		}

		// character counter of the character in t
		// that are also in s
		HashMap<Character, Integer> s_map = new HashMap<Character, Integer>();
		int left = 0;
		int minLen = s.length() + 1;

		int count = 0; // the total of mapped characters

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (t_map.containsKey(c)) {
				if (s_map.containsKey(c)) {
					if (s_map.get(c) < t_map.get(c)) {
						// ensures that character that has
						// more than required occurances
						// doesnot cause the count to increment
						count++;
					}
					s_map.put(c, s_map.get(c) + 1);
				} else {
					s_map.put(c, 1);
					count++;
				}
			}

			if (count == t.length()) {
				char sc = s.charAt(left);
				// 1st condition is to skip characters that are not 
				// in t
				while (!s_map.containsKey(sc) || s_map.get(sc) > t_map.get(sc)) {
					if (s_map.containsKey(sc) && s_map.get(sc) > t_map.get(sc))
						s_map.put(sc, s_map.get(sc) - 1);
					left++;
					sc = s.charAt(left);
				}

				if (i - left + 1 < minLen) {
					result = s.substring(left, i + 1);
					minLen = i - left + 1;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Analyzed_MinimumWindowSubstring x = new Analyzed_MinimumWindowSubstring();
		System.out.println(x.minWindow("ADOBECODEBANC", "ABC"));
	}

}
