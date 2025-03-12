package src.expenseproject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseManager {

	List<Expense>  expense = null;
	private static String File_Path = "expenses.csv";

	public ExpenseManager() {
		expense = new ArrayList<>();
		loadExpenses();
	}

	public void addExpense(Expense exp) {
		expense.add(exp);
		saveExpense();
	}
	
	public List<Expense> getAllExpenses(){
		return expense;
	}

	public List<Expense> filterByCategory(String category){
		return expense.stream().filter(i -> i.getCategory().equals(category)).collect(Collectors.toList());
	}

	public List<Expense> sortByAmount(){
		return expense.stream().sorted(Comparator.comparing(Expense::getAmount)).collect(Collectors.toList());
	}

	
	public void saveExpense() {
		try(BufferedWriter writer = Files.newBufferedWriter(Paths.get(File_Path))){		//try with resource
			for(Expense exp : expense) {
				writer.write(exp.toString());
				writer.newLine();
			}

		} catch (IOException e) {	
			System.out.println("Error while saving expenses: "+e.getMessage());				
		}
	}


	private void loadExpenses() {		
		try {
			List<String> lines = Files.readAllLines(Paths.get(File_Path));	
			System.out.println("lines : "+lines);
			expense = lines.stream().map(Expense::fromCSV).collect(Collectors.toList());
		/*	expense = lines.stream().map(
							line -> {
								return Expense.fromCSV(line);
							})
			.collect(Collectors.toList());*/
			
		} catch (IOException e) {
			System.out.println("No expense found: "+e.getMessage());
		 }
	}

}
