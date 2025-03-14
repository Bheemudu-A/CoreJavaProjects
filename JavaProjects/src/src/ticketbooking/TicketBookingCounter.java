package src.ticketbooking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TicketBookingCounter {
	
	private List<Bus> buses = new ArrayList<>();
	
	public TicketBookingCounter(List<Bus> buses) {
		this.buses=buses;
	}
	
	public List<Bus> checkAvailableBuses(){
		return buses;
		
	}

	public void bookingBusBasedOnLowestPrice(User user) {
		for(Bus bus: sortBusesBasedOnPrice()) {
			if(bus.getFrom().equals(user.getStartPoint()) && bus.getTo().equals(user.getDestination()) && user.getNoOfSeats()==bus.getAvailableSeats()) {				
				System.out.println("Congratulations "+user.getName()+" Bus is booked from: "+bus.toString());
				bus.setAvailableSeats(bus.getAvailableSeats()-user.getNoOfSeats());
				return;
			}
		}
		System.out.println("Sorry! no buses available");
	}
	
	public void bookBusofFastReachable(User user) {

		for(Bus bus: sortBusesBasedOnDuration()) {
			if(bus.getFrom().equals(user.getStartPoint()) &&
					bus.getTo().equals(user.getDestination()) && 
					user.getNoOfSeats()==bus.getAvailableSeats()) {
						System.out.println("Congratulations "+user.getName()+" Bus is booked from: "+bus.toString());
						bus.setAvailableSeats(bus.getAvailableSeats()-user.getNoOfSeats());
						return;
			}
		}
		System.out.println("Sorry! No buses available");
	}
	
	public List<Bus> sortBusesBasedOnPrice(){
		return buses.stream().sorted(Comparator.comparing(Bus::getFair)).collect(Collectors.toList());
	}
	
	public List<Bus> sortBusesBasedOnDuration(){
		return buses.stream().sorted(Comparator.comparing(Bus::getDuration)).collect(Collectors.toList()) ;
	}
	
}
