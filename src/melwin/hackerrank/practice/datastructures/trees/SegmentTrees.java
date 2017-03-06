package melwin.hackerrank.practice.datastructures.trees;

// Source : Segment Tree Range Minimum Query by Tushar Roy - Coding Made Simple
public class SegmentTrees {
	
	public static int nextPowerOf2(int num){
        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }
	
	public static int[] createSegmentTree(int input[]) {
		int nextPowOfTwo = nextPowerOf2(input.length);
		int segmentTree[] = new int[nextPowOfTwo * 2 - 1];

		for (int i = 0; i < segmentTree.length; i++) {
			segmentTree[i] = Integer.MAX_VALUE;
		}
		constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0);
		return segmentTree;

	}
	public static int rangeMinimumQuery(int[] segmentTree, int qlow, int qhigh, int len) {
		return rangeMinimumQuery(segmentTree, 0, len - 1, qlow, qhigh, 0);
	}

	// Time : O(n)		Space : O(4n)
	private static void constructMinSegmentTree(int segmentTree[], int input[], int low, int high, int pos) {
		// creates the segmentTree in postOrderTraversal kind of manner
		// low-high: range in the input array
		// pos: position to be filled in the segementTree, also
		//		the root of the current tree
		
		if (low == high) {
			segmentTree[pos] = input[low];
			return;
		}
		
		int mid = (low + high) / 2;
		// to the left
		constructMinSegmentTree(segmentTree, input, low, mid, 2 * pos + 1);
		// to the right
		constructMinSegmentTree(segmentTree, input, mid + 1, high, 2 * pos + 2);
		// getting the min of two children
		segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
	}

	// Time : O(4.logn)
	private static int rangeMinimumQuery(int segmentTree[], int low, int high, int qlow, int qhigh, int pos) {
		// total overlap
		if (qlow <= low && qhigh >= high) {
			return segmentTree[pos];
		}
		// no overlap
		if (qlow > high || qhigh < low) {
			return Integer.MAX_VALUE;
		}
		// partial overlap, traverse to both branches
		int mid = (low + high) / 2;
		return Math.min(rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
				rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2));
	}

	// TODO : Look into lazy propagation as well
	//			Lazy Propagation Segment Tree
	public static void main(String args[]) {
		int input[] = { 0, 3, 4, 2, 1, 6, -1 };
		int segTree[] = createSegmentTree(input);

		System.out.println(0 == rangeMinimumQuery(segTree, 0, 3, input.length));
		System.out.println( 1 == rangeMinimumQuery(segTree, 1, 5, input.length));
		System.out.println( -1 == rangeMinimumQuery(segTree, 1, 6, input.length));
		System.out.println( 2 == rangeMinimumQuery(segTree, 1, 3, input.length));
		System.out.println( -1 == rangeMinimumQuery(segTree, 5, 6, input.length));
		System.out.println( 0 == rangeMinimumQuery(segTree, 0, 3, input.length));

	}
}
