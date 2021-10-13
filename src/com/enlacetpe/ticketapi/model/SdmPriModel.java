package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_pri")
public class SdmPriModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="del")
	private Integer del;
	
	@Column(name="enum")
	private Integer enumPri;
	
	@Column(name="sym")
	private String sym;
	
	@Column(name="nx_desc")
	private String nxDesc;
	
	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="last_mod_dt")
	private Date lastModDt;
	
	@Column(name="last_mod_by")
	private String lastModBy;
	
	@Column(name="DATE_INSERT")
	private Date dateInsert;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Integer getEnumPri() {
		return enumPri;
	}

	public void setEnumPri(Integer enumPri) {
		this.enumPri = enumPri;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public String getNxDesc() {
		return nxDesc;
	}

	public void setNxDesc(String nxDesc) {
		this.nxDesc = nxDesc;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Date getLastModDt() {
		return lastModDt;
	}

	public void setLastModDt(Date lastModDt) {
		this.lastModDt = lastModDt;
	}

	public String getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	
}
