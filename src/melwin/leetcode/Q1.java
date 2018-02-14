package melwin.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

	public static String solution(String S) {
		int[] numbers = new int[4];
		numbers[0] = Integer.parseInt(S.charAt(0) + "");
		numbers[1] = Integer.parseInt(S.charAt(1) + "");
		numbers[2] = Integer.parseInt(S.charAt(3) + "");
		numbers[3] = Integer.parseInt(S.charAt(4) + "");

		List<List<Integer>> list = new ArrayList<>();
		permute(list, new ArrayList<>(), numbers, new boolean[numbers.length]);

		return getMin(list, numbers);
	}

	public static void permute(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used) {
		if (temp.size() == nums.length) {
			int hrs = temp.get(0) * 10 + temp.get(1);
			int mins = temp.get(2) * 10 + temp.get(3);
			if (hrs <= 23 && mins <= 59) {
				int start_hrs = nums[0] * 10 + nums[1];
				int start_mins = nums[2] * 10 + nums[3];

				if (!(hrs == start_hrs && mins == start_mins)) {
					list.add(new ArrayList<>(temp));
					// System.out.println(temp.toString());
				}
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])
					continue;

				used[i] = true;
				temp.add(nums[i]);
				permute(list, temp, nums, used);
				used[i] = false;
				temp.remove(temp.size() - 1);

			}
		}
	}

	public static String getMin(List<List<Integer>> permutations, int[] nums) {
		int min_diff = Integer.MAX_VALUE;
		int start_hrs = nums[0] * 10 + nums[1];
		int start_mins = nums[2] * 10 + nums[3];
		String closest_time = (start_hrs < 10 ? "0" + start_hrs : start_hrs) + ":"
				+ (start_mins < 10 ? "0" + start_mins : start_mins);

		for (List<Integer> time : permutations) {
			int end_hrs = time.get(0) * 10 + time.get(1);
			int end_mins = time.get(2) * 10 + time.get(3);

			if (end_mins >= start_mins) {
				int diff_min = end_mins - start_mins;
				int diff_hrs = end_hrs - start_hrs;
				if (diff_hrs < 0) {
					diff_hrs += 24;
				}
				int total_diff = diff_hrs * 60 + diff_min;
				if (total_diff < min_diff) {
					min_diff = total_diff;
					closest_time = (end_hrs < 10 ? "0" + end_hrs : end_hrs) + ":"
							+ (end_mins < 10 ? "0" + end_mins : end_mins);
				}
			} else {
				int diff_min = end_mins - start_mins + 60;
				int diff_hrs = end_hrs - start_hrs - 1;
				if (diff_hrs < 0) {
					diff_hrs += 24;
				}
				int total_diff = diff_hrs * 60 + diff_min;
				if (total_diff < min_diff) {
					min_diff = total_diff;
					closest_time = (end_hrs < 10 ? "0" + end_hrs : end_hrs) + ":"
							+ (end_mins < 10 ? "0" + end_mins : end_mins);
				}
			}
		}
		return closest_time;
	}

	public static void main(String[] args) {
		System.out.println(solution("01:10"));
		System.out.println(solution("23:59"));
		System.out.println(solution("11:00"));
		System.out.println(solution("12:34"));
	}

}
