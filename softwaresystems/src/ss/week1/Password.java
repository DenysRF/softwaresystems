package ss.week1;

public class Password {
	public static final String INITIAL = "yoloswag";
	public String password;
	
	public Password(){
		password = INITIAL;
	}	
 
	public boolean acceptable(String suggestion){
		if (suggestion.contains(" ")){
			return false;
		}
		if (suggestion.length() < 6){
			return false;
		}
		return true;
	}
	public boolean testWord(String test){
		if (test.equals (password)){
			return true;
		}
		return false;
		}
	public boolean setWord(String oldpass, String newpass) { 
		
		if (testWord(oldpass) && acceptable(newpass)){
			password = newpass;
			return true;
		}
		return false;
	}
}
