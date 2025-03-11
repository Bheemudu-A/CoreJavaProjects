package src.uberflow;


/*
 * this follows strategy design pattern
 */
public interface PricingStrategy {
	double calculateFare(double distance);
}

 class NormalPricing implements PricingStrategy{

	@Override
	public double calculateFare(double distance) {
		return 10*distance;
	}
	
}

class SurgePricing implements PricingStrategy{

	@Override
	public double calculateFare(double distance) {		
		return distance*15;
	}
	
}

class poolPricing implements PricingStrategy{

	@Override
	public double calculateFare(double distance) {
		return distance*7;
	}
	
}
