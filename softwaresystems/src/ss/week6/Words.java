package ss.week6;
import java.util.Scanner;

public class Words {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
			
		System.out.println("Type a sentence:");
		
		int i = 1;
		while (in.hasNext()) {
			if (in.hasNext("end")) {
				break;
				}
			System.out.println("Word " + i + ": " + in.next());
			i++;
		}
		
		System.out.println("End of programme.");
		
		in.close();
		}
}
