package melwin.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 332 - Reconstruct Itinerary
// Map<String, Priority Queue>

public class ReconstructItinerary {

	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {

		flights = new HashMap<>();
		path = new LinkedList<>();

		for (String[] ticket : tickets) {
			flights.putIfAbsent(ticket[0], new PriorityQueue<>());
			flights.get(ticket[0]).add(ticket[1]);
		}

		dfs("JFK");

		return path;
	}

	public void dfs(String departure) {

		PriorityQueue<String> arrivals = flights.get(departure);

		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll());

		path.addFirst(departure);
	}

	public static void main(String[] args) {
	}

}
