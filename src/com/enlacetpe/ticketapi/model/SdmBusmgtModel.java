package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_busmgt")
public class SdmBusmgtModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="persid")
	private String persid;
	
	@Column(name="hier_parent")
	private String hierParent;
	
	@Column(name="hier_child")
	private String hierChild;
	
	@Column(name="last_mod_dt")
	private Date lastModDt;
	
	@Column(name="last_mod_dt_unix")
	private Integer lastModDtUnix;
	
	@Column(name="last_mod_by", columnDefinition="Text")
	private String lastModBy;
	
	@Column(name="cost")
	private Integer cost;
	
	@Column(name="sym")
	private String sym;
	
	@Column(name="nx_desc")
	private String nxDesc;
	
	@Column(name="bm_rep")
	private Integer bmRep;
	
	@Column(name="ci_rel_type")
	private Integer ciRelType;
	
	@Column(name="tenant", columnDefinition="Text")
	private String tenant;
	
	@Column(name="del")
	private Integer del;
	
	@Column(name="date_insert")
	private Date dateInsert;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersid() {
		return persid;
	}

	public void setPersid(String persid) {
		this.persid = persid;
	}

	public String getHierParent() {
		return hierParent;
	}

	public void setHierParent(String hierParent) {
		this.hierParent = hierParent;
	}

	public String getHierChild() {
		return hierChild;
	}

	public void setHierChild(String hierChild) {
		this.hierChild = hierChild;
	}

	public Date getLastModDt() {
		return lastModDt;
	}

	public void setLastModDt(Date lastModDt) {
		this.lastModDt = lastModDt;
	}

	public Integer getLastModDtUnix() {
		return lastModDtUnix;
	}

	public void setLastModDtUnix(Integer lastModDtUnix) {
		this.lastModDtUnix = lastModDtUnix;
	}

	public String getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(String lastModBy) {
		this.lastModBy = lastModBy;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
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

	public Integer getBmRep() {
		return bmRep;
	}

	public void setBmRep(Integer bmRep) {
		this.bmRep = bmRep;
	}

	public Integer getCiRelType() {
		return ciRelType;
	}

	public void setCiRelType(Integer ciRelType) {
		this.ciRelType = ciRelType;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	

}
