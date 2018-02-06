package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Leetcode - 49 - Group Anagrams - O(n)
// HashMap - key=characters used, value=list of strings

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] code = new char[26];
			for (int i = 0; i < str.length(); i++) {
				code[str.charAt(i) - 'a']++;
			}
			// 'abac' => 'a02b01c01'

			String code_str = new String(code);

			if (map.containsKey(code_str)) {
				map.get(code_str).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(code_str, al);
			}
		}

		result.addAll(map.values());

		return result;

	}

	public static void main(String[] args) {
	}

}
