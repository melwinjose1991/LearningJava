package melwin.leetcode.medium;

// Graphs | DFS

public class FriendCircles {
	public static int findCircleNum(int[][] M) {
		boolean[] visited = new boolean[M.length];
		int num_circles = 0;
		for (int i = 0; i < visited.length; i++) {
			// System.out.println(Arrays.toString(visited));
			if (visited[i] == false) {
				num_circles++;
				dfs(i, M, visited);
			}
		}
		return num_circles;
	}

	public static void dfs(int i, int[][] M, boolean[] visited) {
		visited[i] = true;
		for (int j = 0; j < M[i].length; j++) {
			if (M[i][j] == 1 && visited[j] == false) {
				dfs(j, M, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] M = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		System.out.println(findCircleNum(M));
	}

}
