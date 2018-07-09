package melwin.codinginterview.A_ArrayAndStrings_DONE;

import java.util.Arrays;

/*
 * Chapter 1  :	Arrays and Strings
 * Question 4 :	CheckPermutation
 */

public class CheckPermutation {

	private static boolean sortAndCheck(String a, String b) {
		if (a.length() != b.length())
			return false;

		char[] chars_a = a.toCharArray();
		Arrays.sort(chars_a);

		char[] chars_b = b.toCharArray();
		Arrays.sort(chars_b);

		String sorted_a = new String(chars_a);
		String sorted_b = new String(chars_b);

		return sorted_a.equalsIgnoreCase(sorted_b);
	}

	public static void main(String[] args) {
		System.out.println(sortAndCheck("abc", "bca"));

		System.out.println(sortAndCheck("abcdef", "bdcfa"));
	}

}
