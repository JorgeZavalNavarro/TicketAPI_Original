package com.enlacetpe.ticketapi.response;

import java.util.List;

public class CATicketByNameCI{
	
	private String nombreDispositivo;
	private String alarma;
	private List<CATicket> tickets;
	
	
	
	
	public CATicketByNameCI() {
		super();
	}


	public CATicketByNameCI(String nombre,String alarma , List<CATicket> tickets) {
		super();
		this.nombreDispositivo = nombre;
		this.setAlarma(alarma);
		this.tickets = tickets;
	}

	
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}


	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}

	

	public List<CATicket> getTickets() {
		return tickets;
	}


	public void setTickets(List<CATicket> tickets) {
		this.tickets = tickets;
	}


	public String getAlarma() {
		return alarma;
	}


	public void setAlarma(String alarma) {
		this.alarma = alarma;
	}
	
	
}
