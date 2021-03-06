package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketOrganizationRequest extends FindTicketRequest {
	
	@NotNull
	@Size(min=1, max=255)
	private String organization;

	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
}
