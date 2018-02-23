package melwin.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 720 - Longest Word In Dictionary - BFS on Sorted Strings

public class LongestWordInDictionary {
	
	public String longestWord(String[] words) {
		Arrays.sort(words);
		Set<String> built = new HashSet<String>();
		String res = "";
		for (String w : words) {
			if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
				res = w.length() > res.length() ? w : res;
				built.add(w);
			}
		}
		return res;
	}

	public static void main(String[] args) {
	}

}
