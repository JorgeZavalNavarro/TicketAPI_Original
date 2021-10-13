package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

import org.joda.time.Period;

public class CACategoryList extends CAResponse {

	private ArrayList<CACategory> categories;
	
	public CACategoryList(Boolean status, Period time, String error, int total) {
		super(status, time, error, total);
	}

	public CACategoryList(Boolean status, Period time, String error, String mssg, int total, ArrayList<CACategory> categories) {
		super(status, time, error, mssg, total);
		this.categories = categories;
	}
	
	public CACategoryList(Boolean status, Period time, ArrayList<CACategory> categories) {
		super(status, time);
		this.categories = categories;
	}
	
	public ArrayList<CACategory> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<CACategory> categories) {
		this.categories = categories;
	}	
}
