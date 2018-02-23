package melwin.leetcode.easy;

// 189. Rotate Array - O(n)/O(1) - In-place shifting

public class RotateArray {
	
	public void rotate(int nums[], int k) {
		int n = nums.length;
		if ((n == 0) || (k <= 0)) {
			return;
		}

		int rotated_count = 0;
		int start_index = 0;
		int curr_index = 0;
		int num_to_be_rotated = nums[0];
		int tmp = 0;
		
		// Keep rotating the elements until we have rotated n
		// different elements.
		while (rotated_count < n) {
			do {
				tmp = nums[(curr_index + k) % n];
				nums[(curr_index + k) % n] = num_to_be_rotated;
				num_to_be_rotated = tmp;
				curr_index = (curr_index + k) % n;
				rotated_count++;
			} while (curr_index != start_index);
			// Stop rotating the elements when we finish one cycle,
			// i.e., we return to start.

			if(rotated_count==n) break;
			
			// Move to next element to start a new cycle.
			start_index++;
			curr_index = start_index;
			num_to_be_rotated = nums[curr_index];
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
