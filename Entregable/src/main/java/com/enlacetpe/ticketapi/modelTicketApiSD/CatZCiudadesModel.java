package com.enlacetpe.ticketapi.modelTicketApiSD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sdm_zciureg")
public class CatZCiudadesModel {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "last_mod_by")
	private String lastModBy;

	@Column(name = "tenant")
	private String tenant;

	@Column(name = "delete_flag")
	private Integer deleteFlag;

	@Column(name = "description")
	private String description;

	@Column(name = "sym")
	private String sym;

	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "zregion_id")
	private Integer zRegionId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getzRegionId() {
		return zRegionId;
	}

	public void setzRegionId(Integer zRegionId) {
		this.zRegionId = zRegionId;
	}

}
