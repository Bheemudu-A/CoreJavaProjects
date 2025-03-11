package src.onlinebanking.chatgpt;

import java.io.*;
import java.util.*;


public class OnlineBankingApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Online Banking System!");
        Account userAccount = null;
        
        while (userAccount == null) {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    System.out.print("Set Password: ");
                    String password = sc.next();
                    userAccount = bank.createAccount(name, balance, password);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    System.out.print("Enter Password: ");
                    String pass = sc.next();
                    userAccount = bank.authenticate(accNum, pass);
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
        
        while (true) {
            System.out.println("\n---- Banking Menu ----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Balance: " + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's Account Number: ");
                    int recipientAccNum = sc.nextInt();
                    Account recipient = bank.getAccount(recipientAccNum);
                    if (recipient != null) {
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = sc.nextDouble();
                        userAccount.transfer(recipient, transferAmount);
                    } else {
                        System.out.println("Recipient account not found!");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using Online Banking!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}




class Account {
    private int accountNumber;
    private String holderName;
    private double balance;
    private String password;

    public Account(int accountNumber, String holderName, double balance, String password) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.password = password;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public boolean authenticate1(String password) { return this.password.equals(password); }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount!");
            return false;
        }
    }

    public boolean transfer(Account recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            System.out.println("Transfer successful to " + recipient.getHolderName());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", holderName=" + holderName + ", balance=" + balance + "]";
    }

	public boolean authenticate(String password2) {
		// TODO Auto-generated method stub
		return false;
	}
}

class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int accountCounter = 1000;

    public Account createAccount(String name, double initialBalance, String password) {
        int accountNumber = accountCounter++;
        Account newAccount = new Account(accountNumber, name, initialBalance, password);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully! Your Account Number: " + accountNumber);
        return newAccount;
    }

    public Account authenticate(int accountNumber, String password) {
        Account acc = accounts.get(accountNumber);
        if (acc != null && acc.authenticate1(password)) {
            System.out.println("Login successful!");
            return acc;
        }
        System.out.println("Invalid account number or password!");
        return null;
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}

