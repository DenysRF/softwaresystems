package ss.week7.threads;

//import java.util.Scanner;

public class TestConsole extends Thread {
	public TestConsole(String thread) {
		super(thread);
	}

	private void sum() {

		int first = Console.readInt(getName() + " enter number 1: ");
		int second = Console.readInt(getName() + " enter number 2: ");

		Console.println(getName() + ": " + first + " + " + second + " = " +  "" + (first + second));
	}

	@Override
	public void run() {
		sum();
	}


	public static void main(String[] args) {
		Thread one = new TestConsole("Thread A");
		Thread two = new TestConsole("Thread B");

		one.start();
		two.start();

	}

}
