
package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

public class TCiudadesList extends TablerosResponse {

	private ArrayList<TCiudades> ciudades;
	private int totalCoincidenciasBusqueda;

	public TCiudadesList() {
		super();
	}

	public TCiudadesList(boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String mensajeServicio, String fechaSolicitud,
			String fechaRespuesta, ArrayList<TCiudades> ciudades, int totalCoincidenciasBusqueda) {
		super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud, fechaRespuesta, null);
		this.ciudades = ciudades;
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public TCiudadesList(boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String mensajeServicio, String fechaSolicitud,
			String fechaRespuesta, int totalCoincidenciasBusqueda) {
		super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud, fechaRespuesta, null);
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public ArrayList<TCiudades> getCiudades() {
		return ciudades;
	}

	public void setCiudades(ArrayList<TCiudades> ciudades) {
		this.ciudades = ciudades;
	}

	public int getTotalCoincidenciasBusqueda() {
		return totalCoincidenciasBusqueda;
	}

	public void setTotalCoincidenciasBusqueda(int totalCoincidenciasBusqueda) {
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

}
