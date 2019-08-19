package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// DFS | Strings

public class LetterCombinationsOfAPhoneNumber {

	private static HashMap<Character, String> mapping;

	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if(digits.length()==0)
			return result;
		
		mapping = new HashMap<>();
		mapping.put('2', "abc");
		mapping.put('3', "def");
		mapping.put('4', "ghi");
		mapping.put('5', "jkl");
		mapping.put('6', "mno");
		mapping.put('7', "pqrs");
		mapping.put('8', "tuv");
		mapping.put('9', "wxyz");

		function(digits, 0, result, "");
		return result;
	}

	private static void function(String digits, int i, List<String> result, String s) {
		if (i == digits.length()) {
			System.out.println(s);
			result.add(s);
		} else {
			for (char c : mapping.get(digits.charAt(i)).toCharArray()) {
				function(digits, i + 1, result, s + c);
			}
		}
	}

	public static void main(String[] args) {
		letterCombinations("23");
	}

}
