package src.stockproject;

public class Investors {

	private String name;
	
	public Investors(String name) {
		this.name = name;
	}
	
	public void update(Stock stock) {
		System.out.println("[Investor: "+name+" ] Stock "+stock.getName()+" updated to $ "+stock.getPrice());
	}

}
