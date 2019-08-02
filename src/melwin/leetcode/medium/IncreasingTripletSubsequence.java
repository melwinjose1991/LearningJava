package melwin.leetcode.medium;

// Arrays | Pre processing

public class IncreasingTripletSubsequence {
	public static boolean increasingTriplet(int[] nums) {
		if (nums.length == 0)
			return false;
		int[] smallest = new int[nums.length];
		smallest[0] = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < smallest[i - 1]) {
				smallest[i] = nums[i - 1];
			} else {
				smallest[i] = smallest[i - 1];
			}
		}
		// System.out.println(Arrays.toString(smallest));

		int[] largest = new int[nums.length];
		largest[nums.length - 1] = Integer.MIN_VALUE;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i + 1] > largest[i + 1]) {
				largest[i] = nums[i + 1];
			} else {
				largest[i] = largest[i + 1];
			}
		}
		// System.out.println(Arrays.toString(largest));

		for (int i = 1; i < nums.length - 1; i++) {
			if (smallest[i] < nums[i] && nums[i] < largest[i]) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(increasingTriplet(nums));

		nums = new int[] { 5, 4, 3, 2, 1 };
		System.out.println(increasingTriplet(nums));
	}

}
