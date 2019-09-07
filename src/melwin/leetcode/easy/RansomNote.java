package melwin.leetcode.easy;

// String | Arrays

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] letters = new int[26];
		for (char c : magazine.toCharArray()) {
			letters[c - 'a']++;
		}
		for (char c : ransomNote.toCharArray()) {
			if (letters[c - 'a'] == 0) {
				return false;
			} else {
				letters[c - 'a']--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
