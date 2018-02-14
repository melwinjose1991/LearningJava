package melwin.leetcode.easy;

// 665 - Non-decreasing Array - O(n) - there are two cases

public class NonDecreasingArray {

	public boolean checkPossibility(int[] nums) {
		int cnt = 0; 
		for (int i = 1; i < nums.length && cnt <= 1; i++) {
			if (nums[i - 1] > nums[i]) {
				cnt++;
				if (i - 2 < 0 || nums[i - 2] <= nums[i])
					// modify nums[i-1] of a priority
					// [1,2,5,3(i),4]
					nums[i - 1] = nums[i]; 
				else
					// have to modify nums[i]
					// [2,3,3,3,3,2(i),4]
					nums[i] = nums[i - 1]; 
			}
		}
		return cnt <= 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
