package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateTicketRequest {
	
	@NotNull
	@Size(min=1, max=255)
	private String puntaId;
	
	
	@NotNull
	@Size(min=1, max=255)
	private String estatus;
	
	
	@NotNull
	@Size(min=1, max=255)
	private String categoria;
	
	@NotNull
	@Size(min=1, max=255)
	private String[] descripcion;
	
	@NotNull
	private String resumen;
	
	@NotNull 
	@Size(min=1, max=255)
	private String tipo;
	
	@NotNull 
	@Size(min=1, max=255)
	private String solicitadoPor;
	
	private String diagnosticoInicial;
	
	private String tipoRed;
	
	private String regCiuId;
	
	private String organizacion;
	
	private String idItsm;
	
	private String tenant;
	
	@NotNull 
	@Size(min=1, max=255)
	private String grupo;
	
	private String proactivoReactivo;
	
	private String ticketExterno;
	
	private String url;

	public String getPuntaId() {
		return puntaId;
	}

	public String getEstatus() {
		return estatus;
	}

	public String getCategoria() {
		return categoria;
	}

	public String[] getDescripcion() {
		return descripcion;
	}

	public String getResumen() {
		return resumen;
	}

	public String getTipo() {
		return tipo;
	}

	public String getSolicitadoPor() {
		return solicitadoPor;
	}

	public String getDiagnosticoInicial() {
		return diagnosticoInicial;
	}

	public String getTipoRed() {
		return tipoRed;
	}

	public String getRegCiuId() {
		return regCiuId;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public String getIdItsm() {
		return idItsm;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getProactivoReactivo() {
		return proactivoReactivo;
	}

	public String getUrl() {
		return url;
	}

	public void setPuntaId(String puntaId) {
		this.puntaId = puntaId;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setDescripcion(String[] descripcion) {
		this.descripcion = descripcion;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setSolicitadoPor(String solicitadoPor) {
		this.solicitadoPor = solicitadoPor;
	}

	public void setDiagnosticoInicial(String diagnosticoInicial) {
		this.diagnosticoInicial = diagnosticoInicial;
	}

	public void setTipoRed(String tipoRed) {
		this.tipoRed = tipoRed;
	}

	public void setRegCiuId(String regCiuId) {
		this.regCiuId = regCiuId;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	public void setIdItsm(String idItsm) {
		this.idItsm = idItsm;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public void setProactivoReactivo(String proactivoReactivo) {
		this.proactivoReactivo = proactivoReactivo;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTicketExterno() {
		return ticketExterno;
	}

	public void setTicketExterno(String ticketExterno) {
		this.ticketExterno = ticketExterno;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}



}
