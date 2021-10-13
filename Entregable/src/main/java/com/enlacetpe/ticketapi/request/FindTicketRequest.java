package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FindTicketRequest {

	@NotNull
	@Size(min=1, max=1)
	protected String type;
	
	@NotNull
	protected int year;
	
	@NotNull
	protected int month;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
}
