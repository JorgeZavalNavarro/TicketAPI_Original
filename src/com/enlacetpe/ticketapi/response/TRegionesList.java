
package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

public class TRegionesList extends TablerosResponse {

	private ArrayList<TRegiones> regiones;
	private int totalCoincidenciasBusqueda;

	public TRegionesList(boolean respuesta, String codigoRespuesta, String descripcionRespuesta, String fechaSolicitud,
			String fechaRespuesta, ArrayList<TRegiones> regiones, int totalCoincidenciasBusqueda) {
		super(respuesta, codigoRespuesta, descripcionRespuesta, fechaSolicitud, fechaRespuesta, null);
		this.regiones = regiones;
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public TRegionesList(boolean respuesta, String codigoRespuesta, String descripcionRespuesta, String fechaSolicitud,
			String fechaRespuesta, int totalCoincidenciasBusqueda) {
		super(respuesta, codigoRespuesta, descripcionRespuesta, fechaSolicitud, fechaRespuesta, null);
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public ArrayList<TRegiones> getRegiones() {
		return regiones;
	}

	public void setRegiones(ArrayList<TRegiones> regiones) {
		this.regiones = regiones;
	}

	public int getTotalCoincidenciasBusqueda() {
		return totalCoincidenciasBusqueda;
	}

	public void setTotalCoincidenciasBusqueda(int totalCoincidenciasBusqueda) {
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

}
