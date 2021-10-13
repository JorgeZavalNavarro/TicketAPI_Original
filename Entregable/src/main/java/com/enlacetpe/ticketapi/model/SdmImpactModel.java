package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_impact")
public class SdmImpactModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="del")
	private Integer del;
	
	@Column(name="enum")
	private Integer enumImpact;
	
	@Column(name="sym")
	private String sym;
	
	@Column(name="nx_desc")
	private String nxDesc;
	
	@Column(name="last_mod_dt")
	private Date lastModDt;
	
	@Column(name="value")
	private Integer value;
	
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

	public Integer getEnumImpact() {
		return enumImpact;
	}

	public void setEnumImpact(Integer enumImpact) {
		this.enumImpact = enumImpact;
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

	public Date getLastModDt() {
		return lastModDt;
	}

	public void setLastModDt(Date lastModDt) {
		this.lastModDt = lastModDt;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	

}
