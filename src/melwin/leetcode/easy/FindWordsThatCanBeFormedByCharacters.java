package melwin.leetcode.easy;

// String | 

public class FindWordsThatCanBeFormedByCharacters {
	public int countCharacters(String[] words, String chars) {
		int[] chars_map = new int[26];
		for (char c : chars.toCharArray()) {
			chars_map[c - 'a']++;
		}
		int total_len = 0;
		for (String word : words) {
			int[] word_map = new int[26];
			for (char w : word.toCharArray()) {
				word_map[w - 'a']++;
			}
			if (canBeFormed(chars_map, word_map)) {
				total_len += word.length();
			}
		}
		return total_len;
	}

	private boolean canBeFormed(int[] chars_map, int[] word_map) {
		for (int i = 0; i < 26; i++) {
			if (word_map[i] > chars_map[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
