package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

import org.joda.time.Period;

public class CATicketList extends CAResponse {

	private ArrayList<CATicket> tickets;
	
	public CATicketList() {}

	public CATicketList(Boolean status, Period time, String error, int total) {
		super(status, time, error, total);
	}
	
	public CATicketList(Boolean status, Period time, String error, String mssg, int total) {
		super(status, time, error, mssg, total);
	}

	public CATicketList(Boolean status, Period time, String error, String mssg, int total, ArrayList<CATicket> tickets) {
		super(status, time, error, mssg, total);
		this.tickets = tickets;
	}
	
	public CATicketList(Boolean status, Period time, ArrayList<CATicket> tickets) {
		super(status, time);
		this.tickets = tickets;
	}
	
	public ArrayList<CATicket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<CATicket> tickets) {
		this.tickets = tickets;
	}
}
