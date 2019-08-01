package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// Strings | Permutation | Easy

public class LetterCasePermutation {
	public static List<String> letterCasePermutation(String S) {
		List<String> results = new ArrayList<String>();
		permute(S, 0, results, new StringBuilder());
		return results;
	}

	private static void permute(String S, int i, List<String> results, StringBuilder str) {
		if (i == S.length()) {
			results.add(new String(str));
			return;
		}
		if (Character.isAlphabetic(S.charAt(i))) {
			permute(S, i + 1, results, str.append(Character.toUpperCase(S.charAt(i))));
			str.deleteCharAt(str.length() - 1);
			permute(S, i + 1, results, str.append(Character.toLowerCase(S.charAt(i))));
			str.deleteCharAt(str.length() - 1);
		} else {
			permute(S, i + 1, results, str.append(S.charAt(i)));
			str.deleteCharAt(str.length() - 1);
		}

	}

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2"));
		System.out.println(letterCasePermutation("3z4"));
		System.out.println(letterCasePermutation("12345"));
		System.out.println(letterCasePermutation("ab"));
	}

}
