package src.uberflow;

public class Driver extends User{
	
	private String vehicleType;
	private boolean isAvailable;
	
	
	public Driver(String driverName, String mobileNum, String vehicleType) {
		super(driverName, mobileNum);
		this.vehicleType = vehicleType;
		this.isAvailable = true;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void setAvailability(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	
	
	
}
