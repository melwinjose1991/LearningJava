package melwin.leetcode.medium;

// Strings

public class OneEditDistance {
	public static boolean isOneEditDistance(String s, String t) {
		if (s.length() == 0 && t.length() == 0)
			return false;
		int len_diff = Math.abs(s.length() - t.length());
		if (len_diff == 1) {
			String smaller = s, longer = t;
			if (s.length() < t.length()) {
				smaller = s;
				longer = t;
			} else {
				smaller = t;
				longer = s;
			}
			for (int i = 0; i < smaller.length(); i++) {
				if (smaller.charAt(i) != longer.charAt(i)) {
					boolean adding = longer.equals(smaller.substring(0, i) + longer.charAt(i) + smaller.substring(i));
					boolean deleting = smaller.equals(longer.substring(0, i) + longer.substring(i + 1));
					return adding | deleting;
				}
			}
			return true;

		} else if (len_diff == 0) {
			int diffs = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i))
					diffs++;
			}
			return diffs == 1;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isOneEditDistance("ab", "acb"));
		System.out.println(isOneEditDistance("cab", "ad"));
		System.out.println(isOneEditDistance("1203", "1213"));
		
		System.out.println(isOneEditDistance("teacher", "detacher"));
		System.out.println(isOneEditDistance("c", "c"));
	}

}
