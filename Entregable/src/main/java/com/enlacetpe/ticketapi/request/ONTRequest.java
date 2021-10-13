package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ONTRequest {
	

	private String numSerie;
	
	private String nameONT;
	
	@NotNull
	@Size(min=2,max=50)
	private String categoryId;
	
	private String[] description;
	
	private String summary;
	
	@NotNull
	@Size(min=1,max=50)
	private String type;
	
	@NotNull
	@Size(min=2,max=50)
	private String requestBy;
	
	private String initialDiagnostic;
	private String networkType;
	private String regCiuId;
	
	
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getNameONT() {
		return nameONT;
	}
	public void setNameONT(String nameONT) {
		this.nameONT = nameONT;
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
	public String getInitialDiagnostic() {
		return initialDiagnostic;
	}
	public void setInitialDiagnostic(String initialDiagnostic) {
		this.initialDiagnostic = initialDiagnostic;
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

}
