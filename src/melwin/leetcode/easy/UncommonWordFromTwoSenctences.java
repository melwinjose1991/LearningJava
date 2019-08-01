package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Hash | Easy

public class UncommonWordFromTwoSenctences {
	public String[] uncommonFromSentences(String A, String B) {
		HashMap<String, Integer> word_count = new HashMap<>();
		String[] a_words = A.split(" ");
		for (String a : a_words) {
			word_count.put(a, word_count.getOrDefault(a, 0) + 1);
		}
		String[] b_words = B.split(" ");
		for (String b : b_words) {
			word_count.put(b, word_count.getOrDefault(b, 0) + 1);
		}
		List<String> res_list = new ArrayList<String>();
		for (String word : word_count.keySet()) {
			if (word_count.get(word) == 1) {
				res_list.add(word);
			}
		}
		String[] res_array = new String[res_list.size()];
		for (int i = 0; i < res_list.size(); i++) {
			res_array[i] = res_list.get(i);
		}
		return res_array;
	}

	public static void main(String[] args) {
	}

}
