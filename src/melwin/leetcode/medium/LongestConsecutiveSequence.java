package melwin.leetcode.medium;

import java.util.HashMap;

// Leetcode - 128 - Longest Consecutive Sequence - O(n)
// <key=n, value=length of the sequence containing n>

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int n : num) {
            if (!map.containsKey(n)) {
                
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length 
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence. Will do nothing 
                // if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;   
    }
    
	public static void main(String[] args) {
	}

}
