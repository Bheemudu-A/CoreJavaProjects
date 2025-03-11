package src.onlinebanking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
	
	Map<Integer, Account> bank = null;
	
	public Bank(Map<Integer, Account> map) {
		bank = new HashMap<>(map);
	}

	public void deposit(double amount, int accountNum) {
	    if (amount <= 0) {
	        System.out.println("Deposit amount must be greater than zero!");
	        return;
	    }

	    if (bank.containsKey(accountNum)) {    
	        Account account = bank.get(accountNum);
	        account.setBalance(account.getBalance() + amount);
	        System.out.println("Successfully deposited: " + amount);
	        System.out.println("Updated account balance: " + account.getBalance());
	    } else {
	        System.out.println("Account not found!");
	    }
	}

	
	public void withdraw(double amount, int accountNum) {
	    if (bank.containsKey(accountNum)) {
	        Account account = bank.get(accountNum);
	        if (account.getBalance() >= amount) { // Check if balance is sufficient
	            account.setBalance(account.getBalance() - amount);
	            System.out.println("Successfully withdrawn amount: " + amount);
	            System.out.println("After withdrawal, available balance is: " + account.getBalance());
	        } else {
	            System.out.println("Insufficient balance! Available balance: " + account.getBalance());
	        }
	    } else {
	        System.out.println("Account not found!");
	    }
	}

	
	public void checkBalance(int accountNum) {
		if(bank.containsKey(accountNum)) {
			Account account = bank.get(accountNum);
			System.out.println("Available Balance is: "+account.getBalance());
		}
	}
	
	public Account checkValidUser(String userName, String password) {
		
		for(Account account : bank.values()) {	
			if(account.getName().equals(userName) && account.getPassword().equals(password)) {
				System.out.println("Valid User!!");
				return account;
			}
		}
		System.out.println("Invalid username/password");
		return null;
	}

}
