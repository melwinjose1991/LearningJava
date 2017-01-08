package melwin.leetcode;

// ||ARRAY|| ||NEW TECHNIQUE|| ||BUCKET SORT TECHNIQUE||

// ||O(n)||

public class Analyzed_FirstMissingPositive {

	// source
	// http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/

	// i == nums[i] in the end
	public int firstMissingPositive(int nums[]) {
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			while (nums[i] != i + 1) {
				// out of range elements
				if (nums[i] <= 0 || nums[i] >= n)
					break;

				// duplicate element
				if (nums[i] == nums[nums[i] - 1])
					break;

				int temp = nums[i];
				nums[i] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1)
				return i + 1;
		}

		return n + 1;
	}
	// NOTE : {2,1,4,0}->{1,2,4,0}->{1,2,0,4}

	public static void main(String[] args) {
		Analyzed_FirstMissingPositive x = new Analyzed_FirstMissingPositive();
		int[] array = { 2, 1, 4, 0 };
		System.out.println(x.firstMissingPositive(array));
	}

}
