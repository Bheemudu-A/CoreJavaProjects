package src.atmsimulation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATM {

	Lock lock = new ReentrantLock();
	
	public void withDrawal(BankAccount account, double amount, String name) {
		lock.lock();	//manually acquiring lock
		try {
			if(account.getBankBalance() >= amount) {
				Thread.sleep(1000);
				account.debit(amount);
				System.out.println(name+" successfully withdrawn $: "+amount);
			}else {
				System.out.println(name+" insuffient funds to withdraw");
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
	}
	
}
