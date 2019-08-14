package melwin.leetcode.easy;

import java.util.HashMap;

// HashMap 

public class Logger {

	private HashMap<String, Integer> msg_ts;

	public Logger() {
		msg_ts = new HashMap<>();

	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		if (timestamp - msg_ts.getOrDefault(message, -10) >= 10) {
			msg_ts.put(message, timestamp);
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(2, "bar"));
		System.out.println(logger.shouldPrintMessage(3, "foo"));
		System.out.println(logger.shouldPrintMessage(8, "bar"));
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(10, "foo"));
		System.out.println(logger.shouldPrintMessage(11, "foo"));
	}

}
