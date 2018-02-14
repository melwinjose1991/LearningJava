package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// 728 - Self Dividing Numbers - O(nm)

public class SelfDivingNumbers {
	
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			int j = i;
			for (; j > 0; j /= 10) {
				if ((j % 10 == 0) || (i % (j % 10) != 0))
					break;
			}
			if (j == 0)
				list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
	}

}
