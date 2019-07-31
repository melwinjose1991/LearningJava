package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Strings | Medium

public class WordSubsets {
	public static List<String> wordSubsets(String[] A, String[] B) {
		int[] global_count = new int[26];
		List<String> res = new ArrayList<String>();
		for (String b : B) {
			int[] local_count = new int[26];
			for (char c : b.toCharArray()) {
				local_count[c - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				global_count[i] = Math.max(global_count[i], local_count[i]);
			}
		}

		for (String a : A) {
			int[] local_count = new int[26];
			for (char c : a.toCharArray()) {
				local_count[c - 'a']++;
			}
			boolean ok = true;
			for (int i = 0; i < 26; i++) {
				if (local_count[i] >= global_count[i])
					continue;
				else {
					ok = false;
					break;
				}
			}
			if (ok) {
				res.add(a);
				// System.out.println(a);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] A = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] B = { "ec", "oc", "ceo" };
		System.out.println(wordSubsets(A, B));
	}

}
