package melwin.codinginterview.SortingAndSearching;

// ||DYNAMIC PROGRAMMING|| ||TREE|| ||RANK||
// ||O(log n)|| ||AUGMENTED TREES||

public class RankFromStream {

	public class RankNode {
		public int left_size = 0;
		public RankNode left;
		public RankNode right;
		public int data = 0;

		public RankNode(int d) {
			data = d;
			left_size = 0;
		}

		public void insert(int d) {
			if (d <= data) {
				if (left != null) {
					left.insert(d);
				} else {
					left = new RankNode(d);
				}
				left_size++;
			} else {
				if (right != null) {
					right.insert(d);
				} else {
					right = new RankNode(d);
				}
			}
		}

		public int getRank(int d) {
			if (d == data) {
				return left_size;
			} else if (d < data) {
				if (left == null) {
					return -1;
				} else {
					return left.getRank(d);
				}
			} else {
				int right_rank = right == null ? -1 : right.getRank(d);
				if (right_rank == -1) {
					return -1;
				} else {
					return left_size + 1 + right_rank;
				}
			}
		}
	}

	private static RankNode root = null;

	public static void track(int number) {
		if (root == null) {
			root = (new RankFromStream()).new RankNode(number);
		} else {
			root.insert(number);
		}
	}

	public static int getRankOfNumber(int number) {
		return root.getRank(number);
	}

	public static void main(String[] args) {
		int size = 5;
		int[] list = randomArray(size, 1, 10);
		for (int i = 0; i < list.length; i++) {
			track(list[i]);
		}

		System.out.println("Array: " + arrayToString(list));

		int[] tracker = new int[size];
		for (int i = 0; i < list.length; i++) {
			int v = list[i];
			int rank1 = root.getRank(list[i]);
			tracker[rank1] = v;
		}

		for (int i = 0; i < tracker.length - 1; i++) {
			if (tracker[i] != 0 && tracker[i + 1] != 0) {
				if (tracker[i] > tracker[i + 1]) {
					System.out.println("ERROR at " + i);
				}
			}
		}

		System.out.println("Array: " + arrayToString(list));
		System.out.println("Ranks: " + arrayToString(tracker));
	}

	public static int[] randomArray(int N, int min, int max) {
		int[] array = new int[N];
		for (int j = 0; j < N; j++) {
			array[j] = randomIntInRange(min, max);
		}
		return array;
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static String arrayToString(int[] array) {
		if (array == null)
			return "";
		return arrayToString(array, 0, array.length - 1);
	}

	public static String arrayToString(int[] array, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i <= end; i++) {
			int v = array[i];
			sb.append(v + ", ");
		}
		return sb.toString();
	}

}
