package melwin.learning.System.MultiThreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestingBlockingQueue {
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	private static void producer() throws InterruptedException {
		Random random = new Random();
		while (true) {
			Thread.sleep(50);
			queue.put(random.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		while (true) {
			Thread.sleep(100);
			Integer value = queue.take();
			System.out.println(value + ":" + queue.size());
		}
	}

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException ignored) {
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
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
