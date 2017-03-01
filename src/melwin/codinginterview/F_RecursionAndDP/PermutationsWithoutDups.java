package melwin.codinginterview.F_RecursionAndDP;

import java.util.ArrayList;

// ||RECURSION|| ||PERMUTATION|| ||O(n*n!)||

public class PermutationsWithoutDups {
	public static ArrayList<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		ArrayList<String> permutations = new ArrayList<String>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = str.charAt(0); // get the first character
		String remainder = str.substring(1); // remove the first character
		ArrayList<String> words = getPerms(remainder); // get all permutations
														// of remainder
		// for each permutations of `remainder`
		// insert `first` in all possible locations
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}

	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

	public static void main(String[] args) {
		ArrayList<String> list = getPerms("aaaaaaaaa");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
