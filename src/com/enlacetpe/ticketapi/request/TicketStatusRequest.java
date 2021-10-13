package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketStatusRequest extends FindTicketRequest {

	@NotNull
	@Size(min=1, max=255)
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
