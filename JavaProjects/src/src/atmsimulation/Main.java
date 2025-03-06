package src.atmsimulation;

public class Main {
	
	public static void main(String[] args) {
		
		BankAccount account = new BankAccount(5000);
		
		ATM atm = new ATM();
		
	
		
		Thread t1 = new Thread(new User("Bheem", atm, account, 2000));
		Thread t2 = new Thread(new User("Siri", atm, account, 6000));
		Thread t3 = new Thread(new User("Koushika", atm, account, 3000));
		Thread t4 = new Thread(new User("Ramesh", atm, account, 500));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
