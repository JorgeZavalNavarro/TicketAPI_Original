package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketGroupRequest {
	
	@NotNull
	@Size(min=1, max=255)
	private String group;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	

}
