package com.enlacetpe.ticketapi.request;

public class OperationTicketSMCRequest {
	

	private String requestedBy;
	private String peack;
	private String categoryId;
	private String desc;
	private String Type;
	
	
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public String getPeack() {
		return peack;
	}
	public void setPeack(String peack) {
		this.peack = peack;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	
	

}
