package melwin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// ||IMPROVABLE|| ||ANAGRAMS|| ||O_n*m|| ||HASH_FUNCTION||
// ||HASH_TRICK|| ||COUNTING_TRICK||

public class Analyzed_GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] arr = new char[26];
			for (int i = 0; i < str.length(); i++) {
				arr[str.charAt(i) - 'a']++;
			}
			/*
			 * You had sorted which added an extra n.logn. Another solution was
			 * to create hash 'a09b11..', The optimal solution is similar,
			 * instead of storing alphabets along with their count, just use the
			 * count of a-z
			 */
			String ns = new String(arr);

			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}

		result.addAll(map.values());

		return result;
	}

	public static void main(String[] args) {
	}

}
