package melwin.learning.System.MultiThreading;

// volatile : http://www.ibm.com/developerworks/java/library/j-jtp06197/index.html

public class TestingVolatile {
	
	private static volatile int testValue;
	
	static class ExampleThread extends Thread {

		public ExampleThread(String str) {
			super(str);
		}

		public void run() {
			for (int i = 0; i < 3; i++) {
				try {
					System.out.println(getName() + " : " + i);
					if (getName().equals("Thread 1")) {
						testValue = 10;
					}
					if (getName().equals("Thread 2") && testValue == 10) {
						System.out.println("Test Value : " + testValue);
					}
					Thread.sleep(1000);
				} catch (InterruptedException exception) {
					exception.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		new ExampleThread("Thread 1").start();
		new ExampleThread("Thread 2").start();
	}
}
