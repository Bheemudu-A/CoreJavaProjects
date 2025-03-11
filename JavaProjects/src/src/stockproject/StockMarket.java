package src.stockproject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StockMarket {
	
	private final Map<String, Stock> stocks = new ConcurrentHashMap<>();
	private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	
	public void addStock(Stock stock) {
		stocks.put(stock.getName(), stock);
	}
	
	public void registerInvestor(String stockName, Investors investor) {
		Stock stock = stocks.get(stockName);
		if(stock != null) {
			stock.addInvestor(investor);
		}
	}
	
	 public void startPriceUpdates() {
	        executor.scheduleAtFixedRate(() -> {
	            for (Stock stock : stocks.values()) {
	                double change = (Math.random() - 0.5) * 10; // Random fluctuation
	                stock.setPrice(stock.getPrice() + change);
	            }
	        }, 0, 3, TimeUnit.SECONDS); // Updates every 3 seconds
	    }

	    public void stopPriceUpdates() {
	        executor.shutdown();
	    }

}
