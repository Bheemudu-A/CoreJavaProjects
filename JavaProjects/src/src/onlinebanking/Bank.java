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
    
    public void transferAmount(double amount, int receiptsAccountNum, int sendersAccountNum) {
    	
    	if(bank.containsKey(receiptsAccountNum) && bank.containsKey(sendersAccountNum)) {
    		 Account receiver = bank.get(receiptsAccountNum);
    		 Account sender = bank.get(sendersAccountNum);
    		 if(sender.getBalance() >= amount) {
    			 sender.setBalance(sender.getBalance()-amount);
    			 receiver.setBalance(receiver.getBalance()+amount);
    			 System.out.println("successfully transfered amount of "+amount +" from "+sender.getName() +" to "+receiver.getName());
    			 System.out.println("current available balance's : "+sender.getName()+" has: "+sender.getBalance() +" & reciever "+receiver.getName()+" has: " +receiver.getBalance());
    		 }else {
    			 System.out.println("Insufficient balance! Available balance in sender's account: " + sender.getBalance());
    		 }
    	}else {
    		System.out.println("Invalid senders or receiptents account num");
    	}
    	
    }


    public void checkBalance(int accountNum) {
        if (bank.containsKey(accountNum)) {
            Account account = bank.get(accountNum);
            System.out.println("Available Balance is: " + account.getBalance());
        }
    }

    public Account checkValidUser(String userName, String password) {

        for (Account account : bank.values()) {
            if (account.getName().equals(userName) && account.getPassword().equals(password)) {
                System.out.println("Valid User!!");
                return account;
            }
        }
        System.out.println("Invalid username/password");
        return null;
    }

}
