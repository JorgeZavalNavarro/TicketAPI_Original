
package com.enlacetpe.ticketapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TAdjuntarLigaArchivoResponse {

	protected boolean respuestaBoolean;
	protected String codigoRespuesta;
	protected String descripcionRespuesta;
	protected String mensajeServicio;
	protected String fechaSolicitud;
	protected String fechaRespuesta;
	protected String folioLiga;

	public TAdjuntarLigaArchivoResponse() {
		super();
	}

	public TAdjuntarLigaArchivoResponse(boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta,
			String mensajeServicio, String fechaSolicitud, String fechaRespuesta, String folioLiga) {
		super();
		this.respuestaBoolean = respuestaBoolean;
		this.codigoRespuesta = codigoRespuesta;
		this.descripcionRespuesta = descripcionRespuesta;
		this.mensajeServicio = mensajeServicio;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaRespuesta = fechaRespuesta;
		this.folioLiga = folioLiga;
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

	public boolean isRespuestaBoolean() {
		return respuestaBoolean;
	}

	public void setRespuestaBoolean(boolean respuestaBoolean) {
		this.respuestaBoolean = respuestaBoolean;
	}

	public String getFolioLiga() {
		return folioLiga;
	}

	public void setFolioLiga(String folioLiga) {
		this.folioLiga = folioLiga;
	}

}
