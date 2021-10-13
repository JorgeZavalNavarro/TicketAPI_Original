package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_prob_ctg")
public class SdmProbCtgModel {
	
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
	
	@Column(name="organization")
	private String organization;
	
	@Column(name="group_id")
	private String groupId;
	
	@Column(name="tcode")
	private Integer tcode;
	
	@Column(name="service_type")
	private String serviceType;
	
	@Column(name="survey")
	private Integer survey;
	
    @Column(name="cr_flag")
    private Integer crFlag;
    
    @Column(name="in_flag")
    private Integer inFlag;
    
    @Column(name="pr_flag")
    private Integer prFlag;
    
    @Column(name="tenant")
    private String tenant;
    
    @Column(name="ss_sym")
    private String ssSym;
    
    @Column(name="ss_include")
    private Integer ssInclude;
    
    @Column(name="category_urgency")
    private Integer categoryUrgency;
    
    @Column(name="zimpacto")
    private Integer zimpacto;
    
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Integer getTcode() {
		return tcode;
	}

	public void setTcode(Integer tcode) {
		this.tcode = tcode;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getSurvey() {
		return survey;
	}

	public void setSurvey(Integer survey) {
		this.survey = survey;
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

	public String getSsSym() {
		return ssSym;
	}

	public void setSsSym(String ssSym) {
		this.ssSym = ssSym;
	}

	public Integer getSsInclude() {
		return ssInclude;
	}

	public void setSsInclude(Integer ssInclude) {
		this.ssInclude = ssInclude;
	}

	public Integer getCategoryUrgency() {
		return categoryUrgency;
	}

	public void setCategoryUrgency(Integer categoryUrgency) {
		this.categoryUrgency = categoryUrgency;
	}

	public Integer getZimpacto() {
		return zimpacto;
	}

	public void setZimpacto(Integer zimpacto) {
		this.zimpacto = zimpacto;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
    
    
    
}
