package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class RfcRequest {

	@NotNull
	public String rfc;

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	
}
