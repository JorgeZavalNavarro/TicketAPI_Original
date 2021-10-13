package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class TransferenciaGrupoRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String ticketSD;

	private String folioSF;

	@NotNull
	private String grupo;

	@NotNull
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

	public String getFolioSF() {
		return folioSF;
	}

	public void setFolioSF(String folioSF) {
		this.folioSF = folioSF;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

}
