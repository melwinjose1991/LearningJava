package melwin.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// String | HashMap

public class MostCommonWord {
	public static String mostCommonWord(String paragraph, String[] banned) {
		Set<String> banned_set = new HashSet<>();
		HashMap<String, Integer> word_count = new HashMap<>();
		for (String s : banned) {
			banned_set.add(s);
		}
		String[] words = paragraph.split("\\W+");
		String result = "";
		int max_count = Integer.MIN_VALUE;
		for (String w : words) {
			w = w.replaceAll("[^a-zA-Z ]", "").toLowerCase();
			if (!banned_set.contains(w)) {
				word_count.put(w, word_count.getOrDefault(w, 0) + 1);
				int count = word_count.get(w);
				if (count > max_count) {
					result = w;
					max_count = count;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
	}

}
