package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Arrays

public class IntersectionOfTwoArraysII {
	public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		int[] result_int = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			result_int[i] = result.get(i);
		}
		return result_int;
	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

}
