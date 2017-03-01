package melwin.learning.System.MultiThreading;

// ||THREADLOCAL||

public class TestingThreadLocal {

	public static class AccessPoint {
		private static ThreadLocal<Integer> id = new ThreadLocal<Integer>() {
			protected Integer initialValue() {
				return (Integer) ((int) (Math.random() * 100));
			}
		};

		public static Integer getID() {
			return id.get();
		}

	}

	public static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(AccessPoint.getID());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}

}
