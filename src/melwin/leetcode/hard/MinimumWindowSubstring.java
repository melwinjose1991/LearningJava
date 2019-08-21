package melwin.leetcode.hard;

import java.util.HashMap;

// Hash Map | String

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
		HashMap<Character, int[]> map = new HashMap<Character, int[]>();
		for (char c : t.toCharArray()) {
			if (map.containsKey(c)) {
				map.get(c)[0] += 1;
			} else {
				map.put(c, new int[] { 1, 0 });
			}
		}
		int matches = 0, min_len = Integer.MAX_VALUE;
		String result = "";
		for (int i = 0, j = 0; j < s.length(); j++) {
			char c_j = s.charAt(j);
			if (map.containsKey(c_j)) {
				map.get(c_j)[1] += 1;
				if (map.get(c_j)[1] <= map.get(c_j)[0]) {
					matches++;
				}
			}
			if (matches == t.length()) {
				if (j - i < min_len) {
					result = s.substring(i, j + 1);
					min_len = j - i;
				}
				char c_i = s.charAt(i);
				while (!map.containsKey(c_i) || (map.containsKey(c_i) && map.get(c_i)[1] > map.get(c_i)[0])) {
					if (map.containsKey(c_i)) {
						map.get(c_i)[1] -= 1;
					}

					i++;
					if (i < s.length()) {
						c_i = s.charAt(i);
						if (j - i < min_len) {
							result = s.substring(i, j + 1);
							min_len = j - i;
						}
					} else {
						break;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("AXBYCZ", "ABC"));
		System.out.println(minWindow("WXYZ", "ABC"));
		System.out.println(minWindow("WXABYZ", "AB"));
		System.out.println(minWindow("AB", "B"));
	}

}
