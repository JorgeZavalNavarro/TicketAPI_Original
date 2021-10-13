package com.enlacetpe.ticketapi.request;

public class SolicitudesRequest {

	private String tenant;
	private String requestedBy;
	private String zorgId;
	private String zpiso;
	private String zubicacion;
	private String zcontactoCte;
	private String category;
	private String goupId;
	private String summary;
	private String description;
	private String status;
	public String getTenant() {
		return tenant;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public String getZorgId() {
		return zorgId;
	}
	public String getZpiso() {
		return zpiso;
	}
	public String getZubicacion() {
		return zubicacion;
	}
	public String getZcontactoCte() {
		return zcontactoCte;
	}
	public String getCategory() {
		return category;
	}
	public String getGoupId() {
		return goupId;
	}
	public String getSummary() {
		return summary;
	}
	public String getDescription() {
		return description;
	}
	public String getStatus() {
		return status;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public void setZorgId(String zorgId) {
		this.zorgId = zorgId;
	}
	public void setZpiso(String zpiso) {
		this.zpiso = zpiso;
	}
	public void setZubicacion(String zubicacion) {
		this.zubicacion = zubicacion;
	}
	public void setZcontactoCte(String zcontactoCte) {
		this.zcontactoCte = zcontactoCte;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setGoupId(String goupId) {
		this.goupId = goupId;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
