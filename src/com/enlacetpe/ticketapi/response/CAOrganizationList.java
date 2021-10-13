package com.enlacetpe.ticketapi.response;

import java.util.List;

import org.joda.time.Period;

public class CAOrganizationList extends CAResponse{
	
	private List<CAOrganization> clientes;

	public CAOrganizationList(boolean success, Period timeRes, String error,List<CAOrganization> clientes) {
		super(success, timeRes, error);
		this.clientes = clientes;
	}

	public List<CAOrganization> getClientes() {
		return clientes;
	}

	public void setClientes(List<CAOrganization> clientes) {
		this.clientes = clientes;
	}
	
	

}
