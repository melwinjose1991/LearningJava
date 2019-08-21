package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// String | Hash Map

public class FindAllAnagramsInAString {
	public static List<Integer> findAnagrams(String s, String p) {
		HashMap<Character, int[]> map = new HashMap<Character, int[]>();
		for (char c : p.toCharArray()) {
			if (map.containsKey(c)) {
				map.get(c)[0] += 1;
			} else {
				map.put(c, new int[] { 1, 0 });
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c_i = s.charAt(i);
			if (i < p.length()) {
				if (map.containsKey(c_i))
					map.get(c_i)[1] += 1;
			} else {
				char c_j = s.charAt(i - p.length());
				if (map.containsKey(c_i)) {
					map.get(c_i)[1] += 1;
				}
				if (map.containsKey(c_j)) {
					map.get(c_j)[1] -= 1;
				}
			}
			if (isAnagram(map)) {
				result.add(i - p.length() + 1);
			}
		}
		return result;
	}

	private static boolean isAnagram(HashMap<Character, int[]> map) {
		for (char c : map.keySet()) {
			if (map.get(c)[0] != map.get(c)[1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));

		System.out.println(findAnagrams("aa", "bb"));
	}

}
