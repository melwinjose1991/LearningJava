package melwin.learning.OOPS;

import java.io.IOException;

class TestException {
	void track1_2() throws IOException { // declaring exception
		throw new java.io.IOException("device error");// checked exception
	}

	void track1_1() throws IOException {
		track1_2();
	}

	void track1() {
		try {
			track1_1();
		} catch (Exception e) {
			System.out.println("exception handeled");
		}
	}

	void track2_2() throws IOException {
		int a = 50 / 0; // unchecked exception
	}

	void track2_1() throws IOException {
		track2_2();
	}

	void track2() {
		track2_1();
	}

	public static void main(String args[]) throws Exception {
		TestException obj = new TestException();
		obj.track1();
		System.out.println("normal flow - 1");

		obj.track2();
		System.out.println("normal flow - 2");
	}
}