package src.stockproject;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private String name;
	private double price;
	private final List<Investors> investors = new ArrayList<>();
	
	
	public Stock(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		notifyInvestors();
	}	
	
	private void notifyInvestors() {
		for(Investors investor : investors) {
			investor.update(this);
		}
	}

	public void addInvestor(Investors investor) {
		investors.add(investor);
		
	}
	
}
