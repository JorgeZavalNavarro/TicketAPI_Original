package com.enlacetpe.ticketapi.response;

import java.util.List;

import org.joda.time.Period;

public class CATicketByNameCIList extends CAResponse{
	
	private List<CATicketByNameCI> datos;
	
	public CATicketByNameCIList(boolean success, Period timeRes, List<CATicketByNameCI> datos) {
		super(success, timeRes);
		this.datos = datos;
	}

	public List<CATicketByNameCI> getDatos() {
		return datos;
	}

	public void setDatos(List<CATicketByNameCI> datos) {
		this.datos = datos;
	}
	
	
	
	
}
