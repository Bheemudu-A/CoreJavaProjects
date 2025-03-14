package src.ticketbooking;

import java.time.LocalTime;

public class Bus {
	
	private String travelsName;
	private String from;
	private String to;
	private double fair;
	private LocalTime duration;
	private int availableSeats;
	
	
	public Bus(String travelsName, String from, String to, double fair, String duration, int availableSeats) {
		super();
		this.travelsName = travelsName;
		this.from = from;
		this.to = to;
		this.fair = fair;
		this.duration=LocalTime.parse(duration);
		this.availableSeats=availableSeats;
	}


	public String getTravelsName() {
		return travelsName;
	}


	public void setTravelsName(String travelsName) {
		this.travelsName = travelsName;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public double getFair() {
		return fair;
	}


	public void setFair(double fair) {
		this.fair = fair;
	}
	
	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	@Override
	public String toString() {
		return "Bus [travelsName=" + travelsName + ", from=" + from + ", to=" + to + ", fair=" + fair + ", duration="
				+ duration + ", NoOfTickets=" + availableSeats + "]";
	}

	

}
