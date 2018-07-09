package melwin.codinginterview.A_ArrayAndStrings_DONE;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Chapter 1 : Arrays And Strings
 * Question  : 1.4
 */

public class PalindromePermutation {

	private static boolean checkPalindromePermutation(String input) {
		HashMap<Character, Integer> hm = new HashMap<>();

		for (char c : input.toLowerCase().toCharArray()) {
			if (c != ' ')
				hm.put(c, hm.containsKey(c) ? hm.get(c) + 1 : 1);
		}

		Iterator i = hm.entrySet().iterator();
		int found_single_char = -1;
		while (i.hasNext()) {
			Map.Entry pair = (Map.Entry) i.next();
			if (Integer.parseInt(pair.getValue().toString()) % 2 != 0) {
				if (found_single_char == 1) {
					return false;
				} else {
					found_single_char = 1;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkPalindromePermutation("Tact Coa") ? "YES" : "NO");
		System.out.println(checkPalindromePermutation("Tac Coa") ? "YES" : "NO");
	}

}
