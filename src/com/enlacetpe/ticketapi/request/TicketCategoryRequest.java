package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TicketCategoryRequest extends FindTicketRequest {
	
	@NotNull
	@Size(min=1, max=255)
	private String category;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
