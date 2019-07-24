package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// HashMap

public class FindCommonCharacters {
	public static List<String> commonChars(String[] A) {
		List<String> res = new ArrayList<>();
		HashMap<String, Integer> global_map = new HashMap<>();
		for (String s : A) {
			int[] local_map = new int[26];
			for (Character c : s.toCharArray()) {
				int local_count = local_map[c - 'a'];
				local_count++;
				local_map[c - 'a'] = local_count;
				int global_count = global_map.getOrDefault(c + "_" + local_count, 0);
				global_count++;
				global_map.put(c + "_" + local_count, global_count);
				if (global_count == A.length) {
					res.add(Character.toString(c));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String[] A = { "bella", "label", "roller" };
		System.out.println(commonChars(A));

		A = new String[] { "cool", "lock", "cook" };
		System.out.println(commonChars(A));
	}

}
