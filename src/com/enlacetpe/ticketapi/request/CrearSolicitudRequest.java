package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class CrearSolicitudRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String categoriaSolicitud;

	@NotNull
	private String descripcionSolicitud;

	@NotNull
	private String grupo;

	@NotNull
	private String folioSF;
	
	@NotNull
	private String bandejaRetornoSF;

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

	public String getCategoriaSolicitud() {
		return categoriaSolicitud;
	}

	public void setCategoriaSolicitud(String categoriaSolicitud) {
		this.categoriaSolicitud = categoriaSolicitud;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getFolioSF() {
		return folioSF;
	}

	public void setFolioSF(String folioSF) {
		this.folioSF = folioSF;
	}

	public String getBandejaRetornoSF() {
		return bandejaRetornoSF;
	}

	public void setBandejaRetornoSF(String bandejaRetornoSF) {
		this.bandejaRetornoSF = bandejaRetornoSF;
	}

}
