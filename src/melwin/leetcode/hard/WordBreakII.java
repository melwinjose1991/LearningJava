package melwin.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 140 - Word Break II - DFS + memoization

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> wordDict) {
		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}

	List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
		if (map.containsKey(s))
			return map.get(s);

		LinkedList<String> res = new LinkedList<String>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
				for (String sub : sublist)
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		map.put(s, res);
		return res;
	}

	public static void main(String[] args) {
	}

}
