package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, List<String>> key_words = new HashMap<>();
		for (String s : strs) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String key = new String(c);
			if (key_words.containsKey(key)) {
				key_words.get(key).add(s);
			} else {
				List<String> word_list = new ArrayList<String>();
				word_list.add(s);
				key_words.put(key, word_list);
			}
		}
		for(String key : key_words.keySet()) {
			result.add(key_words.get(key));
		}
		return result;
	}

	public static void main(String[] args) {
	}

}
