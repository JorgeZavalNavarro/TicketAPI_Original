package com.enlacetpe.ticketapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sdm_zciudad")
public class SdmZCiudadModel {

	@Id
	@Column(name = "id")
	private Integer idRegion;

	@Column(name = "del")
	private Integer del;

	@Column(name = "description")
	private String descripcion;

	@Column(name = "region_id")
	private Integer regionId;

	@Column(name = "sym")
	private String sym;

	@Column(name = "zid_region")
	private Integer zIdRegion;

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public Integer getzIdRegion() {
		return zIdRegion;
	}

	public void setzIdRegion(Integer zIdRegion) {
		this.zIdRegion = zIdRegion;
	}

}
