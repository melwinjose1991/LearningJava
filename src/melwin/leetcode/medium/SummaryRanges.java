package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Array

public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < nums.length;) {
			int j = i + 1;
			while (j < nums.length && nums[j] == nums[j - 1] + 1)
				j++;
			if (j == i + 1) {
				result.add(String.valueOf(nums[i]));
				i++;
			} else {
				result.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j - 1]));
				i = j;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 4, 5, 6 };
		System.out.println(summaryRanges(nums));

		nums = new int[] { 0, 1, 2, 4, 5, 7 };
		System.out.println(summaryRanges(nums));
		
		nums = new int[] { 0, 1, 2, 3, 4, 5, 6 };
		System.out.println(summaryRanges(nums));
		
		nums = new int[] { 0 };
		System.out.println(summaryRanges(nums));
	}

}
