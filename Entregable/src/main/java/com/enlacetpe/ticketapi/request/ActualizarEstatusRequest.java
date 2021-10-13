package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class ActualizarEstatusRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String ticketSD;
	
	@NotNull
	private String nuevoEstatus;
	
	private String justificacion;
	
	

	public String getNombreOperador() {
		return nombreOperador;
	}

	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}

	public String getNumeroEmpleadoTPoperador() {
		return numeroEmpleadoTPoperador;
	}

	public void setNumeroEmpleadoTPoperador(String numeroEmpleadoTPoperador) {
		this.numeroEmpleadoTPoperador = numeroEmpleadoTPoperador;
	}

	public String getTicketSD() {
		return ticketSD;
	}

	public void setTicketSD(String ticketSD) {
		this.ticketSD = ticketSD;
	}

	public String getNuevoEstatus() {
		return nuevoEstatus;
	}

	public void setNuevoEstatus(String nuevoEstatus) {
		this.nuevoEstatus = nuevoEstatus;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	
	
	
}
