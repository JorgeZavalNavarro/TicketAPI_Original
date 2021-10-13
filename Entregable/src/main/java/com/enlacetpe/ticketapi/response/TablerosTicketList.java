
package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

public class TablerosTicketList extends TablerosResponse {

	private ArrayList<CATicket> tickets;

	public TablerosTicketList() {
	}

	// public TablerosTicketList(boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String mensajeServicio, String fechaSolicitud, String fechaRespuesta, ArrayList<CATicket> tickets) {
	public TablerosTicketList(boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String mensajeServicio, String fechaSolicitud, String fechaRespuesta, String ticketSD) {
		// super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud, fechaRespuesta);
		super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud, fechaRespuesta, ticketSD);
		//this.tickets = tickets;
	}

	public ArrayList<CATicket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<CATicket> tickets) {
		this.tickets = tickets;
	}
}
