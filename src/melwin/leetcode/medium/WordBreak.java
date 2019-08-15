package melwin.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// DP | 1D Storage | XXX |

public class WordBreak {
	
	public static boolean wordBreak(String s, Set<String> dict) {

		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (String str : dict) {
				if (str.length() <= i) {
					if (f[i - str.length()]) {
						if (s.substring(i - str.length(), i).equals(str)) {
							f[i] = true;
							break;
						}
					}
				}
			}
		}

		return f[s.length()];
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		
		System.out.println(wordBreak("leetcode", dict));
	}

}
