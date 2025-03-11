package src.uberflow;

/**
 * This flow is of Factory Design pattern, to initialize one of the subclass object based on client input
 */
public class VehicleFactory {

	public static Vehicle getVehicle(String type, String plateNumber) {
		switch(type.toLowerCase()) {
		case "car":
			return new Car(plateNumber);
		case "bike":
			return new Bike(plateNumber);
		case "Auto":
			return new Auto(plateNumber);
		default:
			throw new IllegalArgumentException("Invalid vehicle Type");
		}
	}	
}


abstract class Vehicle{
	protected String plateNumber;

	public Vehicle(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public abstract String getVehicleType();
}

class Bike extends Vehicle{

	public Bike(String plateNumber) {
		super(plateNumber);
	}

	@Override
	public String getVehicleType() {
		return "Bike";
	}
}

class Car extends Vehicle{

	public Car(String plateNumber) {
		super(plateNumber);
	}

	@Override
	public String getVehicleType() {
		return "Car";
	}
}

class Auto extends Vehicle{

	public Auto(String plateNumber) {
		super(plateNumber);
	}

	@Override
	public String getVehicleType() {
		return "Auto";
	}
	
}
