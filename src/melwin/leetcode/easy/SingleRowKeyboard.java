package melwin.leetcode.easy;

import java.util.HashMap;

// String | HashMap

public class SingleRowKeyboard {
	public static int calculateTime(String keyboard, String word) {
		HashMap<Character, Integer> mapping = new HashMap<>();
		for (int i = 0; i < keyboard.length(); i++) {
			mapping.put(keyboard.charAt(i), i);
		}
		int total_time = 0;
		for (int i = 0; i < word.length(); i++) {
			if (i == 0) {
				total_time += mapping.get(word.charAt(i));
			} else {
				total_time += Math.abs(mapping.get(word.charAt(i)) - mapping.get(word.charAt(i - 1)));
			}
		}
		return total_time;
	}

	public static void main(String[] args) {
		System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
	}

}
