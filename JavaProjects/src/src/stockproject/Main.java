package src.stockproject;

public class Main {
	
	public static void main(String[] args) {
		StockMarket market = new StockMarket();

        // Adding stocks
        Stock apple = new Stock("Apple", 150);
        Stock google = new Stock("Google", 2800);
        Stock amazon = new Stock("Amazon", 3400);

        market.addStock(apple);
        market.addStock(google);
        market.addStock(amazon);

        // Adding investors
        Investors alice = new Investors("Alice");
        Investors bob = new Investors("Bob");

        market.registerInvestor("Apple", alice);
        market.registerInvestor("Google", bob);

        // Start price updates
        market.startPriceUpdates();

        // Run simulation for 15 seconds, then stop
        try { Thread.sleep(15000); } catch (InterruptedException e) { e.printStackTrace(); }
        market.stopPriceUpdates();
    
	}

}
