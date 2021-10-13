package com.enlacetpe.ticketapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdjuntarLigaArchivoResponse {

	protected boolean respuestaBoolean;
	protected String codigoRespuesta;
	protected String descripcionRespuesta;
	protected String mensajeServicio;
	protected String fechaSolicitud;
	protected String fechaRespuesta;
	protected String IdAttm;

	public AdjuntarLigaArchivoResponse() {
		super();
	}

	public boolean isRespuestaBoolean() {
		return respuestaBoolean;
	}

	public void setRespuestaBoolean(boolean respuestaBoolean) {
		this.respuestaBoolean = respuestaBoolean;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}

	public String getMensajeServicio() {
		return mensajeServicio;
	}

	public void setMensajeServicio(String mensajeServicio) {
		this.mensajeServicio = mensajeServicio;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(String fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public String getIdAttm() {
		return IdAttm;
	}

	public void setIdAttm(String idAttm) {
		IdAttm = idAttm;
	}
}
