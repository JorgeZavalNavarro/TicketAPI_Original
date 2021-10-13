package com.enlacetpe.ticketapi.response;

public class CAComment {
	
	private String CallReqId;
	private String description;
	private String dateInsert;
	private String tipo;
	
	
	public String getCallReqId() {
		return CallReqId;
	}
	public void setCallReqId(String callReqId) {
		CallReqId = callReqId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateInsert() {
		return dateInsert;
	}
	public void setDateInsert(String dateInsert) {
		this.dateInsert = dateInsert;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
