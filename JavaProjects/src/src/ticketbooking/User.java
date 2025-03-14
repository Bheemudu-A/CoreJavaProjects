package src.ticketbooking;

public class User {
	
	private String name;
	private String startPoint;
	private String destination;
	private int noOfSeats;
	
	public User(String name, String startPoint, String destination, int noOfSeats) {
		super();
		this.name = name;
		this.startPoint = startPoint;
		this.destination = destination;
		this.noOfSeats=noOfSeats;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStartPoint() {
		return startPoint;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
}
