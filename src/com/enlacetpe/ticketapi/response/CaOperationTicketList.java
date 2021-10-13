package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

import org.joda.time.Period;

public class CaOperationTicketList extends CAResponse{
	
private ArrayList<CAOperationTicket> ticket;
	
	public CaOperationTicketList(Boolean status, Period time, String error, int total) {
		super(status, time, error, total);
	}

	public CaOperationTicketList(Boolean status, Period time, String error, String mssg, int total, ArrayList<CAOperationTicket> ticket) {
		super(status, time, error, mssg, total);
		this.ticket = ticket;
	}
	
	public CaOperationTicketList(Boolean status, Period time, ArrayList<CAOperationTicket> ticket) {
		super(status, time);
		this.ticket = ticket;
	}

	public ArrayList<CAOperationTicket> getTicket() {
		return ticket;
	}

	public void setTicket(ArrayList<CAOperationTicket> ticket) {
		this.ticket = ticket;
	}
	
	

}
