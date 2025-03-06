package src.atmsimulation;

public class User implements Runnable{
	
	private String name;
	private ATM atm;
	private BankAccount account;
	private double amount;
	
	
	public User(String name, ATM atm, BankAccount account, double amount) {
		super();
		this.name = name;
		this.atm = atm;
		this.account = account;
		this.amount = amount;
	}
	
	
	@Override
	public void run() {
		atm.withDrawal(account, amount, name);
	}

}
