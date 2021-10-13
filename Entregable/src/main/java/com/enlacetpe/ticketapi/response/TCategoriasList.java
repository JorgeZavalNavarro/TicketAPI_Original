package com.enlacetpe.ticketapi.response;

import java.util.ArrayList;

public class TCategoriasList extends TablerosResponse {

	private ArrayList<TCategorias> CategoriasEncontradas;
	private int totalCoincidenciasBusqueda;

	public TCategoriasList() {
		super();
	}

	public TCategoriasList(Boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String descripcionRespuestaServicio,
			String fechaSolicitud, String fechaRespuesta, ArrayList<TCategorias> CategoriasEncontradas,
			int totalCoincidenciasBusqueda) {
		super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, descripcionRespuestaServicio, fechaSolicitud, fechaRespuesta, null);
		// super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, descripcionRespuestaServicio, fechaSolicitud, fechaRespuesta);
		this.CategoriasEncontradas = CategoriasEncontradas;
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public TCategoriasList(Boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta, String descripcionRespuestaServicio,
			String fechaSolicitud, String fechaRespuesta, int totalCoincidenciasBusqueda) {
		super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, descripcionRespuestaServicio, fechaSolicitud, fechaRespuesta, null);
		// super(respuestaBoolean, codigoRespuesta, descripcionRespuesta, descripcionRespuestaServicio, fechaSolicitud, fechaRespuesta);
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

	public TCategoriasList(Boolean respuestaBoolean, String codigoRespuesta, String descripcionRespuesta,
			String fechaSolicitud, String fechaRespuesta, int totalCoincidenciasBusqueda2) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<TCategorias> getCategoriasEncontradas() {
		return CategoriasEncontradas;
	}

	public void setCategoriasEncontradas(ArrayList<TCategorias> categoriasEncontradas) {
		CategoriasEncontradas = categoriasEncontradas;
	}

	public int getTotalCoincidenciasBusqueda() {
		return totalCoincidenciasBusqueda;
	}

	public void setTotalCoincidenciasBusqueda(int totalCoincidenciasBusqueda) {
		this.totalCoincidenciasBusqueda = totalCoincidenciasBusqueda;
	}

}
