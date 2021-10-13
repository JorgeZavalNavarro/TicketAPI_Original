package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OperationTicketRequest {
	
	@NotNull
	@Size(min=1, max=255)
	private String peack;
	
	@NotNull
	@Size(min=1, max=255)
	private String categoryId;
	
	@NotNull
	@Size(min=1, max=255)
	private String[] desc;
	
	@NotNull
	private String summary;
	
	@NotNull 
	@Size(min=1, max=255)
	private String type;
	
	@NotNull 
	@Size(min=1, max=255)
	private String requestBy;
	
	@NotNull 
	@Size(min=1, max=255)
	private String diagInitial;
	
	@NotNull 
	@Size(min=1, max=255)
	private String networkType;
	
	private String regCiuId;
	
	private String organization;
	
	private String idItsm;
	
	private String group;
	
	private String url;
	

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
	
	public String[] getDesc() {
		return desc;
	}

	public void setDesc(String[] desc) {
		this.desc = desc;
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
	
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getIdItsm() {
		return idItsm;
	}

	public void setIdItsm(String idItsm) {
		this.idItsm = idItsm;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
