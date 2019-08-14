package melwin.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Hash Map

public class IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> mapping = new HashMap<>();
		Set<Character> values = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (mapping.containsKey(s.charAt(i))) {
				if (mapping.get(s.charAt(i)) == t.charAt(i))
					continue;
				else
					return false;
			} else {
				if (values.contains(t.charAt(i)))
					return false;
				mapping.put(s.charAt(i), t.charAt(i));
				values.add(t.charAt(i));
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
	}

}
