package melwin.learning.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

/*
 * Base Code : https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
 */

public class ObserverPattern {

	public static class Subject {

		private List<Observer> observers = new ArrayList<Observer>();
		private int state;

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
			notifyAllObservers();
		}

		public void attach(Observer observer) {
			observers.add(observer);
		}

		public void notifyAllObservers() {
			for (Observer observer : observers) {
				observer.update();
			}
		}
	}

	private static abstract class Observer {
		protected Subject subject;

		public abstract void update();
	}

	public static class BinaryObserver extends Observer {

		public BinaryObserver(Subject subject) {
			this.subject = subject;
			this.subject.attach(this);
		}

		@Override
		public void update() {
			System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
		}
	}

	public static class OctalObserver extends Observer {

		public OctalObserver(Subject subject) {
			this.subject = subject;
			this.subject.attach(this);
		}

		@Override
		public void update() {
			System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
		}
	}

	public static class HexaObserver extends Observer {

		public HexaObserver(Subject subject) {
			this.subject = subject;
			this.subject.attach(this);
		}

		@Override
		public void update() {
			System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
		}
	}

	public static void main(String[] args) {
		Subject subject = new Subject();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("\nSecond state change: 10");
		subject.setState(10);
	}

}
