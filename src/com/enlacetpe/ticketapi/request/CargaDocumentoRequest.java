package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class CargaDocumentoRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String ticketSD;

	@NotNull
	private String nombreDocumento;

	@NotNull
	private String documento;

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

	public String getNombreDocumento() {
		return nombreDocumento;
	}

	public void setNombreDocumento(String nombreDocumento) {
		this.nombreDocumento = nombreDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
