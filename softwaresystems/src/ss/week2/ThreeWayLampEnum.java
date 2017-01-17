package ss.week2;
 
public class ThreeWayLampEnum{
 
	//@ ensures Value == OFF || Value == MID || Value == LOW || Value == HIGH;
    public static enum Value {OFF, LOW, MID, HIGH};
    public Value value;
   
    //@ ensures getValue() == Value.OFF;
    /*@pure*/
    public ThreeWayLampEnum(){
        value = Value.OFF;
    }
	//@ ensures \result == Value.OFF || \result == Value.LOW || \result == Value.MID || \result == Value.HIGH;
    /*@pure*/
    public Value getValue(){
        return value;
    }
   
    /*@ensures
    \old(getValue() == Value.OFF) ==> getValue()==Value.LOW &&
    \old(getValue() == Value.LOW) ==> getValue()==Value.MID &&
    \old(getValue() == Value.MID) ==> getValue()==Value.HIGH &&
    \old(getValue() == Value.HIGH) ==> getValue()==Value.OFF;
    */
    public void increment(){
        switch(value){
            case OFF: value = Value.LOW;
            	break;
            case LOW: value = Value.MID;
            	break;
            case MID: value = Value.HIGH;
            	break;
            case HIGH: value= Value.OFF;
        }
    }
   
}