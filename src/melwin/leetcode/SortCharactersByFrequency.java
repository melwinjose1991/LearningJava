package melwin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortCharactersByFrequency {

	public static String frequencySort(String s) {
		HashMap<Character, Integer> frequency_count = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (frequency_count.containsKey(c)) {
				int count = frequency_count.get(c);
				frequency_count.put(c, count + 1);
			} else {
				frequency_count.put(c, 1);
			}
		}

		TreeMap<Integer, ArrayList<Character>> reverse_map = new TreeMap();
		Iterator it = frequency_count.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			int count = (int) pair.getValue();
			char c = (char) pair.getKey();
			if (reverse_map.containsKey(count)) {
				reverse_map.get(count).add(c);
			} else {
				ArrayList<Character> char_list = new ArrayList<>();
				char_list.add(c);
				reverse_map.put(count, char_list);
			}
		}

		StringBuilder ans = new StringBuilder(s.length());
		for (Entry<Integer, ArrayList<Character>> entry : reverse_map.entrySet()) {
			int count = entry.getKey();
			ArrayList<Character> chars = entry.getValue();
			for (char c : chars) {
				for (int i = 0; i < count; i++) {
					ans.append(c);
				}
			}
		}
		
		//System.out.println(ans.reverse());
	
		return ans.reverse().toString();
	}

	public static void main(String[] args) {
		frequencySort("tree");
		frequencySort("cccaaa");
		System.out.println(frequencySort("abaaccaba"));
	}

}
