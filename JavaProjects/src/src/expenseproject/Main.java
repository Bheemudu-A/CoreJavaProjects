package src.expenseproject;

import java.time.LocalDate;
import java.util.Scanner;
/*
 * 5. Expense Tracker Application (Standalone)
✅ Concepts Used: OOPS, Collections, File Handling, Java Streams
💡 Description:

Develop a personal finance tracker where users can add expenses, view spending trends, and categorize transactions.
Store data using CSV files or a lightweight database like H2.
Implement filtering and sorting using Java Streams.
 */
public class Main {
	
	public static void main(String[] args) {
		
		ExpenseManager expManager = new ExpenseManager();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("--------Expense Tracker----------- \n 1. Add Expense \n 2. View all Expenses \n 3. Filter By Category \n 4. Sort Expenses by Amount \n 5. Exit");
		//	sc.nextLine();
			
			int option = sc.nextInt();
			
			switch(option) {
		
				 case 1: 
					  System.out.println("Enter category");
					  sc.nextLine();
					 String category =  sc.nextLine();
					  System.out.println("Enter description");
					 String description = sc.nextLine();
					  System.out.print("enter amount");
					 double amount = sc.nextDouble();
					 expManager.addExpense(new Expense(LocalDate.now(), category, description, amount));
					 break;
				 case 2:
					System.out.println("All Expenses: "+ expManager.getAllExpenses());
					 break;
				 case 3:
					 System.out.println("Enter Category to fileter");
					 String categoryFil = sc.next();
					System.out.println(expManager.filterByCategory(categoryFil));
					 break;
				 case 4:
					System.out.println(expManager.sortByAmount());
					 break;
				 case 5:
					 System.out.println("Thank You Visit Again!!");
					 sc.close();
					 return;
				default:
					System.out.println("Invalid Choice");
					 
			}
			
		}
		
	}

}
