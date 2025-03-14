package src.ticketbooking;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Bus(String travelsName, String from, String to, double fair, String duration) 
		List<Bus> buses = Arrays.asList(
				new Bus("TSRTC", "Hyderabad", "Kollapur", 260, "04:50:00", 2),
				new Bus("Ola Buses", "Hyderabad", "Kollapur", 350, "03:50:00", 3),
				new Bus("APS", "Hyderabad", "Srisailam", 450, "05:00:00", 2),
				new Bus("Private travels", "Hyderabad", "Srisailam", 800, "03:50:00", 1)
				);
		
		User bheem = new User("Bheemudu", "Hyderabad", "Kollapur", 2);
		User siri = new User("Koushika", "Hyderabad", "Srisailam",2);
		
		TicketBookingCounter counter = new TicketBookingCounter(buses);
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("---------------Welcome to TicketCounter---------- \n 1. Check Available Buses \n 2. Book Bus Based on price \n 3. Book Bus Based Minm Duration time \n 4. Exit");
			int choice = sc.nextInt();
			switch(choice) {
				case 1: 
				System.out.println(counter.checkAvailableBuses());
					break;
				case 2:
					counter.bookingBusBasedOnLowestPrice(bheem);
					break;
				case 3:
					counter.bookBusofFastReachable(siri);
					break;
				case 4:
					sc.close();
					System.out.println("Thankyou, Hope you visit again");
					return;
				default:
					System.out.println("Invalid Option");
			}
			
			
		}
		
		
		
	}

}
