package melwin.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// Heap | Min-Heap

public class SortCharacterByFrequency {
	public static String frequencySort(String s) {
		if(s.length()==0)
			return s;
		HashMap<Character, Integer> char_count = new HashMap<>();
		for (char c : s.toCharArray()) {
			int count = char_count.getOrDefault(c, 0);
			char_count.put(c, count + 1);
		}

		PriorityQueue<Character> heap = new PriorityQueue<>(s.length(), new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				return char_count.get(c2) - char_count.get(c1);
			}
		});

		for (char c : char_count.keySet()) {
			heap.add(c);
		}

		StringBuilder sb = new StringBuilder();
		while (!heap.isEmpty()) {
			char c = heap.poll();
			int count = char_count.get(c);
			for (int i = 0; i < count; ++i)
				sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
	}

}
