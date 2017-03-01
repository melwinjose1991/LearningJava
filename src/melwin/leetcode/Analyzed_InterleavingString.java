package melwin.leetcode;

// ||DP|| ||O_n^2|| ||LCS_SIMILAR|| 
// ||2D_DP|| 

public class Analyzed_InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null)
			return false;
		if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0)
			return true;
		if ((s1.length() + s2.length()) != s3.length())
			return false;
		boolean valid[] = new boolean[s2.length() + 1];
		valid[0] = false;
		for (int j = 1; j <= s2.length(); j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1))
				valid[j] = true;
		}
		for (int i = 1; i <= s1.length(); i++) {
			if (i == 1 && s1.charAt(i - 1) == s3.charAt(i - 1))
				valid[0] = true;
			for (int j = 1; j <= s2.length(); j++) {
				valid[j] = (valid[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
						|| (valid[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		}
		return valid[s2.length()];
	}

	public static void main(String[] args) {
		Analyzed_InterleavingString x = new Analyzed_InterleavingString();
		System.out.println(x.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

}
