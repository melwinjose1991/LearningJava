package melwin.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

// 68 - Text Justification

public class TextJustification {

	public List<String> fullJustify(String[] words, int L) {

		List<String> lines = new ArrayList<String>();
		int index = 0;

		while (index < words.length) {

			int count = words[index].length();
			int last = index + 1;
			while (last < words.length) {
				if (words[last].length() + count + 1 > L)
					break;
				// plus one for the space, if its a perfect fit it will fit
				count += 1 + words[last].length();
				last++;
			}

			StringBuilder builder = new StringBuilder();
			builder.append(words[index]);
			int diff = last - index - 1;
			// if last line or number of words in the line is 1, left-justified
			if (last == words.length || diff == 0) {
				for (int i = index + 1; i < last; i++) {
					builder.append(" ");
					builder.append(words[i]);
				}
				for (int i = builder.length(); i < L; i++) {
					builder.append(" ");
				}
			} else {
				// middle justified

				int spaces = (L - count) / diff; // spaces for all words
				int r = (L - count) % diff; // extra spaces for some words

				for (int i = index + 1; i < last; i++) {
					for (int k = spaces; k > 0; k--) {
						builder.append(" ");
					}
					if (r > 0) {
						builder.append(" ");
						r--;
					}
					builder.append(" ");
					builder.append(words[i]);
				}
			}

			lines.add(builder.toString());
			index = last;
		}
		return lines;
	}

	public static void main(String[] args) {
	}

}
