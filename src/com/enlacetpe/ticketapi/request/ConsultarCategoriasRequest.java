package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;

public class ConsultarCategoriasRequest {

	@NotNull
	private String nombreOperador;

	@NotNull
	private String numeroEmpleadoTPoperador;

	@NotNull
	private String tipoCategoria;

	@NotNull
	private String textoConsultaCategoria;

	private String textoSegundoNivel;
	private String textoTercerNivel;

	public String getNombreOperador() {
		return nombreOperador;
	}

	public void setNombreOperador(String nombreOperador) {
		this.nombreOperador = nombreOperador;
	}

	public String getNumeroEmpleadoTPoperador() {
		return numeroEmpleadoTPoperador;
	}

	public void setNumeroEmpleadoTPoperador(String numeroEmpleadoTPoperador) {
		this.numeroEmpleadoTPoperador = numeroEmpleadoTPoperador;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public String getTextoConsultaCategoria() {
		return textoConsultaCategoria;
	}

	public void setTextoConsultaCategoria(String textoPrimerNivel) {
		this.textoConsultaCategoria = textoPrimerNivel;
	}

	public String getTextoSegundoNivel() {
		return textoSegundoNivel;
	}

	public void setTextoSegundoNivel(String textoSegundoNivel) {
		this.textoSegundoNivel = textoSegundoNivel;
	}

	public String getTextoTercerNivel() {
		return textoTercerNivel;
	}

	public void setTextoTercerNivel(String textoTercerNivel) {
		this.textoTercerNivel = textoTercerNivel;
	}

}
