package melwin.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

// Strings | Sorting

public class ReorderDataInLogFiles {

	private final String LETTER_LOG = "LETTER_LOG";
	private final String DIGIT_LOG = "DIGIT_LOG";

	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String s1_type = Character.isAlphabetic(s1.charAt(s1.indexOf(' ') + 1)) ? LETTER_LOG : DIGIT_LOG;
				String s2_type = Character.isAlphabetic(s2.charAt(s2.indexOf(' ') + 1)) ? LETTER_LOG : DIGIT_LOG;
				if (s1_type.equals(s2_type)) {
					if (s1_type.equals(LETTER_LOG)) {
						int compare = s1.substring(s1.indexOf(' ') + 1, s1.length())
								.compareTo(s2.substring(s2.indexOf(' ') + 1, s2.length()));
						if (compare == 0)
							return s1.substring(0, s1.indexOf(' ')).compareTo(s2.substring(0, s2.indexOf(' ')));
						else
							return compare;
					} else {
						return 0;
					}
				} else {
					if (s1_type.equals(LETTER_LOG)) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});
		return logs;
	}

	public static void main(String[] args) {
	}

}
