package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=" sdm_ca_organization")
public class SdmCaOrganizationModel {
	
	@Id
	@Column(name="organization_uuid")
	private String organizationUuid;
	
	@Column(name="org_name")
	private String orgName;
	
	@Column(name="abbreviation")
	private String abbreviation;
	
	@Column(name="inactive")
	private Integer inactive;
	
//	@Column(name="pager_email_address")
//	private String pagerEmailAddress;
	
	@Column(name="DATE_INSERT")
	private Date dateInsert;

	public String getOrganizationUuid() {
		return organizationUuid;
	}

	public void setOrganizationUuid(String organizationUuid) {
		this.organizationUuid = organizationUuid;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Integer getInactive() {
		return inactive;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}


//	public String getPagerEmailAddress() {
//		return pagerEmailAddress;
//	}
//
//	public void setPagerEmailAddress(String pagerEmailAddress) {
//		this.pagerEmailAddress = pagerEmailAddress;
//	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	
}
