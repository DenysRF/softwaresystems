package ss.week3.pw;

public class TimedPassword extends ss.week2.hotel.Password {
	public long validTime;
	public long time;
	
	public TimedPassword(int x) {
		time = 1000*x;
		validTime = java.lang.System.currentTimeMillis() + time;
	}
	public long getValidTime() {
		return validTime;
	}
	public boolean isExpired() {
		return (java.lang.System.currentTimeMillis() >= validTime);
	}
	@Override
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(password) && acceptable(newpass)) {
			password = newpass;
			validTime = java.lang.System.currentTimeMillis() + time;
			return true;
		} else {
			return false;
		}
	}
}
