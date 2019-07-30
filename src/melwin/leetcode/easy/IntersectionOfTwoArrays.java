package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int prev1, prev2;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			// System.out.println(i + " " + nums1[i] + " || " + j + " " + nums2[j]);
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				prev1 = nums1[i++];
				prev2 = nums2[j++];
				while (i < nums1.length && nums1[i] == prev1) {
					prev1 = nums1[i++];
				}
				while (j < nums2.length && nums2[j] == prev2) {
					prev2 = nums2[j++];
				}

			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}

}
