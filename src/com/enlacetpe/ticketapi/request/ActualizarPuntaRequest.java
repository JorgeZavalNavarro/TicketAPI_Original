package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class ActualizarPuntaRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String nombrePunta;

	private String zipInterface;
	private String zLongitud;
	private String zLatitud;
	private String zesInterface;
	private String zSitio;
	private String zsecIpDevice;
	private String zsecIdInterface;
	private String zsecEsNodoCentral;
	private String zsecIdDevice;
	private String zsecPosicionNodo;
	private String zsecNombreInterface;
	private String zsecNombreNodo;
	private String zsecLeyendaInterface;
	private String zsecAliasInterface;
	private String zsecPosicionInterface;
	private String tipo;
	
	private String puntaTipo;

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

	public String getNombrePunta() {
		return nombrePunta;
	}

	public void setNombrePunta(String nombrePunta) {
		this.nombrePunta = nombrePunta;
	}

	public String getZipInterface() {
		return zipInterface;
	}

	public void setZipInterface(String zipInterface) {
		this.zipInterface = zipInterface;
	}

	public String getzLongitud() {
		return zLongitud;
	}

	public void setzLongitud(String zLongitud) {
		this.zLongitud = zLongitud;
	}

	public String getzLatitud() {
		return zLatitud;
	}

	public void setzLatitud(String zLatitud) {
		this.zLatitud = zLatitud;
	}

	public String getZesInterface() {
		return zesInterface;
	}

	public void setZesInterface(String zesInterface) {
		this.zesInterface = zesInterface;
	}

	public String getzSitio() {
		return zSitio;
	}

	public void setzSitio(String zSitio) {
		this.zSitio = zSitio;
	}

	public String getZsecIpDevice() {
		return zsecIpDevice;
	}

	public void setZsecIpDevice(String zsecIpDevice) {
		this.zsecIpDevice = zsecIpDevice;
	}

	public String getZsecIdInterface() {
		return zsecIdInterface;
	}

	public void setZsecIdInterface(String zsecIdInterface) {
		this.zsecIdInterface = zsecIdInterface;
	}

	public String getZsecEsNodoCentral() {
		return zsecEsNodoCentral;
	}

	public void setZsecEsNodoCentral(String zsecEsNodoCentral) {
		this.zsecEsNodoCentral = zsecEsNodoCentral;
	}

	public String getZsecIdDevice() {
		return zsecIdDevice;
	}

	public void setZsecIdDevice(String zsecIdDevice) {
		this.zsecIdDevice = zsecIdDevice;
	}

	public String getZsecPosicionNodo() {
		return zsecPosicionNodo;
	}

	public void setZsecPosicionNodo(String zsecPosicionNodo) {
		this.zsecPosicionNodo = zsecPosicionNodo;
	}

	public String getZsecNombreInterface() {
		return zsecNombreInterface;
	}

	public void setZsecNombreInterface(String zsecNombreInterface) {
		this.zsecNombreInterface = zsecNombreInterface;
	}

	public String getZsecNombreNodo() {
		return zsecNombreNodo;
	}

	public void setZsecNombreNodo(String zsecNombreNodo) {
		this.zsecNombreNodo = zsecNombreNodo;
	}

	public String getZsecLeyendaInterface() {
		return zsecLeyendaInterface;
	}

	public void setZsecLeyendaInterface(String zsecLeyendaInterface) {
		this.zsecLeyendaInterface = zsecLeyendaInterface;
	}

	public String getZsecAliasInterface() {
		return zsecAliasInterface;
	}

	public void setZsecAliasInterface(String zsecAliasInterface) {
		this.zsecAliasInterface = zsecAliasInterface;
	}

	public String getZsecPosicionInterface() {
		return zsecPosicionInterface;
	}

	public void setZsecPosicionInterface(String zsecPosicionInterface) {
		this.zsecPosicionInterface = zsecPosicionInterface;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPuntaTipo() {
		return puntaTipo;
	}

	public void setPuntaTipo(String puntaTipo) {
		this.puntaTipo = puntaTipo;
	}

}
