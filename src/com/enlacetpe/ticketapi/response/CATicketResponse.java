package com.enlacetpe.ticketapi.response;

import org.joda.time.Period;

public class CATicketResponse extends CAResponse {

	private String refNum;
	private String summary;
	private String status;

	public CATicketResponse(boolean success, Period timeRes, String error, String refNum, String summary,
			String status) {
		super.success = success;
		super.timeRes = timeRes;
		super.error = error;
		this.refNum = refNum;
		this.summary = summary;
		this.status = status;
	}

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
