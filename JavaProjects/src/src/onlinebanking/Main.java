package src.onlinebanking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Account bheem = new Account(101, "Bheem", 89000, "Sathya@123");
		Account siri = new Account(103, "Siri", 250000, "Kushi@123");
		Account Rammi = new Account(104, "Ramesh", 100000, "Rammia@123");
		
		
		Map<Integer, Account> map = new HashMap<>();
		map.put(Rammi.getAccNum(), Rammi);
		map.put(bheem.getAccNum(), bheem);
		map.put(siri.getAccNum(), siri);
		
		
		Bank bank = new Bank(map);
		Scanner sc = new Scanner(System.in);
		System.out.println("---------Welcome to ICICI Bank-------\n Enter username");
		
		String username = sc.next();
		
		System.out.println("Enter Password");
		String password = sc.next();
		
		Account userAccount = bank.checkValidUser(username, password);
		if(userAccount == null) {
			System.out.println("Invalid user");
			sc.close();
			return;
		}	
			
			while(true) {
				System.out.println("---------Welcome to ICICI Bank------- \n 1. Check Account Balance \n 2. Deposit Amount \n 3. Cash Withdraw \n 4. Exit");
				int userInput = sc.nextInt();
				switch(userInput) {
					case 1: bank.checkBalance(userAccount.getAccNum()); break;
					case 2: 
						System.out.println("Enter amount to Deposit");
						double depositAmount = sc.nextDouble();
						bank.deposit(depositAmount, userAccount.getAccNum()); break;
					case 3: 
						System.out.println("Enter amount to withdraw");
						double withdrawAmount = sc.nextDouble();
						bank.withdraw(withdrawAmount, userAccount.getAccNum());break;
					case 4: sc.close(); 
					System.out.println("Thank you for choosing ICICI Bank, Visit Again!!");
					return;
					default:
			            System.out.println("Invalid option! Please select a valid option.");
				}
			}
	}

}
