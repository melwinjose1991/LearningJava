package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// HashMap

public class KeyboardRow {

	public static HashMap<Character, Integer> char_row_map;
	static {
		String[] row_chars = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
		char_row_map = new HashMap<>();
		for (int i = 0; i < row_chars.length; i++) {
			for (int j = 0; j < row_chars[i].length(); j++) {
				char_row_map.put(row_chars[i].charAt(j), i);
			}
		}
	}

	public static String[] findWords(String[] words) {
		ArrayList<String> tmp = new ArrayList<>();
		for (String word : words) {
			boolean match = true;
			for (int i = 1; i < word.length(); i++) {
				char prev = Character.toLowerCase(word.charAt(i - 1));
				char curr = Character.toLowerCase(word.charAt(i));
				if (char_row_map.get(prev) != char_row_map.get(curr)) {
					match = false;
					break;
				}
			}
			if (match)
				tmp.add(word);
		}
		String[] res = new String[tmp.size()];
		res = tmp.toArray(res);
		return res;
	}

	public static void main(String[] args) {
		String[] input = { "Hello", "Alaska", "Dad", "Peace" };
		System.out.println(Arrays.toString(findWords(input)));
	}

}
