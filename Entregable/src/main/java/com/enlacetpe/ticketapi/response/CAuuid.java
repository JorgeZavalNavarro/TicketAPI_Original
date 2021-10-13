package com.enlacetpe.ticketapi.response;

import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CAuuid extends CAResponse{
	
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public CAuuid(boolean success, Period timeRes,String error, String uuid) {
		super.success = success;
		super.timeRes = timeRes;
		super.error = error;
		this.uuid = uuid;
	}

}
