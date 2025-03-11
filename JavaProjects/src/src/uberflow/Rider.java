package src.uberflow;

public class Rider extends User{
	
	private String pickupLocation;
	private String dropLocation;
	
	public Rider(String name, String mobileNum) {
		super(name, mobileNum);
	}

	public void setRideDetails(String pickupLocation, String dropLocation) {
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
	}
	
	public String getPickupLocation() {
		return pickupLocation;
	}
	
	public String getDropLocation() {
		return dropLocation;
	}
	
	
	
}
