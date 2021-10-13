package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class CategoryRequest {
	
	@NotNull
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	
	
	
}
