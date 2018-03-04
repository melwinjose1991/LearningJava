package melwin.leetcode.easy;

// 69 Sqrt(x) - O(log N)

public class SqrtX {
	
	public int mySqrt(int x) {
		if(x==1) return 1;
		
		int left = 1, right = x/2;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
