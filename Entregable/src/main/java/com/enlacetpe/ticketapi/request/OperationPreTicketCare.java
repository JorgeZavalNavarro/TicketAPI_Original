package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OperationPreTicketCare {
	
	@NotNull 
	@Size(min=1, max=255)
	private String requestBy;
	
	@NotNull
	@Size(min=1, max=255)
	private String peackId; 
	
	@NotNull
	@Size(min=1, max=255)
	private String categoryId;
	
	@NotNull
	@Size(min=1, max=255)
	private String group; 
	
	@NotNull
	@Size(min=1, max=255)
	private String[] description; 
	
	@NotNull 
	@Size(min=1, max=255)
	private String type;
	
	@NotNull
	private String summary; 
	
	private String diagInitial; 
	 
	private String networkType; 
	
	private String regCiuId; 
	
	private String organization;
	
	private String url; 

	public String getPeackId() {
		return peackId;
	}

	public void setPeackId(String peackId) {
		this.peackId = peackId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}


	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequestBy() {
		return requestBy;
	}

	public void setRequestBy(String requestBy) {
		this.requestBy = requestBy;
	}

	public String getDiagInitial() {
		return diagInitial;
	}

	public void setDiagInitial(String diagInitial) {
		this.diagInitial = diagInitial;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public String getRegCiuId() {
		return regCiuId;
	}

	public void setRegCiuId(String regCiuId) {
		this.regCiuId = regCiuId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	
	

}
