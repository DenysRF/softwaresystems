package ss.week3.hotel;
import ss.week3.pw.*;

public class Password {
	public String factorypassword;
	public String password;
	public Checker checker;
	
	public Password(Checker checker) {
		factorypassword = checker.generatePassword();
		this.checker = checker;
		password = factorypassword;
	}
	public Password() {
		this(new BasicChecker());
	}

	
	public String factorypassword() {
		return factorypassword;
	}
 
 
    public boolean acceptable(String suggestion){
        return checker.acceptable(suggestion);
        
    }
    //@pure
    public boolean testWord(String test){
        if (test.equals(password)){
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