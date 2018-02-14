package melwin.leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// 269 - Alien Dictionary - O(m.n)

public class AlienDictionary {
	
	public String alienOrder(String[] words) {
		
		Map<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> degree = new HashMap<Character, Integer>();
		String result = "";
		
		if (words == null || words.length == 0)
			return result;
		
		for (String s : words) {
			for (char c : s.toCharArray()) {
				degree.put(c, 0);
			}
		}
		
		// for each char record times where it occurred after some 
		// other char
		for (int i = 0; i < words.length - 1; i++) {
			String cur = words[i];
			String next = words[i + 1];
			int length = Math.min(cur.length(), next.length());
			for (int j = 0; j < length; j++) {
				char c1 = cur.charAt(j);
				char c2 = next.charAt(j);
				if (c1 != c2) {
					Set<Character> set = new HashSet<Character>();
					if (map.containsKey(c1))
						set = map.get(c1);
					if (!set.contains(c2)) {
						set.add(c2);
						map.put(c1, set);
						degree.put(c2, degree.get(c2) + 1);
					}
					break;
				}
			}
		}
		
		// add the chars which has never occurred after
		// any other char into the queue
		Queue<Character> q = new LinkedList<Character>();
		for (char c : degree.keySet()) {
			if (degree.get(c) == 0)
				q.add(c);
		}
		
		// remove the lexicographically first element and
		// reduce the count of chars that occur after it
		while (!q.isEmpty()) {
			char c = q.remove();
			result += c;
			if (map.containsKey(c)) {
				for (char c2 : map.get(c)) {
					degree.put(c2, degree.get(c2) - 1);
					if (degree.get(c2) == 0)
						q.add(c2);
				}
			}
		}
		
		if (result.length() != degree.size())
			return "";
		
		return result;
	}

	public static void main(String[] args) {
	}

}
