
package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class ConsultarCiudadesRequest {

	@NotNull
	private String nombreSolicitante;

	@NotNull
	private String numeroEmpleadoTPSolicitante;

	@NotNull
	private String regionConsulta;

	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	public String getNumeroEmpleadoTPSolicitante() {
		return numeroEmpleadoTPSolicitante;
	}

	public void setNumeroEmpleadoTPSolicitante(String numeroEmpleadoTPSolicitante) {
		this.numeroEmpleadoTPSolicitante = numeroEmpleadoTPSolicitante;
	}

	public String getRegionConsulta() {
		return regionConsulta;
	}

	public void setRegionConsulta(String regionConsulta) {
		this.regionConsulta = regionConsulta;
	}

}
