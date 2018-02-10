package melwin.leetcode.medium;

// 277 - Find The Celebrity - DFS + verification

public class FindTheCelebrity {
	
	public static boolean knows(int x, int y){
		return false;
	}
	
	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i))
				candidate = i;
		}
		for (int i = 0; i < n; i++) {
			if (i != candidate && (knows(candidate, i) || !knows(i, candidate)))
				return -1;
		}
		return candidate;
	}

	public static void main(String[] args) {
	}

}
