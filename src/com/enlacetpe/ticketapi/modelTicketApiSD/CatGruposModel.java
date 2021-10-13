package com.enlacetpe.ticketapi.modelTicketApiSD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sdm_ca_contact")
public class CatGruposModel {

	@Id
	@Column(name = "contact_uuid")
	private String contactUuid;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "alias")
	private String alias;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "pri_phone_number")
	private String priPhoneNumber;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "location_uuid")
	private String locationUuid;

	@Column(name = "contact_type")
	private Integer contactType;

	@Column(name = "inactive")
	private Integer inactive;

	@Column(name = "creation_user")
	private String creationUser;

	@Column(name = "last_update_user")
	private String lastUpdateUser;

	@Column(name = "department")
	private Integer department;

	@Column(name = "comments")
	private String comments;

	@Column(name = "company_uuid")
	private String companyUuid;

	@Column(name = "job_title")
	private Integer jobTitle;

	@Column(name = "job_function")
	private Integer jobFunction;

	@Column(name = "userid")
	private String userid;

	@Column(name = "tenant")
	private String tenant;

	@Column(name = "organization_uuid")
	private String organizationUuid;

	@Column(name = "last_update_date_unix")
	private Integer lastUpdateDateUnix;

	public String getContactUuid() {
		return contactUuid;
	}

	public void setContactUuid(String contactUuid) {
		this.contactUuid = contactUuid;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPriPhoneNumber() {
		return priPhoneNumber;
	}

	public void setPriPhoneNumber(String priPhoneNumber) {
		this.priPhoneNumber = priPhoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLocationUuid() {
		return locationUuid;
	}

	public void setLocationUuid(String locationUuid) {
		this.locationUuid = locationUuid;
	}

	public Integer getContactType() {
		return contactType;
	}

	public void setContactType(Integer contactType) {
		this.contactType = contactType;
	}

	public Integer getInactive() {
		return inactive;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCompanyUuid() {
		return companyUuid;
	}

	public void setCompanyUuid(String companyUuid) {
		this.companyUuid = companyUuid;
	}

	public Integer getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(Integer jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getJobFunction() {
		return jobFunction;
	}

	public void setJobFunction(Integer jobFunction) {
		this.jobFunction = jobFunction;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getOrganizationUuid() {
		return organizationUuid;
	}

	public void setOrganizationUuid(String organizationUuid) {
		this.organizationUuid = organizationUuid;
	}

	public Integer getLastUpdateDateUnix() {
		return lastUpdateDateUnix;
	}

	public void setLastUpdateDateUnix(Integer lastUpdateDateUnix) {
		this.lastUpdateDateUnix = lastUpdateDateUnix;
	}

}
