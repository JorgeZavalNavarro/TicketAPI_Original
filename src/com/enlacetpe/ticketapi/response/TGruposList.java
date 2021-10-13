
package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

public class TGruposList extends TablerosResponse {

	private ArrayList<TGrupos> GruposEncontrados;
	private int totalCoincidenciasBusqueda;

	public TGruposList() {
		super();
	}

	public TGruposList(boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String mensajeServicio, String fechaSolicitud,
			String fechaRespuesta, ArrayList<TGrupos> gruposEncontrados, int totalCoincidenciasBusqueda) {
		super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud, fechaRespuesta, null);
		GruposEncontrados = gruposEncontrados;
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public TGruposList(boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String mensajeServicio, String fechaSolicitud,
			String fechaRespuesta, int totalCoincidenciasBusqueda) {
		super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, mensajeServicio, fechaSolicitud, fechaRespuesta, null);
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public ArrayList<TGrupos> getGruposEncontrados() {
		return GruposEncontrados;
	}

	public void setGruposEncontrados(ArrayList<TGrupos> gruposEncontrados) {
		GruposEncontrados = gruposEncontrados;
	}

	public int getTotalCoincidenciasBusqueda() {
		return totalCoincidenciasBusqueda;
	}

	public void setTotalCoincidenciasBusqueda(int totalCoincidenciasBusqueda) {
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

}
