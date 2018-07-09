package melwin.learning.System.MultiThreading;

import java.util.Scanner;

public class HTestingWaitNotify {

	public static class Processor {

		public void produce() throws InterruptedException {
			System.out.println("@Produce::Outside sycn block");
			synchronized (this) {
				System.out.println("@Produce::Entered sycn block, going to wait()");
				wait(); // looses control over the block and goes silent
				System.out.println("@Produce::notified, Exiting sycn block");
			}
		}

		public void consume() throws InterruptedException {
			Scanner scanner = new Scanner(System.in);
			Thread.sleep(2000);
			System.out.println("@Consumer::done sleeping, Outside sycn block");
			synchronized (this) {
				System.out.println("@Consumer::Press a key");
				scanner.nextLine();
				System.out.println("@Consumer::Notify-ing()");
				notify();
				System.out.println("@Consumer::Notified(), sleeping");
				Thread.sleep(5000);
				System.out.println("@Consumer::done sleeping, Exiting sycn block");
				// NOTE: notify() just notifies the wait-ing thread, for it to
				// start executing, the notifiee should release the lock
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Processor processor = new Processor();
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
		t1.join();
		t2.join();
	}
}
