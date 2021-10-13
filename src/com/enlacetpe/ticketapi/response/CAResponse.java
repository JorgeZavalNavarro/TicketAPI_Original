package com.enlacetpe.ticketapi.response;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CAResponse {

	protected boolean success;
	protected Period timeRes;
	protected String error;
	protected String mssg;
	protected int total;
	protected String code;
	
	public CAResponse() {
		super();
	}
	
	public CAResponse(boolean success, String error,String mssg, String code) {
		this.success = success;
		this.error = error;
		this.mssg = mssg;
		this.code = code;
	}

	public CAResponse(boolean success, String error) {
		this.success = success;
		this.error = error;
	}
	
	public CAResponse(boolean success, Period timeRes, String error) {
		this.success = success;
		this.timeRes = timeRes;
		this.error = error;
	}
	
	

	public CAResponse(boolean success, Period timeRes, String error, int total) {
		this.success = success;
		this.timeRes = timeRes;
		this.error = error;
		this.total = total;
	}
	
	public CAResponse(boolean success, Period timeRes, String error, String mssg) {
		super();
		this.success = success;
		this.timeRes = timeRes;
		this.error = error;
		this.mssg = mssg;
	}
	
	public CAResponse(boolean success, Period timeRes, String error, String mssg,String code) {
		super();
		this.success = success;
		this.timeRes = timeRes;
		this.error = error;
		this.mssg = mssg;
		this.code = code;
	}

	public CAResponse(boolean success, Period timeRes, String error, String mssg, int total) {
		this.success = success;
		this.timeRes = timeRes;
		this.error = error;
		this.total = total;
		this.mssg = mssg;
	}
	
	public CAResponse(boolean success, Period timeRes) {
		this.success = success;
		this.timeRes = timeRes;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean getSuccess() {
		return success;
	}
	public String getTimeRes() {
		PeriodFormatter format = 
				new PeriodFormatterBuilder()
			    .appendSeconds()
			    .appendSuffix(" s", " s")
			    .appendSeparator(", ")
			    .appendMillis()
			    .appendSuffix(" ms", " ms")			    
			    .toFormatter();
		return timeRes.toString(format);
	}
	public void setTimeRes(Period timeRes) {
		this.timeRes = timeRes;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getError() {
		return error;
	}
	public String getMssg() {
		return mssg;
	}
	public void setMssg(String mssg) {
		this.mssg = mssg;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
