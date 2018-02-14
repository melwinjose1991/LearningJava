package melwin.leetcode.medium;

// 31 - Next Permutation - O(n)

public class NextPermutation {

	public void nextPermutation(int[] num) {
		int n = num.length;
		if (n < 2)
			return;
		
		// find the 1st decreasing element from
		// the right
		int index = n - 1;
		while (index > 0) {
			if (num[index - 1] < num[index])
				break;
			index--;
		}
		
		if (index == 0) {
			reverseSort(num, 0, n - 1);
			return;
		} else {
			// swap it with the lowest on its right
			int val = num[index - 1];
			int j = n - 1;
			while (j >= index) {
				if (num[j] > val)
					break;
				j--;
			}
			swap(num, j, index - 1);
			
			// sort the right
			reverseSort(num, index, n - 1);
			return;
		}
	}

	public void swap(int[] num, int i, int j) {
		int temp = 0;
		temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	public void reverseSort(int[] num, int start, int end) {
		if (start > end)
			return;
		for (int i = start; i <= (end + start) / 2; i++)
			swap(num, i, start + end - i);
	}

	public static void main(String[] args) {
	}

}
