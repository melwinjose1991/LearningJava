package melwin.learning.System.MultiThreading;

import java.util.LinkedList;
import java.util.Random;

// ||PRODUCER CONSUMER|| ||LOCKS||

public class TestingLowLevelLocks {

	public static class Processor {
		private LinkedList<Integer> list = new LinkedList<>();
		private final int LIMIT = 10;
		private final Object lock = new Object();

		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (lock) {
					while (list.size() == LIMIT) {
						lock.wait();
					}
					list.add(value);

					System.out.println("P:" + value + "\tsize:" + list.size());
					value++;
					lock.notify();
				}
			}
		}

		public void consume() throws InterruptedException {
			Random random = new Random();
			while (true) {
				synchronized (lock) {
					while (list.size() == 0) {
						lock.wait();
					}

					int value = list.removeFirst();
					System.out.println("C:" + value + "\tsize: " + list.size());
					lock.notify();
				}
				Thread.sleep(random.nextInt(1000));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Processor processor = new Processor();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException ignored) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException ignored) {
				}
			}
		});

		t1.start();
		t2.start();
		Thread.sleep(3000);
		System.exit(0);
	}

}
