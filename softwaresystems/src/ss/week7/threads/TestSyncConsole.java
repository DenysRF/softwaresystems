package ss.week7.threads;

import java.util.concurrent.locks.*;

public class TestSyncConsole extends Thread {
	final Lock lock = new ReentrantLock();

	public TestSyncConsole(String thread) {
		super(thread);
	}

	private synchronized void sum() {
		lock.lock();

		int first = SyncConsole.readInt(getName() + " enter number 1: ");
		int second = SyncConsole.readInt(getName() + " enter number 2: ");
		SyncConsole.println(getName() + ": " + first + " + " + second + " = " + "" + (first + second));

		lock.unlock();

	}

	@Override
	public void run() {
		sum();
	}

	public static void main(String[] args) {

		Thread one = new TestSyncConsole("Thread A");
		Thread two = new TestSyncConsole("Thread B");

		one.start();
		two.start();

	}

}
