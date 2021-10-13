package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Period;

public class CARfcList{


	private String refNum;
	private ArrayList<CARfc> rfclist;
	private boolean success;
	private String error;
	private String mssg;

	public CARfcList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CARfcList(ArrayList<CARfc> rfclist) {
		super();
		this.rfclist = rfclist;
	}

	public CARfcList(Boolean success, Period period, String error, String mssg, String refNum, int size, ArrayList<CARfc> rfclist2) {
		// TODO Auto-generated constructor stub
		super();
		this.refNum = refNum;
		this.rfclist = rfclist2;
		this.success = success;
		this.mssg = mssg;
		this.error = error;
	}

	public CARfcList(Boolean success, Period period, String error, String mssg,String refNum, int size, List<CARfc> rfclist2) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<CARfc> getRfclist() {
		return rfclist;
	}

	public void setRfclist(ArrayList<CARfc> rfclist) {
		this.rfclist = rfclist;
	}
	
	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMssg() {
		return mssg;
	}

	public void setMssg(String mssg) {
		this.mssg = mssg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CARfcList [refNum=");
		builder.append(refNum);
		builder.append(", rfclist=");
		builder.append(rfclist);
		builder.append(", success=");
		builder.append(success);
		builder.append(", error=");
		builder.append(error);
		builder.append(", mssg=");
		builder.append(mssg);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
