package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 386 - Lexicographical Numbers - O(n) - pattern in getting the next number

public class LexicographicalNumbers {
	
	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>(n);
		int curr = 1;
		for (int i = 1; i <= n; i++) {
			list.add(curr);
			if (curr * 10 <= n) {
				curr *= 10;
			} else if (curr % 10 != 9 && curr + 1 <= n) {
				curr++;
			} else {
				while ((curr / 10) % 10 == 9) {
					curr /= 10;
				}
				curr = curr / 10 + 1;
			}
		}
		return list;
	}

	public static void main(String[] args) {
	}

}
