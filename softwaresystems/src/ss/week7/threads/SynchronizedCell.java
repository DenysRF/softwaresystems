package ss.week7.threads;

public class SynchronizedCell implements IntCell {
	private boolean isFull = false;
	private int value;
	
	@Override
	public synchronized void setValue(int valueArg) {
			while (isFull) {
				try {
					wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		isFull = true;
		
		this.value = valueArg;	
		
	}

	@Override
	public synchronized int getValue() {
		while (!isFull) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isFull = false;
		notify();
		return value;
	}

}
