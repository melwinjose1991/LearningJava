package melwin.leetcode.easy;

// Graph

public class FindTheTownJudge {
	public static int findJudge(int N, int[][] trust) {
		if (N == 1 && trust.length == 0)
			return 1;

		int[] edge_count = new int[N + 1];
		for (int[] edge : trust) {
			edge_count[edge[0]]--;
			edge_count[edge[1]]++;
		}
		for (int i=1; i<=N; i++) {
			if (edge_count[i] == N - 1) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		System.out.println(findJudge(4, trust));

		trust = new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } };
		System.out.println(findJudge(3, trust));
	}

}
