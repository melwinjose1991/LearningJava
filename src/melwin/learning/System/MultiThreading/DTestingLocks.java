package melwin.learning.System.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* ||synchronized object||
 * stackoverflow.com/questions/3047564/java-synchronized-method-lock-on-object-or-method
 */

public class DTestingLocks {

	private Random random = new Random();

	// If locked on the Class object, then it would
	// take double the time
	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	public List<Integer> list1 = new ArrayList<>();
	public List<Integer> list2 = new ArrayList<>();

	public void task1() {

		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}

	public void task2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}

	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			task1();
			task2();
		}
	}

	public static void main(String[] args) {
		DTestingLocks x = new DTestingLocks();

		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				x.process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				x.process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("time_taken: " + (end - start));
		System.out.println(x.list1.size() + " " + x.list2.size());
	}
}
