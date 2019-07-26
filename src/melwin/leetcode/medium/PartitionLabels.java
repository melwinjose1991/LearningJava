package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Arrays

public class PartitionLabels {
	public static List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<>();

		int[] m = new int[26];
		for (int i = 0; i < S.length(); i++) {
			m[S.charAt(i) - 'a'] = i;
		}

		for (int i = 0; i < S.length(); ) {
			int last_index = m[S.charAt(i)-'a'];
			for (int j = i; j < S.length(); j++) {
				if (j == last_index) {
					result.add(j - i + 1);
					i = j + 1;
					break;
				}
				last_index = Math.max(last_index, m[S.charAt(j)-'a']);
			}
		}

		return result;

	}

	public static void main(String[] args) {
		System.out.println(partitionLabels("aabacd"));
		System.out.println(partitionLabels("abcd"));
		System.out.println(partitionLabels("aaaa"));
		System.out.println(partitionLabels("aaab"));
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}

}
