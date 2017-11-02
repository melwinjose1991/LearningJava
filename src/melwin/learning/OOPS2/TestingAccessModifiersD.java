package melwin.learning.OOPS2;

import java.util.ArrayList;

import melwin.learning.OOPS.*;

public class TestingAccessModifiersD extends TestingAccessModifiersA {

	public static void main(String[] args) {
		TestingAccessModifiersD d = new TestingAccessModifiersD();

		System.out.println(d.a_public);

		System.out.println(d.a_protected);

		// System.out.println(d.a_default);

		// System.out.println(d.a_private);

	}

	// Overriding experiment

	// @Override
	// protected void OLF1(String a){ ... }
	// Not overriding. When a method in a subclass has the same name,
	// same parameters or signature and same return type(or sub-type)
	// as a method in its super-class, then the method in the subclass
	// is said to override the method in the super-class.

	// This is not overriding. Its a new function in the child.
	protected void OLF1(ArrayList<Integer> list) {
		System.out.println("OLF1");
	}
}
