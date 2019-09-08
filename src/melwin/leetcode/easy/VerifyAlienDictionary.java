package melwin.leetcode.easy;

import java.util.HashMap;

// String | Arrays | Sorting

public class VerifyAlienDictionary {

	public static boolean isAlienSorted(String[] words, String order) {

		HashMap<Character, Integer> dict = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			dict.put(order.charAt(i), i);
		}

		for (int i = 1; i < words.length; i++) {
			if (compare(words[i - 1], words[i], dict) > 0) {
				return false;
			}
		}
		return true;
	}

	private static int compare(String o1, String o2, HashMap<Character, Integer> dict) {
		int i = 0, j = 0;
		for (; i < o1.length() && j < o2.length(); i++, j++) {
			int diff = dict.get(o1.charAt(i)) - dict.get(o2.charAt(j));
			if (diff != 0) {
				return diff;
			}
		}
		if (i < o1.length()) {
			return 1;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		String[] words = { "hello", "leetcode" };
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words, order));

		words = new String[] { "word", "world", "row" };
		order = "worldabcefghijkmnpqstuvxyz";
		System.out.println(isAlienSorted(words, order));

		words = new String[] { "apple", "app" };
		order = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(isAlienSorted(words, order));
	}

}
