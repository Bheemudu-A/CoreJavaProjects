package src.expenseproject;

import java.time.LocalDate;

public class Expense {

	private LocalDate date;
	private String category;
	private String description;
	private double amount;
	
	public Expense(LocalDate date, String category, String description, double amount) {
		this.date = date;
		this.category = category;
		this.description = description;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	
	public static Expense fromCSV(String line) {
		
		String[] parts = line.split(",");
		
		String[] splittedStr = new String[4];
		
		int i=0;
		for(String part : parts) {
			splittedStr[i++] = part.split("=")[1];
		}
		return new Expense(LocalDate.parse(splittedStr[0]), splittedStr[1], splittedStr[2], Double.parseDouble(splittedStr[3].substring(0, 6)));
		
	}

	@Override
	public String toString() {
		return "Expense [date=" + date + ", category=" + category + ", description=" + description + ", amount="
				+ amount + "]";
	}
}
