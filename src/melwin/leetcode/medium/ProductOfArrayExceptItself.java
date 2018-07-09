package melwin.leetcode.medium;

// Leetcode - 238 - Product of Array Except Self - O(n)
// DP - Two iterations
//	Multiply numbers to the left and then the right

public class ProductOfArrayExceptItself {

	public int[] productExceptSelf(int[] nums) {

		int n = nums.length;
		int[] res = new int[n];

		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}

		return res;

	}

	public static void main(String[] args) {
	}

}
