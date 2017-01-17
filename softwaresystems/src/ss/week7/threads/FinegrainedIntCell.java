package ss.week7.threads;

import java.util.concurrent.locks.*;

public class FinegrainedIntCell implements IntCell {

	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	private boolean bool = false;
	private int value;

	@Override
	public void setValue(int val) {
		lock.lock();
		try {
			while (bool)
				notFull.await();
			bool = true;
			notEmpty.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		this.value = val;
	}

	@Override
	public int getValue() {
		lock.lock();
		try {
			while (!bool)
				notEmpty.await();
			bool = false;
			notFull.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return value;
	}

}
