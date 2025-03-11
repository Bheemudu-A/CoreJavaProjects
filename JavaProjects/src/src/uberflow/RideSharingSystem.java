package src.uberflow;

import java.util.ArrayList;
import java.util.List;

public class RideSharingSystem {
	
	private List<Driver> drivers = new ArrayList<>();
	
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public Driver findNearestDriver(String vehicleType) {	
		for(Driver driver : drivers) {
			if(driver.isAvailable() && driver.getVehicleType().equalsIgnoreCase(vehicleType)) {
				return driver;
			}
		}
		return null;
	}
	
	public void bookRide(Rider rider, String vehicleType, double distance, PricingStrategy strategy) {
		Driver driver = findNearestDriver(vehicleType);
		if(driver != null) {
			driver.setAvailability(false);
			double fare = strategy.calculateFare(distance);
			
			System.out.println("Ride Booked Successfully!");
			System.out.println("Rider: "+rider.getName());
			System.out.println("Driver: "+driver.getName());
			System.out.println("pickup location: "+rider.getPickupLocation());
			System.out.println("fare: "+fare);
			
			driver.setAvailability(true);
		}else {
			System.out.println("No drivers available for "+vehicleType +" at the moment");
			
		}
	}

}
