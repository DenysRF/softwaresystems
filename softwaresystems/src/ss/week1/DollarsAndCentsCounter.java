package ss.week1;

public class DollarsAndCentsCounter {
	private int cents;
	
	public int dollars(){
		return cents / 100;
}

	public int cents(){
		return cents % 100;
	
}

public void add (int dollarsadd, int centadd){
	this.cents = cents + dollarsadd * 100 + centadd;
	}

	public void reset() {
		cents = 0;

	}

}