package com.enlacetpe.ticketapi.request;

public class SolicitudRequest {

	private String tfe;
	private String gid;
	private String nombreCentro;
	private String estado;
	private String municipio;
	private String localidad;
	private String domicilio;

	private String requestedBy;
	private String customer;
	private String categoria;
	private String type;
	private String group;
	private String status;

	public String getTfe() {
		return tfe;
	}

	public void setTfe(String tfe) {
		this.tfe = tfe;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getNombreCentro() {
		return nombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
