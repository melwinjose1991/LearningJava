package melwin.leetcode.medium;

import java.util.HashMap;

// HashMap | String

public class FindKLengthSubstringsWithNoRepeatingCharacters {

	public static int numKLenSubstrNoRepeats(String S, int K) {
		HashMap<Character, Integer> map = new HashMap<>();
		int num_substrings = 0, num_uniques = 0;
		for (int i = 0; i < S.length(); i++) {
			char c_i = S.charAt(i);
			if (i < K) {
				int cur_count = map.getOrDefault(c_i, 0);
				if (cur_count == 0) {
					num_uniques++;
				}
				map.put(c_i, cur_count + 1);
				if (i == K - 1 && num_uniques == K) {
					// System.out.println(S.substring(0, i + 1));
					num_substrings++;
				}
			} else {
				int cur_count = map.getOrDefault(c_i, 0);
				if (cur_count == 0) {
					num_uniques++;
				}
				map.put(c_i, cur_count + 1);

				char c_j = S.charAt(i - K);
				map.put(c_j, map.get(c_j) - 1);
				if (map.get(c_j) == 0) {
					num_uniques--;
				}

				if (num_uniques == K) {
					// System.out.println(S.substring(i - K + 1, i + 1));
					num_substrings++;
				}
			}

		}
		return num_substrings;
	}

	public static void main(String[] args) {
		System.out.println(numKLenSubstrNoRepeats("havefunonleetcode", 5));
		System.out.println(numKLenSubstrNoRepeats("home", 5));
		System.out.println(numKLenSubstrNoRepeats("abcdef", 3));
	}

}
