package melwin.leetcode.medium;

import java.util.HashMap;

// Permutation | String

public class PermutationInString {
	public static boolean checkInclusion(String p, String s) {
		HashMap<Character, int[]> map = new HashMap<Character, int[]>();
		for (char c : p.toCharArray()) {
			if (map.containsKey(c)) {
				map.get(c)[0] += 1;
			} else {
				map.put(c, new int[] { 1, 0 });
			}
		}

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
				return true;
			}
		}
		return false;
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
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
	}

}
