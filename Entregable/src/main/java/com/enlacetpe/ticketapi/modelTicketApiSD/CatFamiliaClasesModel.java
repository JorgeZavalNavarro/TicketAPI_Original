
package com.enlacetpe.ticketapi.modelTicketApiSD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cat_familia_clases")
public class CatFamiliaClasesModel {

	@Id
	@Column(name = "id_familia_clase")
	private Integer idFamiliaClase;

	@Column(name = "nombre_familia_clase")
	private String nombreFamilia;

	@Column(name = "activo")
	private Integer activo;

	public Integer getIdFamiliaClase() {
		return idFamiliaClase;
	}

	public void setIdFamiliaClase(Integer idFamiliaClase) {
		this.idFamiliaClase = idFamiliaClase;
	}

	public String getNombreFamilia() {
		return nombreFamilia;
	}

	public void setNombreFamilia(String nombreFamilia) {
		this.nombreFamilia = nombreFamilia;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

}
