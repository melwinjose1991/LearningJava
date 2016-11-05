package melwin.codinginterview.ArrayAndStrings;

/*
 * Chapter  1 : Arrays And Strings
 * Question 5 : One Away
 */

public class OneAway {

	private static boolean checkOneEdit(String s1, String s2, boolean equal_strings) {
		int i = 0;
		int j = 0;
		boolean one_mismatch_found = false;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				if (one_mismatch_found)
					return false; // 2nd mismatch
				else {
					one_mismatch_found = true;
					if (!equal_strings) {
						if (s1.length() > s2.length())
							i++;
						else
							j++;
						continue;
					}
				}
			}
			i++;
			j++;
		}
		return true; // one or no mismatch
	}

	private static boolean check(String s1, String s2) {
		if (s1.length() == s2.length()) {
			if (s1.equals(s2))
				return true; // zero-edits
			else
				return checkOneEdit(s1, s2, true);
		} else {
			if (Math.abs(s1.length() - s2.length()) == 1) {
				return checkOneEdit(s1, s2, false);
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		String[] s1 = { "pale", "pales", "pale", "pale", "abc", "abcf" };
		String[] s2 = { "ple", "pale", "bale", "bake", "abcd", "abcde" };

		for (int i = 0; i < s1.length; i++) {
			System.out.println(check(s1[i], s2[i]));
		}
	}

}
