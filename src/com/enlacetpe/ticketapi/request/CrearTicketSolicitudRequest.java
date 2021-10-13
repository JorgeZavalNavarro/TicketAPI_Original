package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class CrearTicketSolicitudRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String categoriaSolicitud;

	@NotNull
	private String descripcionSolicitud;

	@NotNull
	private String region;

	@NotNull
	private String ciudad;

	@NotNull
	private String olt;

	@NotNull
	private String ipOlt;

	@NotNull
	private String numeroSerieOlt;

	private String frame;
	private String slot;
	private String puerto;
	private String kpi;
	private String utilizacion;
	private String capacidad;
	private String porcentajeUtilizacion;

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

	public String getOlt() {
		return olt;
	}

	public void setOlt(String olt) {
		this.olt = olt;
	}

	public String getIpOlt() {
		return ipOlt;
	}

	public void setIpOlt(String ipOlt) {
		this.ipOlt = ipOlt;
	}

	public String getNumeroSerieOlt() {
		return numeroSerieOlt;
	}

	public void setNumeroSerieOlt(String numeroSerieOlt) {
		this.numeroSerieOlt = numeroSerieOlt;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getUtilizacion() {
		return utilizacion;
	}

	public void setUtilizacion(String utilizacion) {
		this.utilizacion = utilizacion;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getPorcentajeUtilizacion() {
		return porcentajeUtilizacion;
	}

	public void setPorcentajeUtilizacion(String porcentajeUtilizacion) {
		this.porcentajeUtilizacion = porcentajeUtilizacion;
	}

}
