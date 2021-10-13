package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketRefNumRequest {
	
	@NotNull
	@Size(min=1, max=255)
	private String refNum;
	
	@NotNull
	@Size(min=1, max=1)
	private String type;

	
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
