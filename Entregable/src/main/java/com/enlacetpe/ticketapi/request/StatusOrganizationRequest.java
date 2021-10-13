package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class StatusOrganizationRequest {

	@NotNull
	public String status;

	@NotNull
	public String organization;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
