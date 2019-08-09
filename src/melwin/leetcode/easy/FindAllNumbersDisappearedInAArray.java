package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// Arrays | Changing Values

public class FindAllNumbersDisappearedInAArray {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> results = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = ((nums[i] < 0) ? -1 : 1) * nums[i] - 1;
			nums[index] = (nums[index] > 0 ? -1 : 1) * nums[index];
		}
		for (int i=0; i<nums.length; i++) {
			if (nums[i] > 0)
				results.add(i+1);
		}
		return results;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers(nums));
	}

}
