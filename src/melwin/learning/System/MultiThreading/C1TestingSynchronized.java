package melwin.learning.System.MultiThreading;

public class C1TestingSynchronized {

	static class T2 implements Runnable {
		C1TestingSynchronized x;

		T2(C1TestingSynchronized x) {
			this.x = x;
		}

		public void run() {
			System.out.println(Thread.currentThread().getName() + " entering print1");
			x.print1();
			System.out.println(Thread.currentThread().getName() + " done with print1, entering for print2");
			x.print2();
			System.out.println(Thread.currentThread().getName() + " done with print2");
		}
	}

	static class T1 implements Runnable {
		C1TestingSynchronized x;

		T1(C1TestingSynchronized x) {
			this.x = x;
		}

		public void run() {
			System.out.println(Thread.currentThread().getName() + " entering print2");
			x.print2();
			System.out.println(Thread.currentThread().getName() + " done with print2, entering for print1");
			x.print1();
			System.out.println(Thread.currentThread().getName() + " done with print1");
		}
	}

	public synchronized void print1() {
		System.out.println(Thread.currentThread().getName() + " in print1");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " exiting print1");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void print2() {
		System.out.println(Thread.currentThread().getName() + " in print2");
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " exiting print2");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 'ALL' synchronized blocks synchronized on the same object can only have one
	// thread executing inside them at the same time.

	// To make it faster use synchronized on two objects
	// See 'TestingLocks.java'

	public static void main(String[] args) throws InterruptedException {
		C1TestingSynchronized x = new C1TestingSynchronized();
		Thread t1 = new Thread(new T1(x));
		Thread t2 = new Thread(new T2(x));
		t1.start();
		t2.start();

		t1.join();
		t2.join();

	}

}
