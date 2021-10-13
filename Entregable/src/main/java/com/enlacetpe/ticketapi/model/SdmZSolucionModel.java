package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_zSolucion")
public class SdmZSolucionModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="last_mod_dt")
	private Date lastModDt;
	
	@Column(name="last_mod_by")
	private String lastModBy;
	
	@Column(name="del")
	private Integer del;
	
	@Column(name="description")
	private String description;
	
	@Column(name="sym")
	private String sym;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="dept_id")
	private Integer deptId;
	
	@Column(name="diagnostico_id")
	private Integer diagnosticoId;
	
	@Column(name="solucion")
	private String solucion;
	
	@Column(name="DATE_INSERT")
	private Date dateInsert;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
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

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getDiagnosticoId() {
		return diagnosticoId;
	}

	public void setDiagnosticoId(Integer diagnosticoId) {
		this.diagnosticoId = diagnosticoId;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	

}
