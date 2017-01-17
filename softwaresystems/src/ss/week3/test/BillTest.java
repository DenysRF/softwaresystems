package ss.week3.test;
import org.junit.*;

import ss.week3.hotel.Bill;
import ss.week3.hotel.Format;

import static org.junit.Assert.*;

public class BillTest {
	private Bill bill;
	
	@Before
	public void setUp() {
		bill = new Bill(System.out);
	}
	
	@Test
	public void testBill() {
		assertTrue(bill.getSum() == 0);
	}
	
	@Test
	public static void main (String[] args) {
		System.out.println(Format.printline("text", 8.00));
	}
	
}
