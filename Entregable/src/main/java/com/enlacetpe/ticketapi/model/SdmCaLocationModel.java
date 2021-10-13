package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_ca_location")
public class SdmCaLocationModel {
	
	@Id
	@Column(name="location_uuid")
	private String locationUuid;
	
	@Column(name="location_name")
	private String locationName;
	
	@Column(name="inactive")
	private Integer inactive;
	
	@Column(name="pri_phone_number")
	private String priPhoneNumber;
	
	@Column(name="fax_number")
	private String faxNumber;
	
	@Column(name="address_1")
	private String address1;
	
	@Column(name="address_2")
	private String address2;
	
	@Column(name="address_3")
	private String address3;
	
	@Column(name="address_4")
	private String address4;
	
	@Column(name="address_5")
	private String address5;
	
	@Column(name="address_6")
	private String address6;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private Integer state;
	
	@Column(name="zip")
	private String zip;
	
	@Column(name="country")
	private Integer country;
	
	@Column(name="county")
	private String county;
	
	@Column(name="site_id")
	private Integer siteId;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="last_update_date")
	private Date lastUpdateDate;
	
	@Column(name="version_number")
	private Integer versionNumber;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="region_id")
	private Integer regionId;
	
	@Column(name="DATE_INSERT")
	private Date dateInsert;
	

	public String getLocationUuid() {
		return locationUuid;
	}

	public void setLocationUuid(String locationUuid) {
		this.locationUuid = locationUuid;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Integer getInactive() {
		return inactive;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}

	public String getPriPhoneNumber() {
		return priPhoneNumber;
	}

	public void setPriPhoneNumber(String priPhoneNumber) {
		this.priPhoneNumber = priPhoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getAddress5() {
		return address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}

	public String getAddress6() {
		return address6;
	}

	public void setAddress6(String address6) {
		this.address6 = address6;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Integer getSiteId() {
		return siteId;
	}

	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	

	
	
	

}
