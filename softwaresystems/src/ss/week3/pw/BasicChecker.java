package ss.week3.pw;

public class BasicChecker implements Checker {
	public String genpassword = "password1";
	
	public String generatePassword() {
		return genpassword;
}
	@Override
	public boolean acceptable(String password) {
		return password.length() >= 6 && !password.contains(" "); 
	}

}
