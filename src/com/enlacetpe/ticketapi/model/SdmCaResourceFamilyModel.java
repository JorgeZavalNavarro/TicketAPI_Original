package com.enlacetpe.ticketapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_ca_resource_family")
public class SdmCaResourceFamilyModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="inactive")
	private Integer inactive;
	
	@Column(name="name")
	private String name;
	
	@Column(name="table_extension_name")
	private String tableExtensionName;
	
	@Column(name="creation_user")
	private String creationUser;
	
	@Column(name="creation_date")
	private Integer creationDate;
	
	@Column(name="last_update_user")
	private String lastUpdateUser;
	
	@Column(name="last_update_date")
	private Integer lastUpdateDate;
	
	@Column(name="version_number")
	private Integer versionNumber;
	
	@Column(name="description")
	private String description;
	
	@Column(name="exclude_registration")
	private Integer excludeRegistration;
	
	@Column(name="delete_time")
	private Integer deleteTime;
	
	@Column(name="include_reconciliation")
	private Integer includeReconcilation;
	 
	@Column(name="physical_table_name")
	private String physicalTableName;
	
	@Column(name="is_software")
	private Integer isSoftware;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="is_itam")
	private Integer isItam;
	
	@Column(name="date_insert")
	private Date dateTime;

	public Integer getId() {
		return id;
	}

	public Integer getInactive() {
		return inactive;
	}

	public String getName() {
		return name;
	}

	public String getTableExtensionName() {
		return tableExtensionName;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public Integer getCreationDate() {
		return creationDate;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public Integer getLastUpdateDate() {
		return lastUpdateDate;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public String getDescription() {
		return description;
	}

	public Integer getExcludeRegistration() {
		return excludeRegistration;
	}

	public Integer getDeleteTime() {
		return deleteTime;
	}

	public Integer getIncludeReconcilation() {
		return includeReconcilation;
	}

	public String getPhysicalTableName() {
		return physicalTableName;
	}

	public Integer getIsSoftware() {
		return isSoftware;
	}

	public String getTenant() {
		return tenant;
	}

	public Integer getIsItam() {
		return isItam;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTableExtensionName(String tableExtensionName) {
		this.tableExtensionName = tableExtensionName;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public void setCreationDate(Integer creationDate) {
		this.creationDate = creationDate;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public void setLastUpdateDate(Integer lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExcludeRegistration(Integer excludeRegistration) {
		this.excludeRegistration = excludeRegistration;
	}

	public void setDeleteTime(Integer deleteTime) {
		this.deleteTime = deleteTime;
	}

	public void setIncludeReconcilation(Integer includeReconcilation) {
		this.includeReconcilation = includeReconcilation;
	}

	public void setPhysicalTableName(String physicalTableName) {
		this.physicalTableName = physicalTableName;
	}

	public void setIsSoftware(Integer isSoftware) {
		this.isSoftware = isSoftware;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public void setIsItam(Integer isItam) {
		this.isItam = isItam;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
