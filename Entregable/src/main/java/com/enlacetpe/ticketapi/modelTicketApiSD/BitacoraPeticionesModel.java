package com.enlacetpe.ticketapi.modelTicketApiSD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bitacora_peticiones")
public class BitacoraPeticionesModel {

	@Id
	@Column(name = "id_bitacora")
	private Integer idBitacora;

	@Column(name = "nombre_Operador")
	private String nombreOperador;

	@Column(name = "numero_Empleado_TPoperador")
	private String numeroEmpleadoTPoperador;

	@Column(name = "fecha_envio_peticion")
	private String fechaEnvioPeticion;

	@Column(name = "accion")
	private String accion;

	@Column(name = "json_request",columnDefinition="LONGTEXT")
	private String jsonRequest;

	public Integer getIdBitacora() {
		return idBitacora;
	}

	public void setIdBitacora(Integer idBitacora) {
		this.idBitacora = idBitacora;
	}

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

	public String getFechaEnvioPeticion() {
		return fechaEnvioPeticion;
	}

	public void setFechaEnvioPeticion(String fechaEnvioPeticion) {
		this.fechaEnvioPeticion = fechaEnvioPeticion;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getJsonRequest() {
		return jsonRequest;
	}

	public void setJsonRequest(String jsonRequest) {
		this.jsonRequest = jsonRequest;
	}

}
