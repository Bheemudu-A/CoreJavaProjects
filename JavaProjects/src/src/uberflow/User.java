package src.uberflow;

public class User {
	
	private String name;
	private String mobileNum;
	
	public User(String name, String mobileNum) {
		this.name = name;
		this.mobileNum = mobileNum;
	}

	public String getName() {
		return name;
	}

	public String getMobileNum() {
		return mobileNum;
	}
}
