package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// List | String

public class BraceExpansion {
	public static String[] expand(String S) {
		List<StringBuilder> result_list = new ArrayList<>();
		for (int i = 0; i < S.length();) {
			if (Character.isLetter(S.charAt(i))) {
				if (result_list.size() > 0) {
					for (StringBuilder r : result_list) {
						r.append(S.charAt(i));
					}
				} else {
					StringBuilder n = new StringBuilder();
					n.append(S.charAt(i));
					result_list.add(n);
				}
				i++;
			} else {
				int left_bracket = i, right_bracket = i;
				for (int j = i + 1; j < S.length(); j++) {
					if (S.charAt(j) == '}') {
						right_bracket = j;
						break;
					}
				}
				String[] options = S.substring(left_bracket + 1, right_bracket).split(",");
				Arrays.sort(options);

				List<StringBuilder> new_lvl = new ArrayList<>();
				if (result_list.size() > 0) {
					for (StringBuilder r : result_list) {
						for (String o : options) {

							StringBuilder tmp = new StringBuilder(r);
							tmp.append(o);
							new_lvl.add(tmp);
						}
					}
				} else {
					for (String o : options) {
						new_lvl.add(new StringBuilder(o));
					}
				}
				result_list = new_lvl;
				i = right_bracket + 1;

			}
			// System.out.println(result_list);
		}
		String[] result = new String[result_list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = result_list.get(i).toString();
		}
		return result;
	}

	public static void main(String[] args) {
		expand("a{b,c}d");
		expand("abcd");
		expand("{a,b}c{d,e}f");
	}

}
