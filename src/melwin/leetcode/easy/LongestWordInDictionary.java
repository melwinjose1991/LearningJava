package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// String | BFS

public class LongestWordInDictionary {
	public static String longestWord(String[] words) {
		Set<String> words_set = new HashSet<>(Arrays.asList(words));
		List<String> list = new ArrayList<String>();
		String longest_word = null;
		for (String word : words) {
			if (word.length() == 1) {
				list.add(word);
				if (longest_word == null)
					longest_word = word;
				// System.out.println("Adding " + word);
			}
		}
		Collections.sort(list);
		Queue<String> q = new LinkedList<String>(list);
		while (!q.isEmpty()) {
			int len = q.size();
			longest_word = q.peek();
			for (int i = 0; i < len; i++) {
				String s = q.remove();
				// System.out.println("Popped " + s);
				for (int j = 0; j < 26; j++) {
					if (words_set.contains(s + (char) ('a' + j))) {
						q.add(s + (char) ('a' + j));
					}
				}
			}
		}
		return longest_word;
	}

	public static void main(String[] args) {
		String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		System.out.println(longestWord(words));
	}

}
