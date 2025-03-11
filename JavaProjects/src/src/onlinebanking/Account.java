package src.onlinebanking;

public class Account {
	
	private int accNum;
	private String name;
	private double balance;
	private String password;
	
	public Account(int accNum, String name, double balance, String password) {
		super();
		this.accNum = accNum;
		this.name = name;
		this.balance = balance;
		this.password = password;
	}

	public int getAccNum() {
		return accNum;
	}
	
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", name=" + name + ", balance=" + balance + "]";
	}
}
