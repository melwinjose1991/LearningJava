package melwin.leetcode.easy;

// Strings

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 0; i < strs.length; i++) {
			int j = 0;
			for (; j < prefix.length() && j < strs[i].length(); j++) {
				if (strs[i].charAt(j) != prefix.charAt(j)) {
					break;
				}
			}
			// System.out.println(i + " " + prefix);
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(longestCommonPrefix(strs));

		strs = new String[] { "dog", "dog-master", "flight" };
		System.out.println(longestCommonPrefix(strs));
	}

}
