package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Strings | Hash Set

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> set = new HashSet<>(wordList);
		if (!set.contains(endWord))
			return 0;
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		visited.add(beginWord);
		int lvl = 2;
		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				String popped = q.poll();
				for (int j = 0; j < popped.length(); j++) {
					for (int k = 0; k < 26; k++) {
						String new_s = popped.substring(0, j) + Character.toString((char) ('a' + k))
								+ popped.substring(j + 1, popped.length());
						if (set.contains(new_s) && !visited.contains(new_s)) {
							// System.out.println(new_s);
							q.add(new_s);
							visited.add(new_s);
						}
						if (new_s.equals(endWord))
							return lvl;
					}
				}
			}
			lvl++;
		}
		return 0;
	}

	public static void main(String[] args) {
		List<String> word_list = new ArrayList<String>();
		word_list.add("hot");
		word_list.add("dot");
		word_list.add("dog");
		word_list.add("lot");
		word_list.add("log");
		word_list.add("cog");

		System.out.println(ladderLength("hit", "cog", word_list));
	}

}
