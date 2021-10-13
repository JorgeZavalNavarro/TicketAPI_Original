package com.enlacetpe.ticketapi.request;

public class ActualizaTiemposImputablesRequest {

	private String refNum;
	private String ztiempoFallaCte; // Tiempo Falla Cliente
	private String ztiempoFallaProv;// Tiempo Falla Proveedor
	private String ztiempoFallaTerceros;// Tiempo Falla Terceros
	private String ztiempoFallaTpe;// Tiempo Falla TPE
	private String ztiempoPerformance; // Tiempo imputable Performance

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getZtiempoFallaCte() {
		return ztiempoFallaCte;
	}

	public void setZtiempoFallaCte(String ztiempoFallaCte) {
		this.ztiempoFallaCte = ztiempoFallaCte;
	}

	public String getZtiempoFallaProv() {
		return ztiempoFallaProv;
	}

	public void setZtiempoFallaProv(String ztiempoFallaProv) {
		this.ztiempoFallaProv = ztiempoFallaProv;
	}

	public String getZtiempoFallaTerceros() {
		return ztiempoFallaTerceros;
	}

	public void setZtiempoFallaTerceros(String ztiempoFallaTerceros) {
		this.ztiempoFallaTerceros = ztiempoFallaTerceros;
	}

	public String getZtiempoFallaTpe() {
		return ztiempoFallaTpe;
	}

	public void setZtiempoFallaTpe(String ztiempoFallaTpe) {
		this.ztiempoFallaTpe = ztiempoFallaTpe;
	}

	public String getZtiempoPerformance() {
		return ztiempoPerformance;
	}

	public void setZtiempoPerformance(String ztiempoPerformance) {
		this.ztiempoPerformance = ztiempoPerformance;
	}

	

}
