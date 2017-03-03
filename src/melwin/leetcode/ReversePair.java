package melwin.leetcode;

import java.util.Arrays;

// ||MERGE SORT|| ||O(n.logn)|| ||REVERSE PAIR||
// ||DIVIDE AND CONQUER|| ||LEETCODE||

public class ReversePair {

	public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }

	public static void main(String[] args) {
		int[] array = { 5, 4, 3, 2, 1 };
		ReversePair x = new ReversePair();
		System.out.println(x.reversePairs(array));
	}

}
