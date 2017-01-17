package ss.week2;

public class ThreeWayLamp {
	
	private int value;
	//@private invariant value >= 0 && value <= 3;
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MID = 2;
	public static final int HIGH = 3;
	public static final int MOD = 4;

	//@ensures getValue() >= 0 && getValue() <= 4;
	public ThreeWayLamp(){
		value = OFF;
	}

	
	//@ ensures \result == OFF || \result == LOW || \result == MID || \result == HIGH;
	/*@ pure */public int getValue(){
		return value;
	}
	
	/*@ensures
	  \old(getValue() == OFF) ==> getValue() == LOW &&
	  \old(getValue() == LOW) ==> getValue() == MID &&
	  \old(getValue() == MID) ==> getValue() == HIGH &&
	  \old(getValue() == HIGH) ==> getValue() == LOW;
	 */
	
	public void increment(){
		value = (value+1)%MOD;
	}
}	
