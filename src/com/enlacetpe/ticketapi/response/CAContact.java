package com.enlacetpe.ticketapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CAContact {

	private String middleName;
	private String alias;
	private String firstName;
	private String lastName;
	private String comboName; 
	private String phoneNumber;
	private String emailAddress;
	private String locationName;
	private String locationAddress1;
	private String locationAddress2;
	private String locationAddress3;
	private String locationCity;
	private String locationZip;
	private String creationDate;
	private String lastModDate;
	private String userId;
	private String tenant;
	private String deleteFlag;
	private String orgName;
	
	private String id;
	private String hostName;
	private String macAddress;
	private String ipAddress;
	private String serialNumber;
	
	
	public CAContact() {}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getLocationAddress1() {
		return locationAddress1;
	}
	public void setLocationAddress1(String locationAddress1) {
		this.locationAddress1 = locationAddress1;
	}
	public String getLocationAddress2() {
		return locationAddress2;
	}
	public void setLocationAddress2(String locationAddress2) {
		this.locationAddress2 = locationAddress2;
	}
	public String getLocationAddress3() {
		return locationAddress3;
	}
	public void setLocationAddress3(String locationAddress3) {
		this.locationAddress3 = locationAddress3;
	}
	
	public String getLocationCity() {
		return locationCity;
	}

	public void setLocationCity(String locationCity) {
		this.locationCity = locationCity;
	}

	public String getLocationZip() {
		return locationZip;
	}
	public void setLocationZip(String locationZip) {
		this.locationZip = locationZip;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getLastModDate() {
		return lastModDate;
	}
	public void setLastModDate(String lastModDate) {
		this.lastModDate = lastModDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTenant() {
		return tenant;
	}
	public void setTenant(String tenant) {
		this.tenant = tenant;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
	
	
}
