package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class CrearTicketClienteRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String numeroCuentaCliente;

	@NotNull
	private String organizacionCliente;

	@NotNull
	private String numeroCuentaSitio;

	@NotNull
	private String cotSitio;

	@NotNull
	private String nombreSitioDispositivo;

	@NotNull
	private String numeroCuentaServicio;

	@NotNull
	private String cotSitioPlan;

	@NotNull
	private String servicioFalla;

	@NotNull
	private String categoria;

	@NotNull
	private String diagnosticoInicial;

	@NotNull
	private String grupo;

	@NotNull
	private String proactivoReactivo;

	@NotNull
	private String descripcionFalla;

	@NotNull
	private String folioSF;
	
	@NotNull
	private String urgencia;
	
	@NotNull
	private String impacto;
	
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

	public String getNumeroCuentaCliente() {
		return numeroCuentaCliente;
	}

	public void setNumeroCuentaCliente(String numeroCuentaCliente) {
		this.numeroCuentaCliente = numeroCuentaCliente;
	}

	public String getOrganizacionCliente() {
		return organizacionCliente;
	}

	public void setOrganizacionCliente(String organizacionCliente) {
		this.organizacionCliente = organizacionCliente;
	}

	public String getNumeroCuentaSitio() {
		return numeroCuentaSitio;
	}

	public void setNumeroCuentaSitio(String numeroCuentaSitio) {
		this.numeroCuentaSitio = numeroCuentaSitio;
	}

	public String getCotSitio() {
		return cotSitio;
	}

	public void setCotSitio(String cotSitio) {
		this.cotSitio = cotSitio;
	}

	public String getNombreSitioDispositivo() {
		return nombreSitioDispositivo;
	}

	public void setNombreSitioDispositivo(String nombreSitioDispositivo) {
		this.nombreSitioDispositivo = nombreSitioDispositivo;
	}

	public String getNumeroCuentaServicio() {
		return numeroCuentaServicio;
	}

	public void setNumeroCuentaServicio(String numeroCuentaServicio) {
		this.numeroCuentaServicio = numeroCuentaServicio;
	}

	public String getCotSitioPlan() {
		return cotSitioPlan;
	}

	public void setCotSitioPlan(String cotSitioPlan) {
		this.cotSitioPlan = cotSitioPlan;
	}

	public String getServicioFalla() {
		return servicioFalla;
	}

	public void setServicioFalla(String servicioFalla) {
		this.servicioFalla = servicioFalla;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getDescripcionFalla() {
		return descripcionFalla;
	}

	public void setDescripcionFalla(String descripcionFalla) {
		this.descripcionFalla = descripcionFalla;
	}

	public String getFolioSF() {
		return folioSF;
	}

	public void setFolioSF(String folioSF) {
		this.folioSF = folioSF;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	public String getImpacto() {
		return impacto;
	}

	public void setImpacto(String impacto) {
		this.impacto = impacto;
	}

	public String getBandejaRetornoSF() {
		return bandejaRetornoSF;
	}

	public void setBandejaRetornoSF(String bandejaRetornoSF) {
		this.bandejaRetornoSF = bandejaRetornoSF;
	}
}
