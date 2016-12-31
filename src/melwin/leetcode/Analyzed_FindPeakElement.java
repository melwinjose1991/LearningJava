package melwin.leetcode;

// ||MIT OpenCourseWare|| ||1. Algorithmic Thinking, Peak Finding||
// ||NEW TECHNIQUE|| ||ARRAY|| ||O(logn)||

public class Analyzed_FindPeakElement {
	public int findPeakElement(int[] num) {
		return helper(num, 0, num.length - 1);
	}

	public int helper(int[] num, int start, int end) {
		if (start == end) {
			return start;
		} else if (start + 1 == end) {
			if (num[start] > num[end])
				return start;
			return end;
		} else {

			int m = (start + end) / 2;
			if (num[m] > num[m - 1] && num[m] > num[m + 1]) {
				return m;
			} else if (num[m - 1] > num[m]) {
				// array rises towards the left
				return helper(num, start, m - 1);
			} else {
				// array rises towards the right
				return helper(num, m + 1, end);
			}
		}
	}
	// O(logn)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10,20,10,5,10,20,30};
		Analyzed_FindPeakElement x = new Analyzed_FindPeakElement();
		System.out.println(x.findPeakElement(array));
	}
	
	// 2-D Peak
	
	// Find the global 1-D peak in middle column (i,j=m/2)
	// Compare (i,j-1) (i,j) (i,j+1)
	// Pick left column if (i,j-1) > (i,j)
	// Pick right column if (i,j) < (i,j+1)
	// Else (i,j) is the 2-D peak
	
	// O(n.logm)

}
