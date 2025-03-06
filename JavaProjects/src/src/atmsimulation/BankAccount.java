package src.atmsimulation;

public class BankAccount {
	
	private double bankBalance;

	public BankAccount(int bankBalance) {
		this.bankBalance = bankBalance;
	}
	
	public synchronized double getBankBalance() {
		return bankBalance;
	}

	public synchronized void debit(double bankBalance) {
		this.bankBalance -= bankBalance;
	}
	
	

}
