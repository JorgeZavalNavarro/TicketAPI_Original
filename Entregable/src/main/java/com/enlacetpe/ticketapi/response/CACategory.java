package com.enlacetpe.ticketapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CACategory{

    private String id;
    private String sym;
    private String description;
    private String tenant;
    private String ssSym;
    private String lastModDt;
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSym() {
		return sym;
	}
	public void setSym(String sym) {
		this.sym = sym;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getSsSym() {
		return ssSym;
	}
	public void setSsSym(String ssSym) {
		this.ssSym = ssSym;
	}
	public String getLastModDt() {
		return lastModDt;
	}
	public void setLastModDt(String lastModDt) {
		this.lastModDt = lastModDt;
	}
	
	
}
