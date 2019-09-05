package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> seq_set = new HashSet<>();
		StringBuilder cur_seq = new StringBuilder();
		Set<String> result = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			if (i <= 9) {
				cur_seq.append(s.charAt(i));
				if (i == 9)
					seq_set.add(cur_seq.toString());
			} else {
				cur_seq.append(s.charAt(i));
				cur_seq.deleteCharAt(0);
				if (!seq_set.add(cur_seq.toString()))
					result.add(cur_seq.toString());
			}
		}

		return new ArrayList<>(result);

	}

	public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAA"));
	}

}
