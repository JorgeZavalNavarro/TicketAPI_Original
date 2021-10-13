package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_cr_stat")
public class SdmCrStatModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="persid")
	private String persid;
	
	@Column(name="del")
	private Integer del;
	
	@Column(name="sym")
	private String sym;
	
	@Column(name="last_mod_dt")
	private Date lastModDt;
	
	@Column(name="last_mod_by")
	private String lastModBy;
	
	@Column(name="description")
	private String description;
	
	@Column(name="code")
	private String code;
	
	@Column(name="active")
	private Integer active;
	
	@Column(name="hold")
	private Integer hold;
	
	@Column(name="resolved")
	private Integer resolved;
	
	@Column(name="cr_flag")
	private Integer crFlag;
	
	@Column(name="in_flag")
	private Integer inFlag;
	
	@Column(name="pr_flag")
	private Integer prFlag;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="DATE_INSERT")
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

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getHold() {
		return hold;
	}

	public void setHold(Integer hold) {
		this.hold = hold;
	}

	public Integer getResolved() {
		return resolved;
	}

	public void setResolved(Integer resolved) {
		this.resolved = resolved;
	}

	public Integer getCrFlag() {
		return crFlag;
	}

	public void setCrFlag(Integer crFlag) {
		this.crFlag = crFlag;
	}

	public Integer getInFlag() {
		return inFlag;
	}

	public void setInFlag(Integer inFlag) {
		this.inFlag = inFlag;
	}

	public Integer getPrFlag() {
		return prFlag;
	}

	public void setPrFlag(Integer prFlag) {
		this.prFlag = prFlag;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	

}
