package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (pattern.length() != word.length())
				continue;

			HashMap<Character, Character> map = new HashMap<>();
			boolean match = true;
			for (int i = 0; i < pattern.length(); i++) {
				if (map.containsKey(pattern.charAt(i))) {
					if (map.get(pattern.charAt(i)) != word.charAt(i)) {
						match = false;
						break;
					}
				} else {
					if (map.values().contains(word.charAt(i))) {
						match = false;
						break;
					} else {
						map.put(pattern.charAt(i), word.charAt(i));
					}
				}
			}
			if (match)
				result.add(word);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		String pattern = "abb";
		System.out.println(findAndReplacePattern(words, pattern));
	}

}
