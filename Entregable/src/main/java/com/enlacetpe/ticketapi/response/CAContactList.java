package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

import org.joda.time.Period;

public class CAContactList extends CAResponse {

	private ArrayList<CAContact> contacts;

	public CAContactList(Boolean status, Period time, String error, int total) {
		super(status, time, error, total);
	}
	
	public CAContactList(Boolean status, Period time, String error, String mssg, int total) {
		super(status, time, error, mssg, total);
	}
	
	public CAContactList(Boolean status, Period time, String error, String mssg, int total, ArrayList<CAContact> contacts) {
		super(status, time, error, mssg, total);
		this.contacts = contacts;
	}
	
	public CAContactList(Boolean status, Period time, ArrayList<CAContact> contacts) {
		super(status, time);
		this.contacts = contacts;
	}
	
	public ArrayList<CAContact> getContacts() {
		return contacts;
	}
	public void setContacts(ArrayList<CAContact> contacts) {
		this.contacts = contacts;
	}	
}
