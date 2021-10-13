package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.Pattern;

public class ipRequest {
	
	@Pattern(regexp="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$",message="El formato de la ip es incorrecto")	
	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	

}
