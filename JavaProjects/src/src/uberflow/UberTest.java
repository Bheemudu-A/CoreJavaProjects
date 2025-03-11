package src.uberflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import src.uberflow.*;

public class UberTest {
	
	private RideSharingSystem rideSharingSystem;
	private Driver driver1,driver2,driver3;
	private Rider rider;
	
	@Before
	public void preRequesties() {
		
		rideSharingSystem = new RideSharingSystem();
		
		 rider = new Rider("Bheem", "7075404891");
		
		 driver1 = new Driver("Akilesh", "14756878", "Car");
		 driver2 = new Driver("Manoj", "9856878", "Auto");
		 driver3 = new Driver("Akilesh", "856878", "Bike");
		
		 rideSharingSystem.addDriver(driver1);
		 rideSharingSystem.addDriver(driver2);
		 rideSharingSystem.addDriver(driver3);
		
	}
	
	
	@Test
	public void testNearestDriver_WhenAvailable() {
		Driver driver = rideSharingSystem.findNearestDriver("Car");
		assertNotNull(driver);
		System.out.println("driver : "+driver.getVehicleType());
		assertEquals("Car", driver.getVehicleType());
	}
	
	@Test
	public void testNearestDriver_WhenNotAvailable() {
		driver1.setAvailability(false);
		Driver driver = rideSharingSystem.findNearestDriver("Car");
		assertNull(driver);
	}
	
	
	@Test
	public void testBookRide_WhenDriverAvailable() {
		PricingStrategy pricingStrategy = new NormalPricing();
			
	
		
			rider.setRideDetails("New Hafeezpet", "Deloitte Towers");
			rideSharingSystem.bookRide(rider, "Car", 4.5, pricingStrategy);
			
			Driver driver = rideSharingSystem.findNearestDriver("Car");
			
			assertTrue(driver1.isAvailable());
			assertEquals("Akilesh", driver.getName());
	}
	
	
	@Test
	public void testBookRide_WhenDriverNotAvailable() {
		PricingStrategy pricingStrategy = new NormalPricing();
		
			driver1.setAvailability(false);
			rider.setRideDetails("New Hafeezpet", "Deloitte Towers");
			rideSharingSystem.bookRide(rider, "Car", 4.5, pricingStrategy);
			assertFalse(driver1.isAvailable());
	}
	
	@Test
	public void testNormalPricing() {
		PricingStrategy strategy = new NormalPricing();
		double fare = strategy.calculateFare(10);
		assertEquals(100.0, fare, 0.001);
	}
	
	
	

}
