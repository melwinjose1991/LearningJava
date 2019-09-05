package melwin.leetcode.easy;

// Arrays

public class FindSmallestLetterGreaterThanTarget {

	public char nextGreatestLetter(char[] letters, char target) {
		if (target < letters[0] || target >= letters[letters.length - 1]) {
			return letters[0];
		} else {
			for (int i = 0; i < letters.length; i++) {
				if (letters[i] == target) {
					i++;
					while (letters[i] == target)
						i++;
					return i >= letters.length ? letters[0] : letters[i];
				}
				if (letters[i] > target) {
					return letters[i];
				}
			}
		}
		return letters[0];
	}

	public static void main(String[] args) {
	}

}
