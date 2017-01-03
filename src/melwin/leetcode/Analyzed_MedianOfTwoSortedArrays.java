package melwin.leetcode;

// ||MEDIAN OF TWO SORTED ARRAYS|| ||MERGE||
// ||O(log(m+n))|| ||MEDIAN||

public class Analyzed_MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total_size = nums1.length + nums2.length;
		int i = 0, j = 0, mid = (total_size % 2 == 0) ? (total_size / 2) - 1 : (total_size / 2);
		while (i < nums1.length && j < nums2.length) {
			if (i + j == mid) {
				if (total_size % 2 == 0) {
					int first_med = 0, second_med = 0;
					if (nums1[i] <= nums2[j]) {
						first_med = nums1[i++];
						if (i < nums1.length && nums1[i] <= nums2[j]) {
							second_med = nums1[i++];
						} else {
							second_med = nums2[j++];
						}

					} else {
						first_med = nums2[j++];
						if (j < nums2.length && nums2[j] <= nums1[i]) {
							second_med = nums2[j++];
						} else {
							second_med = nums1[i++];
						}
					}
					return (first_med + second_med) / 2.0;
				} else {
					if (nums1[i] <= nums2[j]) {
						return nums1[i];
					} else {
						return nums2[j];
					}
				}
			}
			if (nums1[i] <= nums2[j]) {
				i++;
			} else {
				j++;
			}
		}
		while (i < nums1.length) {
			if (i + j == mid) {
				if (total_size % 2 == 0) {
					return (nums1[i] + nums1[i + 1]) / 2.0;
				} else {
					return nums1[i];
				}
			}
			i++;
		}
		while (j < nums2.length) {
			if (j + i == mid) {
				if (total_size % 2 == 0) {
					return (nums2[j] + nums2[j + 1]) / 2.0;
				} else {
					return nums2[j];
				}
			}
			j++;
		}
		return -1;
	}

	public static void main(String[] args) {
		Analyzed_MedianOfTwoSortedArrays x = new Analyzed_MedianOfTwoSortedArrays();
		int[] num1 = { 1, 3, 4 };
		int[] num2 = { 2 };
		System.out.println(x.findMedianSortedArrays(num1, num2));
	}

}
