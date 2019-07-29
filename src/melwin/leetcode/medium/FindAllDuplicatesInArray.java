package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Arrays | Values into indicate something

public class FindAllDuplicatesInArray {
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for (int n : nums) {
			if (nums[Math.abs(n) - 1] < 0) {
				result.add(Math.abs(n));
			} else {
				nums[Math.abs(n) - 1] *= -1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDuplicates(nums));
	}

}
