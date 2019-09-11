package melwin.leetcode.medium;

import java.util.Arrays;

// String | DP 1D Array

public class AddBoldTagInString {
	public static String addBoldTag(String s, String[] dict) {
		boolean[] mark = new boolean[s.length()];
		for (int j = 0; j < s.length(); j++) {
			for (String d : dict) {
				int i = j - d.length() + 1;
				if (i >= 0 && s.substring(i, j + 1).equals(d)) {
					for (int k = i; k <= j; k++) {
						mark[k] = true;
					}
					break;
				}
			}
		}
		// System.out.println(Arrays.toString(mark));
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < mark.length; i++) {
			if (mark[i]) {
				if (i == 0 || !mark[i - 1])
					result.append("<b>");
				result.append(s.charAt(i));
				if (i == mark.length - 1)
					result.append("</b>");
			} else {
				if (i - 1 >= 0 && mark[i - 1])
					result.append("</b>");
				result.append(s.charAt(i));
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String[] dict = { "aaa", "aab", "bc" };
		System.out.println(addBoldTag("aaabbcc", dict));

		dict = new String[] { "abc", "123" };
		System.out.println(addBoldTag("abcxyz123", dict));
	}

}
