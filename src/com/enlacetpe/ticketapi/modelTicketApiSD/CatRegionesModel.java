package com.enlacetpe.ticketapi.modelTicketApiSD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sdm_zregciu")
public class CatRegionesModel {

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

	@Column(name = "persistent_id")
	private String persistentId;

	@Column(name = "sym")
	private String sym;

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

	public String getPersistentId() {
		return persistentId;
	}

	public void setPersistentId(String persistentId) {
		this.persistentId = persistentId;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

}
