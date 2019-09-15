package melwin.leetcode.medium;

// String | Arrays | Backtracking

public class WordSearch {

	private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j] && dfs(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(char[][] b, int x, int y, String w, int i) {
		if (b[x][y] == w.charAt(i)) {
			b[x][y] = '.';
			if (i == w.length() - 1)
				return true;
			for (int[] d : directions) {
				int new_x = x + d[0];
				int new_y = y + d[1];
				if (new_x >= 0 && new_x < b.length && new_y >= 0 && new_y < b[0].length
						&& dfs(b, new_x, new_y, w, i + 1)) {
					return true;
				}
			}
			b[x][y] = w.charAt(i);
			return false;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' }, };
		System.out.println(exist(board, "ABCCED"));

		board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' }, };
		System.out.println(exist(board, "SEE"));

		board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' }, };
		System.out.println(exist(board, "ABCB"));
	}

}
