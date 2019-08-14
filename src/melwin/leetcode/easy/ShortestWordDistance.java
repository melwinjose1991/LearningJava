package melwin.leetcode.easy;

// Arrays

public class ShortestWordDistance {
	public static int shortestDistance(String[] words, String word1, String word2) {
		int index_1 = -1, index_2 = -1, min_len = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				if (index_2 != -1) {
					min_len = Math.min(min_len, i - index_2);
				}
				index_1 = i;
			}
			if (words[i].equals(word2)) {
				if (index_1 != -1) {
					min_len = Math.min(min_len, i - index_1);
				}
				index_2 = i;
			}
		}
		return min_len;
	}

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		System.out.println(shortestDistance(words, "coding", "practice"));

		System.out.println(shortestDistance(words, "makes", "coding"));
	}

}
