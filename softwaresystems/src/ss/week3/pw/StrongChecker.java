package ss.week3.pw;

public class StrongChecker extends BasicChecker {

	private String genpassword = "password1";

	@Override
	public boolean acceptable(String password) {
		return super.acceptable(password) && (Character.isLetter(password.charAt(0)) 
				&& Character.isDigit(password.charAt(-1)));
		
	}
	@Override
	public String generatePassword() {
		return genpassword;
	}	
		

}
