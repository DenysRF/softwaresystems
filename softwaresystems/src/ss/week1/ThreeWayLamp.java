package ss.week1;

public class ThreeWayLamp {
	private int value;
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MID = 2;
	public static final int HIGH = 3;
	public static final int MOD = 4;
	public ThreeWayLamp(){
		value = OFF;
	}
	public int getValue(){
		return value;
	}
	public void increment(){
		value = (value+1)%MOD;
	}
}	
