package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

// Strings

public class OccurrencesAfterBigram {

	public static String[] findOcurrences(String text, String first, String second) {
		String[] text_split = text.split("\\s+");
		ArrayList<String> third_words = new ArrayList<String>();
		String curr_first = null;
		String curr_second = null;
		for (int i = 0; i < text_split.length; i++) {
			if (curr_first == null) {
				curr_first = text_split[i];
				continue;
			}
			if (curr_second == null) {
				curr_second = text_split[i];
				continue;
			}
			if (curr_first.equals(first) & curr_second.equals(second)) {
				third_words.add(text_split[i]);
			}
			String tmp = curr_second;
			curr_second = text_split[i];
			curr_first = tmp;
		}
		String[] res = new String[third_words.size()];
		res = third_words.toArray(res);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findOcurrences("alice is a good girl she is a good student", "a", "good")));
		System.out.println(Arrays.toString(findOcurrences("we will we will rock you", "we", "will")));
	}

}
