package ss.week3.hotel;

public class Format {
	public static String printline(String text, double amount) {
		return String.format("%1$-20s %2$10.2f", text, amount);
		
	}
	public static void main(String[] args) {
		System.out.println(printline("text1", 1.00));
		System.out.println(printline("other text", -12.12));
		System.out.println(printline("something", 0.20));

	}

}
