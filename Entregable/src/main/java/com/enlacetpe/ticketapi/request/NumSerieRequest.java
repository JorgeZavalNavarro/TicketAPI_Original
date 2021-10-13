package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class NumSerieRequest {

	@NotNull
	private String numeroSerie;

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

}
