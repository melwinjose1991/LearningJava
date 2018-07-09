package melwin.learning.OOPS;

public class TestingAccessModifiersB {

	public static void main(String[] args) {
		TestingAccessModifiersA a = new TestingAccessModifiersA();

		System.out.println(a.a_public);

		System.out.println(a.a_protected);

		System.out.println(a.a_default);

		// System.out.println(a.a_private);

		// Protected members are different
		// from the Public members when
		// accessing them from other
		// packages.
	}

}
