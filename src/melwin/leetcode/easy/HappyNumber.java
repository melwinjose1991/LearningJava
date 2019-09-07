package melwin.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		do {
			set.add(n);
			int sqr = 0;
			while (n > 0) {
				int n_i = n % 10;
				sqr += (n_i * n_i);
				n = n / 10;
			}
			n = sqr;
			if (n == 1)
				return true;
		} while (!set.contains(n));
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

}
