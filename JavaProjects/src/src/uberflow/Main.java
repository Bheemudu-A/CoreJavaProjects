package src.uberflow;

/*
 * Project moto is to build uber kind app
 * 
 * contains Rider(passenger), Driver, where rider books a ride of specific vehicleType to travel a distance, while booking she can view to total price
 * nearest Driver picks the ride, drops rider at destination & collects fare
 */
public class Main {
	
	public static void main(String[] args) {
		
		RideSharingSystem sharingSystem = new RideSharingSystem();
		
		
		Driver driver1 = new Driver("Akilesh", "14756878", "Car");
		Driver driver2 = new Driver("Manoj", "9856878", "Auto");
		Driver driver3 = new Driver("Akilesh", "856878", "Bike");
		
		sharingSystem.addDriver(driver1);
		sharingSystem.addDriver(driver2);
		sharingSystem.addDriver(driver3);
		
		Rider rider = new Rider("Bheem", "7086889829");
		
		rider.setRideDetails("New Hafeezpet", "Deloite Towers");
		
		PricingStrategy normalpricing = new NormalPricing();
		
		sharingSystem.bookRide(rider, "Car", 4.5, normalpricing);
		
	}

}
