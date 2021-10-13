
package com.enlacetpe.ticketapi.response;

import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CAInformacionIp extends CAResponse {

	private String punta;
	private String nombreOrganizacion;

	public CAInformacionIp() {
		super();
	}

	public CAInformacionIp(Boolean status, String error) {
		super.setSuccess(success);
		super.setError(error);
	}

	public CAInformacionIp(Boolean status, Period time, String error, String punta, String nombreOrganizacion) {
		super(status, time, error);
		this.punta = punta;
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public String getPunta() {
		return punta;
	}

	public void setPunta(String punta) {
		this.punta = punta;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}
}
