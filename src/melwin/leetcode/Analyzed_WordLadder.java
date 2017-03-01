package melwin.leetcode;

import java.util.LinkedList;
import java.util.Set;

// ||WORD|| ||STRING|| ||BFS||
// ||DICTIONARY||

public class Analyzed_WordLadder {
	static class WordNode {
		String word;
		int numSteps;

		public WordNode(String word, int numSteps) {
			this.word = word;
			this.numSteps = numSteps;
		}
	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));

		wordDict.add(endWord);

		while (!queue.isEmpty()) {
			WordNode top = queue.remove();
			String word = top.word;

			if (word.equals(endWord)) {
				return top.numSteps;
			}

			char[] arr = word.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char temp = arr[i];
					if (arr[i] != c) {
						arr[i] = c;
					}

					String newWord = new String(arr);
					if (wordDict.contains(newWord)) {
						queue.add(new WordNode(newWord, top.numSteps + 1));
						wordDict.remove(newWord);
						// makes sure that the same word is not explore 
						// again
					}

					arr[i] = temp;
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println("XXX");
	}
}
