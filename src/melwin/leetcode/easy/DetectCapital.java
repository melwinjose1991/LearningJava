package melwin.leetcode.easy;

// Strings

public class DetectCapital {
	public static boolean detectCapitalUse(String word) {
		boolean first_capital = false;
		int upper_counter = 0, lower_counter = 0;
		for (int i = 0; i < word.length(); i++) {
			boolean is_upper = Character.isUpperCase(word.charAt(i));
			if (i == 0) {
				if (is_upper) {
					first_capital = true;
				} else {
					first_capital = false;
				}
			} else {
				if (is_upper) {
					upper_counter++;
				} else {
					lower_counter++;
				}
			}
		}
		boolean rest_upper_case = (upper_counter == word.length() - 1) ? true : false;
		boolean rest_lower_case = (lower_counter == word.length() - 1) ? true : false;
		if ((word.length() == 1 && first_capital) || (first_capital && rest_upper_case)
				|| (!first_capital && rest_lower_case) || (first_capital && rest_lower_case)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("Google"));
		System.out.println(detectCapitalUse("leetcode"));
		System.out.println(detectCapitalUse("I"));

		System.out.println(detectCapitalUse("UsA"));
		System.out.println(detectCapitalUse("uSa"));
		System.out.println(detectCapitalUse("mL"));
	}

}
