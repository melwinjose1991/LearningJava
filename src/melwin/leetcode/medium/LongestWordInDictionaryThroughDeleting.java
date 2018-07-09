package melwin.leetcode.medium;

import java.util.List;

// 524. Longest Word in Dictionary through Deleting - O(nk)

public class LongestWordInDictionaryThroughDeleting {

	public String findLongestWord(String s, List<String> d) {
		String longest = "";
		for (String dictWord : d) {
			int i = 0;
			for (char c : s.toCharArray())
				if (i < dictWord.length() && c == dictWord.charAt(i))
					i++;

			if (i == dictWord.length() && dictWord.length() >= longest.length())
				if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0)
					longest = dictWord;
		}
		return longest;
	}

	public static void main(String[] args) {
	}

}
