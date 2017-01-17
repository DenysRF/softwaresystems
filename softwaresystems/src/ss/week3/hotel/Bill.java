package ss.week3.hotel;
import java.io.PrintStream;

public class Bill {
	
	private PrintStream theOutStream;
	private double price;
	
	public Bill (java.io.PrintStream theOutStream) {
		this.theOutStream = theOutStream;
		price = 0;
	}
	
	public static interface Item {
		double getAmount();
		String toString();
	}


	public void close() {
	 	theOutStream.printf("%nThe bill has been closed: %49s %16.2f %n",
	 	"The Total price of the bill: ", getSum());
	}
	
	public double getSum() {
		return price;
	}
	
	public void newItem(Bill.Item item) {
		if (item != null) {
			price = item.getAmount() + price;
			theOutStream.printf("New item added: %-20s %n", item.toString());
		}
	}
}
		