package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class AgregarComentarioRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String ticketSD;

	@NotNull
	private String comentario;

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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
