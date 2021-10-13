package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_ca_owned_resource")
public class SdmCaOwnedResourceModel {
	
	@Id
	@Column(name="own_resource_uuid")
	private String ownResourceUuid;
	
	@Column(name="inactive")
	private Integer inactive;
	
	@Column(name="asset_type_id")
	private Integer assetTypeId;
	
	@Column(name="resource_name")
	private String resourceName;
	
	@Column(name="resource_description")
	private String resourceDescription;
	
	@Column(name="resource_family")
	private Integer resourceFamily;
	
	@Column(name="resource_class")
	private Integer resourceClass;
	
	@Column(name="resource_status")
	private Integer resourceStatus;
	
	@Column(name="manufacturer_uuid")
	private String manufacturerUuid;
	
	@Column(name="responsible_vendor_uuid")
	private String responsibleVendorUuid;
	
	@Column(name="maintenance_org_uuid")
	private String maintenanceOrgUuid;
	
	@Column(name="responsible_org_uuid")
	private String responsibleOrgUuid;
	
	@Column(name="org_bought_for_uuid")
	private String orgBoughtForUuid;
	
	@Column(name="resource_contact_uuid")
	private String resourceContactUuid;
	
	@Column(name="resource_owner_uuid")
	private String resourceOwnerUuid;
	
	@Column(name="location_uuid")
	private String locationUuid;
	
	@Column(name="floor_location")
	private String floorLocation;
	
	@Column(name="room_location")
	private String roomLocation;
	
	@Column(name="cabinet_location")
	private String cabinetLocation;
	
	@Column(name="shelf_location")
	private String shelfLocation;
	
	@Column(name="slot_location")
	private String slotLocation;
	
	@Column(name="model_uuid")
	private String modelUuid;
	
	@Column(name="host_name")
	private String hostName;
	
	@Column(name="mac_address")
	private String macAddress;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="resource_tag")
	private String resourceTag;
	
	@Column(name="operating_system")
	private Integer operatingSystem;
	
	@Column(name="product_version")
	private String productVersion;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="acquire_date")
	private Integer acquireDate;
	
	@Column(name="installation_date")
	private Integer installationDate;
	
	@Column(name="cost_center")
	private Integer costCenter;
	
	@Column(name="gl_code")
	private Integer glCode;
	
	@Column(name="resource_quantity")
	private Integer  resourceQuantity;
	
	@Column(name="requisition_id")
	private String requisitionId;
	
	@Column(name="purchase_order_id")
	private String purchaseOrderId;
	
	@Column(name="ufam")
	private Short ufam;
	
	@Column(name="creation_user")
	private String creationUser;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="creation_date_unix")
	private Integer creationDateUnix;
	
	@Column(name="last_update_user")
	private String lastUpdateUser;
	
	@Column(name="last_update_date")
	private Date lastUpdateDate;
	
	@Column(name="last_update_date_unix")
	private Integer lastUpdateDateUnix;
	
	@Column(name="version_number")
	private Integer versionNumber;
	
	@Column(name="supply_vendor_uuid")
	private String supplyVendorUuid;
	
	@Column(name="maintenance_vendor_uuid")
	private String maintenanceVendorUuid;
	
	@Column(name="company_bought_for_uuid")
	private String companyBoughtForUuid;
	
	@Column(name="resource_capacity_unit")
	private Integer resourceCapacityUnit;
	
	@Column(name="resource_capacity")
	private Float resourceCapacity;
	
	@Column(name="resource_alias")
	private String resourceAlias;
	
	@Column(name="asset_source_uuid")
	private String assetSourceUuid;
	
	@Column(name="license_uuid")
	private String licenseUuid;
	
	@Column(name="exclude_registration")
	private Integer excludeRegistration;
	
	@Column(name="delete_time")
	private Integer deleteTime;
	
	@Column(name="department")
	private Integer department;
	
	@Column(name="status_date")
	private Integer statusDate;
	
	@Column(name="license_information")
	private String licenseInformation;
	
	@Column(name="resource_subclass")
	private Integer resourceSubclass;
	
	@Column(name="audit_date")
	private Integer auditDate;
	
	@Column(name="exclude_reconciliation")
	private Short excludeReconciliation;
	
	@Column(name="dns_name")
	private String  dnsName;
	
	@Column(name="alternate_host_name")
	private String alternateHostName;
	
	@Column(name="discovery_last_run_date")
	private Integer discoveryLastRunDate;
	
	@Column(name="previous_resource_tag")
	private String previousResourceTag;
	
	@Column(name="processor_count")
	private Integer processorCount;
	
	@Column(name="processor_speed")
	private Float processorSpeed;
	
	@Column(name="processor_speed_unit")
	private Integer processorSpeedUnit;
	
	@Column(name="processor_type")
	private String processorType;
	
	@Column(name="reconciliation_date")
	private Integer reconciliationDate;
	
	@Column(name="total_disk_space")
	private Float totalDiskSpace;
	
	@Column(name="total_disk_space_unit")
	private Integer totalDiskSpaceUnit;
	
	@Column(name="total_memory")
	private Float totalMemory;
	
	@Column(name="total_memory_unit")
	private Integer totalMemoryUnit;
	
	@Column(name="billing_contact_uuid")
	private String billingContactUuid;
	
	@Column(name="support_contact1_uuid")
	private String supportContact1Uuid;
	
	@Column(name="support_contact2_uuid")
	private String supportContact2Uuid;
	
	@Column(name="support_contact3_uuid")
	private String supportContact3Uuid;
	
	@Column(name="disaster_recovery_contact_uuid")
	private String disasterRecoveryContactUuid;
	
	@Column(name="backup_services_contact_uuid")
	private String backupServicesContactUuid;
	
	@Column(name="network_contact_uuid")
	private String networkContactUuid;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="license_id")
	private Integer licenseId;
	
	@Column(name="resource_deployment_status")
	private Integer resourceDeploymentStatus;
	
	@Column(name="is_asset")
	private Short isAsset;
	
	@Column(name="is_ci")
	private Short isCi;
	
	@Column(name="lifecycle_status")
	private Integer lifecycleStatus;
	
	@Column(name="lifecycle_status_date")
	private Integer lifecycleStatusDate;
	
	@Column(name="own_resource_id")
	private Integer ownResourceId;
	
	@Column(name="date_insert")
	private Date dateInsert;

	public String getOwnResourceUuid() {
		return ownResourceUuid;
	}

	public void setOwnResourceUuid(String ownResourceUuid) {
		this.ownResourceUuid = ownResourceUuid;
	}

	public Integer getInactive() {
		return inactive;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}

	public Integer getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Integer assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public Integer getResourceFamily() {
		return resourceFamily;
	}

	public void setResourceFamily(Integer resourceFamily) {
		this.resourceFamily = resourceFamily;
	}

	public Integer getResourceClass() {
		return resourceClass;
	}

	public void setResourceClass(Integer resourceClass) {
		this.resourceClass = resourceClass;
	}

	public Integer getResourceStatus() {
		return resourceStatus;
	}

	public void setResourceStatus(Integer resourceStatus) {
		this.resourceStatus = resourceStatus;
	}

	public String getManufacturerUuid() {
		return manufacturerUuid;
	}

	public void setManufacturerUuid(String manufacturerUuid) {
		this.manufacturerUuid = manufacturerUuid;
	}

	public String getResponsibleVendorUuid() {
		return responsibleVendorUuid;
	}

	public void setResponsibleVendorUuid(String responsibleVendorUuid) {
		this.responsibleVendorUuid = responsibleVendorUuid;
	}

	public String getMaintenanceOrgUuid() {
		return maintenanceOrgUuid;
	}

	public void setMaintenanceOrgUuid(String maintenanceOrgUuid) {
		this.maintenanceOrgUuid = maintenanceOrgUuid;
	}

	public String getResponsibleOrgUuid() {
		return responsibleOrgUuid;
	}

	public void setResponsibleOrgUuid(String responsibleOrgUuid) {
		this.responsibleOrgUuid = responsibleOrgUuid;
	}

	public String getOrgBoughtForUuid() {
		return orgBoughtForUuid;
	}

	public void setOrgBoughtForUuid(String orgBoughtForUuid) {
		this.orgBoughtForUuid = orgBoughtForUuid;
	}

	public String getResourceContactUuid() {
		return resourceContactUuid;
	}

	public void setResourceContactUuid(String resourceContactUuid) {
		this.resourceContactUuid = resourceContactUuid;
	}

	public String getResourceOwnerUuid() {
		return resourceOwnerUuid;
	}

	public void setResourceOwnerUuid(String resourceOwnerUuid) {
		this.resourceOwnerUuid = resourceOwnerUuid;
	}

	public String getLocationUuid() {
		return locationUuid;
	}

	public void setLocationUuid(String locationUuid) {
		this.locationUuid = locationUuid;
	}

	public String getFloorLocation() {
		return floorLocation;
	}

	public void setFloorLocation(String floorLocation) {
		this.floorLocation = floorLocation;
	}

	public String getRoomLocation() {
		return roomLocation;
	}

	public void setRoomLocation(String roomLocation) {
		this.roomLocation = roomLocation;
	}

	public String getCabinetLocation() {
		return cabinetLocation;
	}

	public void setCabinetLocation(String cabinetLocation) {
		this.cabinetLocation = cabinetLocation;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public String getSlotLocation() {
		return slotLocation;
	}

	public void setSlotLocation(String slotLocation) {
		this.slotLocation = slotLocation;
	}

	public String getModelUuid() {
		return modelUuid;
	}

	public void setModelUuid(String modelUuid) {
		this.modelUuid = modelUuid;
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

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getResourceTag() {
		return resourceTag;
	}

	public void setResourceTag(String resourceTag) {
		this.resourceTag = resourceTag;
	}

	public Integer getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(Integer operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getAcquireDate() {
		return acquireDate;
	}

	public void setAcquireDate(Integer acquireDate) {
		this.acquireDate = acquireDate;
	}

	public Integer getInstallationDate() {
		return installationDate;
	}

	public void setInstallationDate(Integer installationDate) {
		this.installationDate = installationDate;
	}

	public Integer getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(Integer costCenter) {
		this.costCenter = costCenter;
	}

	public Integer getGlCode() {
		return glCode;
	}

	public void setGlCode(Integer glCode) {
		this.glCode = glCode;
	}

	public Integer getResourceQuantity() {
		return resourceQuantity;
	}

	public void setResourceQuantity(Integer resourceQuantity) {
		this.resourceQuantity = resourceQuantity;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Short getUfam() {
		return ufam;
	}

	public void setUfam(Short ufam) {
		this.ufam = ufam;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getCreationDateUnix() {
		return creationDateUnix;
	}

	public void setCreationDateUnix(Integer creationDateUnix) {
		this.creationDateUnix = creationDateUnix;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Integer getLastUpdateDateUnix() {
		return lastUpdateDateUnix;
	}

	public void setLastUpdateDateUnix(Integer lastUpdateDateUnix) {
		this.lastUpdateDateUnix = lastUpdateDateUnix;
	}

	public Integer getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(Integer versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getSupplyVendorUuid() {
		return supplyVendorUuid;
	}

	public void setSupplyVendorUuid(String supplyVendorUuid) {
		this.supplyVendorUuid = supplyVendorUuid;
	}

	public String getMaintenanceVendorUuid() {
		return maintenanceVendorUuid;
	}

	public void setMaintenanceVendorUuid(String maintenanceVendorUuid) {
		this.maintenanceVendorUuid = maintenanceVendorUuid;
	}

	public String getCompanyBoughtForUuid() {
		return companyBoughtForUuid;
	}

	public void setCompanyBoughtForUuid(String companyBoughtForUuid) {
		this.companyBoughtForUuid = companyBoughtForUuid;
	}

	public Integer getResourceCapacityUnit() {
		return resourceCapacityUnit;
	}

	public void setResourceCapacityUnit(Integer resourceCapacityUnit) {
		this.resourceCapacityUnit = resourceCapacityUnit;
	}

	public Float getResourceCapacity() {
		return resourceCapacity;
	}

	public void setResourceCapacity(Float resourceCapacity) {
		this.resourceCapacity = resourceCapacity;
	}

	public String getResourceAlias() {
		return resourceAlias;
	}

	public void setResourceAlias(String resourceAlias) {
		this.resourceAlias = resourceAlias;
	}

	public String getAssetSourceUuid() {
		return assetSourceUuid;
	}

	public void setAssetSourceUuid(String assetSourceUuid) {
		this.assetSourceUuid = assetSourceUuid;
	}

	public String getLicenseUuid() {
		return licenseUuid;
	}

	public void setLicenseUuid(String licenseUuid) {
		this.licenseUuid = licenseUuid;
	}

	public Integer getExcludeRegistration() {
		return excludeRegistration;
	}

	public void setExcludeRegistration(Integer excludeRegistration) {
		this.excludeRegistration = excludeRegistration;
	}

	public Integer getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Integer deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Integer statusDate) {
		this.statusDate = statusDate;
	}

	public String getLicenseInformation() {
		return licenseInformation;
	}

	public void setLicenseInformation(String licenseInformation) {
		this.licenseInformation = licenseInformation;
	}

	public Integer getResourceSubclass() {
		return resourceSubclass;
	}

	public void setResourceSubclass(Integer resourceSubclass) {
		this.resourceSubclass = resourceSubclass;
	}

	public Integer getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Integer auditDate) {
		this.auditDate = auditDate;
	}

	public Short getExcludeReconciliation() {
		return excludeReconciliation;
	}

	public void setExcludeReconciliation(Short excludeReconciliation) {
		this.excludeReconciliation = excludeReconciliation;
	}

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	public String getAlternateHostName() {
		return alternateHostName;
	}

	public void setAlternateHostName(String alternateHostName) {
		this.alternateHostName = alternateHostName;
	}

	public Integer getDiscoveryLastRunDate() {
		return discoveryLastRunDate;
	}

	public void setDiscoveryLastRunDate(Integer discoveryLastRunDate) {
		this.discoveryLastRunDate = discoveryLastRunDate;
	}

	public String getPreviousResourceTag() {
		return previousResourceTag;
	}

	public void setPreviousResourceTag(String previousResourceTag) {
		this.previousResourceTag = previousResourceTag;
	}

	public Integer getProcessorCount() {
		return processorCount;
	}

	public void setProcessorCount(Integer processorCount) {
		this.processorCount = processorCount;
	}

	public Float getProcessorSpeed() {
		return processorSpeed;
	}

	public void setProcessorSpeed(Float processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	public Integer getProcessorSpeedUnit() {
		return processorSpeedUnit;
	}

	public void setProcessorSpeedUnit(Integer processorSpeedUnit) {
		this.processorSpeedUnit = processorSpeedUnit;
	}

	public String getProcessorType() {
		return processorType;
	}

	public void setProcessorType(String processorType) {
		this.processorType = processorType;
	}

	public Integer getReconciliationDate() {
		return reconciliationDate;
	}

	public void setReconciliationDate(Integer reconciliationDate) {
		this.reconciliationDate = reconciliationDate;
	}

	public Float getTotalDiskSpace() {
		return totalDiskSpace;
	}

	public void setTotalDiskSpace(Float totalDiskSpace) {
		this.totalDiskSpace = totalDiskSpace;
	}

	public Integer getTotalDiskSpaceUnit() {
		return totalDiskSpaceUnit;
	}

	public void setTotalDiskSpaceUnit(Integer totalDiskSpaceUnit) {
		this.totalDiskSpaceUnit = totalDiskSpaceUnit;
	}

	public Float getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(Float totalMemory) {
		this.totalMemory = totalMemory;
	}

	public Integer getTotalMemoryUnit() {
		return totalMemoryUnit;
	}

	public void setTotalMemoryUnit(Integer totalMemoryUnit) {
		this.totalMemoryUnit = totalMemoryUnit;
	}

	public String getBillingContactUuid() {
		return billingContactUuid;
	}

	public void setBillingContactUuid(String billingContactUuid) {
		this.billingContactUuid = billingContactUuid;
	}

	public String getSupportContact1Uuid() {
		return supportContact1Uuid;
	}

	public void setSupportContact1Uuid(String supportContact1Uuid) {
		this.supportContact1Uuid = supportContact1Uuid;
	}

	public String getSupportContact2Uuid() {
		return supportContact2Uuid;
	}

	public void setSupportContact2Uuid(String supportContact2Uuid) {
		this.supportContact2Uuid = supportContact2Uuid;
	}

	public String getSupportContact3Uuid() {
		return supportContact3Uuid;
	}

	public void setSupportContact3Uuid(String supportContact3Uuid) {
		this.supportContact3Uuid = supportContact3Uuid;
	}

	public String getDisasterRecoveryContactUuid() {
		return disasterRecoveryContactUuid;
	}

	public void setDisasterRecoveryContactUuid(String disasterRecoveryContactUuid) {
		this.disasterRecoveryContactUuid = disasterRecoveryContactUuid;
	}

	public String getBackupServicesContactUuid() {
		return backupServicesContactUuid;
	}

	public void setBackupServicesContactUuid(String backupServicesContactUuid) {
		this.backupServicesContactUuid = backupServicesContactUuid;
	}

	public String getNetworkContactUuid() {
		return networkContactUuid;
	}

	public void setNetworkContactUuid(String networkContactUuid) {
		this.networkContactUuid = networkContactUuid;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Integer getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(Integer licenseId) {
		this.licenseId = licenseId;
	}

	public Integer getResourceDeploymentStatus() {
		return resourceDeploymentStatus;
	}

	public void setResourceDeploymentStatus(Integer resourceDeploymentStatus) {
		this.resourceDeploymentStatus = resourceDeploymentStatus;
	}

	public Short getIsAsset() {
		return isAsset;
	}

	public void setIsAsset(Short isAsset) {
		this.isAsset = isAsset;
	}

	public Short getIsCi() {
		return isCi;
	}

	public void setIsCi(Short isCi) {
		this.isCi = isCi;
	}

	public Integer getLifecycleStatus() {
		return lifecycleStatus;
	}

	public void setLifecycleStatus(Integer lifecycleStatus) {
		this.lifecycleStatus = lifecycleStatus;
	}

	public Integer getLifecycleStatusDate() {
		return lifecycleStatusDate;
	}

	public void setLifecycleStatusDate(Integer lifecycleStatusDate) {
		this.lifecycleStatusDate = lifecycleStatusDate;
	}

	public Integer getOwnResourceId() {
		return ownResourceId;
	}

	public void setOwnResourceId(Integer ownResourceId) {
		this.ownResourceId = ownResourceId;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	

}
