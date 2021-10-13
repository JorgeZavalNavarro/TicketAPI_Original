package com.enlacetpe.ticketapi.response;

import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CAStatus extends CAResponse {
	
	private Integer id;
	private Integer del;
	private String persid;
	private String sym;
	private String description;
	private String code;
	private Integer active;
	
	public CAStatus(boolean success, Period timeRes,String error, String code) {
		super.success = success;
		super.timeRes = timeRes;
		super.error = error;
		this.code = code;
	}
	
	public CAStatus() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getDel() {
		return del;
	}
	public void setDel(Integer del) {
		this.del = del;
	}
	public String getPersid() {
		return persid;
	}
	public void setPersid(String persid) {
		this.persid = persid;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	
	

}
