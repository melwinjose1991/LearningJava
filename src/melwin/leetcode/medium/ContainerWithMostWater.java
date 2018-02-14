package melwin.leetcode.medium;

// 11 - Container with most water - O(n) - Two Pointer

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}

	public static void main(String[] args) {
	}

}
