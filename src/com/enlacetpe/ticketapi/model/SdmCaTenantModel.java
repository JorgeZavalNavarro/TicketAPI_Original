package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_ca_tenant")
public class SdmCaTenantModel {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="tenant_number")
	private String tenantNumber;
	
	@Column(name="service_provider")
	private Integer serviceProvider;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="inactive")
	private Integer inactive;
	
	@Column(name="version_number")
	private Integer versionNumber;
	
	@Column(name="creation_user")
	private String creationUser;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="last_update_user")
	private String lastUpdateUser;
	
	@Column(name="last_update_date")
	private Date lastUpdateDate;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="parent")
	private String parent;
	
	@Column(name="fkey_group")
	private String fkeyGroup;
	
	@Column(name="subtenants_ok")
	private Integer subtenantsOk;
	
	@Column(name="DATE_INSERT")
	private Date dateInsert;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTenantNumber() {
		return tenantNumber;
	}

	public void setTenantNumber(String tenantNumber) {
		this.tenantNumber = tenantNumber;
	}

	public Integer getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(Integer serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getInactive() {
		return inactive;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getFkeyGroup() {
		return fkeyGroup;
	}

	public void setFkeyGroup(String fkeyGroup) {
		this.fkeyGroup = fkeyGroup;
	}

	public Integer getSubtenantsOk() {
		return subtenantsOk;
	}

	public void setSubtenantsOk(Integer subtenantsOk) {
		this.subtenantsOk = subtenantsOk;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	
}
