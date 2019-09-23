package melwin.leetcode.easy;

// Strings | Arrays

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[][] char_count = new int[26][2];
		for (char c : s.toCharArray()) {
			char_count[c - 'a'][0]++;
		}
		for (char c : t.toCharArray()) {
			char_count[c - 'a'][1]++;
			if (char_count[c - 'a'][1] > char_count[c - 'a'][0])
				return false;
		}
		for (int i = 0; i < 26; i++) {
			if (char_count[i][0] != char_count[i][1])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
	}

}
