package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null)
			return null;

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label); // new node for return
		HashMap<Integer, UndirectedGraphNode> map = new HashMap(); // store visited nodes
		map.put(newNode.label, newNode);

		LinkedList<UndirectedGraphNode> queue = new LinkedList();
		queue.add(node);

		while (!queue.isEmpty()) { // if more nodes need to be visited
			UndirectedGraphNode n = queue.pop(); // search first node in the queue
			for (UndirectedGraphNode neighbor : n.neighbors) {
				if (!map.containsKey(neighbor.label)) { // add to map and queue if this node hasn't been searched before
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);
				}
				map.get(n.label).neighbors.add(map.get(neighbor.label)); // add neighbor to new created nodes
			}
		}

		return newNode;
	}

	public static void main(String[] args) {
	}

}
