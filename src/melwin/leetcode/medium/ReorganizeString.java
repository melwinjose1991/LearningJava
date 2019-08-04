package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// Priority Queue

public class ReorganizeString {
	public static String reorganizeString(String S) {
		HashMap<Character, Integer> char_count = new HashMap<>();
		for (char c : S.toCharArray()) {
			char_count.put(c, char_count.getOrDefault(c, 0) + 1);
		}
		PriorityQueue<Character> pq = new PriorityQueue<>(S.length(), new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return - char_count.get(o1) + char_count.get(o2);
			}
		});
		for (char c : char_count.keySet()) {
			pq.add(c);
		}
		StringBuilder string = new StringBuilder();
		while (!pq.isEmpty()) {
			List<Character> popped = new ArrayList<Character>();
			char c = pq.poll();
			popped.add(c);
			while (string.length() > 0 && pq.size() > 0 && string.charAt(string.length() - 1) == c) {
				c = pq.poll();
				popped.add(c);
				// System.out.println("looping-" + c);
			}
			if (string.length() > 0 && c == string.charAt(string.length() - 1)) {
				return "";
			} else {
				string.append(c);
				int new_count = char_count.get(c) - 1;
				char_count.put(c, new_count);
				for (char p : popped) {
					if (char_count.get(p) > 0) {
						pq.add(p);
					}
				}
			}
			// System.out.println(string);
		}
		// System.out.println(string);
		return string.toString();
	}

	public static void main(String[] args) {
		System.out.println(reorganizeString("aab"));
		System.out.println(reorganizeString("aaba"));
		System.out.println(reorganizeString("abc"));
		System.out.println(reorganizeString("aabbcc"));
	}

}
