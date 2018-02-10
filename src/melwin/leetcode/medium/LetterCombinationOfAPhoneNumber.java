package melwin.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

// 17 - Letter Combination of a Phone Number

public class LetterCombinationOfAPhoneNumber {
	
	public List<String> letterCombinations(String digits) {

		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if (digits.length() == 0) {
			return ans;
		}

		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}

		return ans;

	}

	public static void main(String[] args) {
	}

}
