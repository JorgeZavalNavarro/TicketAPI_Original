package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class CrearTicketMasivoRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String categoria;

	@NotNull
	private String region;

	@NotNull
	private String ciudad;

	@NotNull
	private String descripcionImpacto;

	@NotNull
	private String diagnosticoInicial;

	@NotNull
	private String grupo;

	@NotNull
	private String proactivoReactivo;

	@NotNull
	private String descripcion;

	@NotNull
	private String folioSF;
	
	private String impacto;
	private String urgencia;
	
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDescripcionImpacto() {
		return descripcionImpacto;
	}

	public void setDescripcionImpacto(String descripcionImpacto) {
		this.descripcionImpacto = descripcionImpacto;
	}

	public String getDiagnosticoInicial() {
		return diagnosticoInicial;
	}

	public void setDiagnosticoInicial(String diagnosticoInicial) {
		this.diagnosticoInicial = diagnosticoInicial;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getProactivoReactivo() {
		return proactivoReactivo;
	}

	public void setProactivoReactivo(String proactivoReactivo) {
		this.proactivoReactivo = proactivoReactivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFolioSF() {
		return folioSF;
	}

	public void setFolioSF(String folioSF) {
		this.folioSF = folioSF;
	}

	public String getImpacto() {
		return impacto;
	}

	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	public String getBandejaRetornoSF() {
		return bandejaRetornoSF;
	}

	public void setBandejaRetornoSF(String bandejaRetornoSF) {
		this.bandejaRetornoSF = bandejaRetornoSF;
	}

}
