package com.enlacetpe.ticketapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CAOperationTicket{
	
	private String refNum;
	private String message;
	
	
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
	
}
