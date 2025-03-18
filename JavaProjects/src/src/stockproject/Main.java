package src.stockproject;

/*
 * 2. Stock Market Price Simulator
✅ Concepts Used: OOPS, Collections, Threads, Observer Pattern
💡 Description:

Create a system that simulates stock price fluctuations in real time.
Use the Observer Pattern to notify users when stock prices change.
Fetch stock prices from an API (or generate random values).
Implement buy/sell transactions and maintain a user's portfolio.
 */
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
