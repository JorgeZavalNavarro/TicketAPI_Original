package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sdm_usp_owned_resource")
public class SdmUspOwnedResourceModel {

	@Id
	@Column(name = "owned_resource_uuid")
	private String ownedResourceUuid;

	@Column(name = "nr_prim_skt_id")
	private Integer nrPrimSktId;

	@Column(name = "nr_pr_id")
	private Integer nrPrId;

	@Column(name = "nr_wrty_st_dt")
	private Integer nrWrtyStDt;

	@Column(name = "nr_wrty_end_dt")
	private Integer nrWrtyEndDt;

	@Column(name = "nr_exp_dt")
	private Integer nrExpDt;

	@Column(name = "nr_sla_id")
	private Integer nrSlaId;

	@Column(name = "nr_nx_string1")
	private String nrNxString1;

	@Column(name = "nr_nx_string2")
	private String nrNxString2;

	@Column(name = "nr_nx_string3")
	private String nrNxString3;

	@Column(name = "nr_nx_string4")
	private String nrNxString4;

	@Column(name = "nr_nx_string5")
	private String nrNxString5;

	@Column(name = "nr_nx_string6")
	private String nrNxString6;

	@Column(name = "nr_nx_ref_1")
	private String nrNxRef1;

	@Column(name = "nr_nx_ref_2")
	private String nrNxRef2;

	@Column(name = "nr_nx_ref_3")
	private String nrNxRef3;

	@Column(name = "nr_financial_id")
	private String nrFinancialId;

	@Column(name = "nr_service_type")
	private String nrServiceType;

	@Column(name = "nr_argis_id")
	private String nrArgisId;

	@Column(name = "nr_bms")
	private Integer nrBms;

	@Column(name = "nr_bmlabel")
	private String nrBmlable;

	@Column(name = "nr_bm_rep")
	private Integer nrBmRep;

	@Column(name = "baseline_uuid")
	private String baselineUuid;

	@Column(name = "service_impact")
	private Integer serviceImpact;

	@Column(name = "zDML_path")
	private String zDMLPath;

	@Column(name = "zSPMLifecycleStage")
	private Integer zSPMLifecycleStage;

	@Column(name = "zactual_budget")
	private Integer zactualBudget;

	@Column(name = "zbiz_proc_supported")
	private String zbizProcSupported;

	@Column(name = "zbusiness_approver_group")
	private String zbusinessApproverGroup;

	@Column(name = "zbusiness_impact")
	private Integer zbusinessImpact;

	@Column(name = "zbusiness_owners")
	private String zbusinessOwners;

	@Column(name = "zbusiness_users")
	private String zbusinessUsers;

	@Column(name = "zcharges_service")
	private Integer zchargesService;

	@Column(name = "zchg_bus_cls")
	private Integer zchgBusCls;

	@Column(name = "zci_cost_category")
	private Integer zciCostCategory;

	@Column(name = "zcost_biz_units")
	private String zcostBizUnits;

	@Column(name = "zcost_hw_maintenance")
	private Integer zcostHwMaintenance;

	@Column(name = "zcost_hw_purchases")
	private Integer zcostHwPurchases;

	@Column(name = "zcost_personnel")
	private Integer zcostPersonnel;

	@Column(name = "zcost_service")
	private Integer zcostService;

	@Column(name = "zcost_sw_licenses")
	private Integer zcostSwLicenses;

	@Column(name = "zcost_sw_maintenance")
	private Integer zcostSwMaintenance;

	@Column(name = "zcost_utility")
	private Integer zcostUtility;

	@Column(name = "zcurrentAvailability")
	private Integer zcurrentAvailability;

	@Column(name = "zcurrentCapacity")
	private Integer zcurrentCapacity;

	@Column(name = "zcurrentPerformance")
	private Integer zcurrentPerformance;

	@Column(name = "zcurrent_monthly_service_cost")
	private Integer zcurrentMonthlyServiceCost;

	@Column(name = "zest_budget")
	private Integer zestBudget;

	@Column(name = "zpost_program_ROI")
	private Integer zpostProgramROI;

	@Column(name = "zpre_program_ROI")
	private Integer zpreProgramROI;

	@Column(name = "zprevAvailability")
	private Integer zprevAvailability;

	@Column(name = "zprevCapacity")
	private Integer zprevCapacity;

	@Column(name = "zprevPerformance")
	private Integer zprevPerformance;

	@Column(name = "zprice_service")
	private Integer zpriceService;

	@Column(name = "zrelease_package_num")
	private Integer zreleasePackageNum;

	@Column(name = "zrevenue_service")
	private Integer zrevenueService;

	@Column(name = "zservice_description")
	private String zserviceDescription;

	@Column(name = "zstakeholders_group")
	private String zstakeholdersGroup;

	@Column(name = "ztechnical_approver_group")
	private String ztechnicalApproverGroup;

	@Column(name = "zvalue_prop")
	private String zvalueProp;

	@Column(name = "zcpe")
	private String zcpe;

	@Column(name = "zorg_propietaria")
	private String zorgPropietaria;

	@Column(name = "ztag")
	private String ztag;

	@Column(name = "DATE_INSERT")
	private Date dateInsert;

	//@Column(name = "zregion")
	//private String zRegion;

	public String getOwnedResourceUuid() {
		return ownedResourceUuid;
	}

	public void setOwnedResourceUuid(String ownedResourceUuid) {
		this.ownedResourceUuid = ownedResourceUuid;
	}

	public Integer getNrPrimSktId() {
		return nrPrimSktId;
	}

	public void setNrPrimSktId(Integer nrPrimSktId) {
		this.nrPrimSktId = nrPrimSktId;
	}

	public Integer getNrPrId() {
		return nrPrId;
	}

	public void setNrPrId(Integer nrPrId) {
		this.nrPrId = nrPrId;
	}

	public Integer getNrWrtyStDt() {
		return nrWrtyStDt;
	}

	public void setNrWrtyStDt(Integer nrWrtyStDt) {
		this.nrWrtyStDt = nrWrtyStDt;
	}

	public Integer getNrWrtyEndDt() {
		return nrWrtyEndDt;
	}

	public void setNrWrtyEndDt(Integer nrWrtyEndDt) {
		this.nrWrtyEndDt = nrWrtyEndDt;
	}

	public Integer getNrExpDt() {
		return nrExpDt;
	}

	public void setNrExpDt(Integer nrExpDt) {
		this.nrExpDt = nrExpDt;
	}

	public Integer getNrSlaId() {
		return nrSlaId;
	}

	public void setNrSlaId(Integer nrSlaId) {
		this.nrSlaId = nrSlaId;
	}

	public String getNrNxString1() {
		return nrNxString1;
	}

	public void setNrNxString1(String nrNxString1) {
		this.nrNxString1 = nrNxString1;
	}

	public String getNrNxString2() {
		return nrNxString2;
	}

	public void setNrNxString2(String nrNxString2) {
		this.nrNxString2 = nrNxString2;
	}

	public String getNrNxString3() {
		return nrNxString3;
	}

	public void setNrNxString3(String nrNxString3) {
		this.nrNxString3 = nrNxString3;
	}

	public String getNrNxString4() {
		return nrNxString4;
	}

	public void setNrNxString4(String nrNxString4) {
		this.nrNxString4 = nrNxString4;
	}

	public String getNrNxString5() {
		return nrNxString5;
	}

	public void setNrNxString5(String nrNxString5) {
		this.nrNxString5 = nrNxString5;
	}

	public String getNrNxString6() {
		return nrNxString6;
	}

	public void setNrNxString6(String nrNxString6) {
		this.nrNxString6 = nrNxString6;
	}

	public String getNrNxRef1() {
		return nrNxRef1;
	}

	public void setNrNxRef1(String nrNxRef1) {
		this.nrNxRef1 = nrNxRef1;
	}

	public String getNrNxRef2() {
		return nrNxRef2;
	}

	public void setNrNxRef2(String nrNxRef2) {
		this.nrNxRef2 = nrNxRef2;
	}

	public String getNrNxRef3() {
		return nrNxRef3;
	}

	public void setNrNxRef3(String nrNxRef3) {
		this.nrNxRef3 = nrNxRef3;
	}

	public String getNrFinancialId() {
		return nrFinancialId;
	}

	public void setNrFinancialId(String nrFinancialId) {
		this.nrFinancialId = nrFinancialId;
	}

	public String getNrServiceType() {
		return nrServiceType;
	}

	public void setNrServiceType(String nrServiceType) {
		this.nrServiceType = nrServiceType;
	}

	public String getNrArgisId() {
		return nrArgisId;
	}

	public void setNrArgisId(String nrArgisId) {
		this.nrArgisId = nrArgisId;
	}

	public Integer getNrBms() {
		return nrBms;
	}

	public void setNrBms(Integer nrBms) {
		this.nrBms = nrBms;
	}

	public String getNrBmlable() {
		return nrBmlable;
	}

	public void setNrBmlable(String nrBmlable) {
		this.nrBmlable = nrBmlable;
	}

	public Integer getNrBmRep() {
		return nrBmRep;
	}

	public void setNrBmRep(Integer nrBmRep) {
		this.nrBmRep = nrBmRep;
	}

	public String getBaselineUuid() {
		return baselineUuid;
	}

	public void setBaselineUuid(String baselineUuid) {
		this.baselineUuid = baselineUuid;
	}

	public Integer getServiceImpact() {
		return serviceImpact;
	}

	public void setServiceImpact(Integer serviceImpact) {
		this.serviceImpact = serviceImpact;
	}

	public String getzDMLPath() {
		return zDMLPath;
	}

	public void setzDMLPath(String zDMLPath) {
		this.zDMLPath = zDMLPath;
	}

	public Integer getzSPMLifecycleStage() {
		return zSPMLifecycleStage;
	}

	public void setzSPMLifecycleStage(Integer zSPMLifecycleStage) {
		this.zSPMLifecycleStage = zSPMLifecycleStage;
	}

	public Integer getZactualBudget() {
		return zactualBudget;
	}

	public void setZactualBudget(Integer zactualBudget) {
		this.zactualBudget = zactualBudget;
	}

	public String getZbizProcSupported() {
		return zbizProcSupported;
	}

	public void setZbizProcSupported(String zbizProcSupported) {
		this.zbizProcSupported = zbizProcSupported;
	}

	public String getZbusinessApproverGroup() {
		return zbusinessApproverGroup;
	}

	public void setZbusinessApproverGroup(String zbusinessApproverGroup) {
		this.zbusinessApproverGroup = zbusinessApproverGroup;
	}

	public Integer getZbusinessImpact() {
		return zbusinessImpact;
	}

	public void setZbusinessImpact(Integer zbusinessImpact) {
		this.zbusinessImpact = zbusinessImpact;
	}

	public String getZbusinessOwners() {
		return zbusinessOwners;
	}

	public void setZbusinessOwners(String zbusinessOwners) {
		this.zbusinessOwners = zbusinessOwners;
	}

	public String getZbusinessUsers() {
		return zbusinessUsers;
	}

	public void setZbusinessUsers(String zbusinessUsers) {
		this.zbusinessUsers = zbusinessUsers;
	}

	public Integer getZchargesService() {
		return zchargesService;
	}

	public void setZchargesService(Integer zchargesService) {
		this.zchargesService = zchargesService;
	}

	public Integer getZchgBusCls() {
		return zchgBusCls;
	}

	public void setZchgBusCls(Integer zchgBusCls) {
		this.zchgBusCls = zchgBusCls;
	}

	public Integer getZciCostCategory() {
		return zciCostCategory;
	}

	public void setZciCostCategory(Integer zciCostCategory) {
		this.zciCostCategory = zciCostCategory;
	}

	public String getZcostBizUnits() {
		return zcostBizUnits;
	}

	public void setZcostBizUnits(String zcostBizUnits) {
		this.zcostBizUnits = zcostBizUnits;
	}

	public Integer getZcostHwMaintenance() {
		return zcostHwMaintenance;
	}

	public void setZcostHwMaintenance(Integer zcostHwMaintenance) {
		this.zcostHwMaintenance = zcostHwMaintenance;
	}

	public Integer getZcostHwPurchases() {
		return zcostHwPurchases;
	}

	public void setZcostHwPurchases(Integer zcostHwPurchases) {
		this.zcostHwPurchases = zcostHwPurchases;
	}

	public Integer getZcostPersonnel() {
		return zcostPersonnel;
	}

	public void setZcostPersonnel(Integer zcostPersonnel) {
		this.zcostPersonnel = zcostPersonnel;
	}

	public Integer getZcostService() {
		return zcostService;
	}

	public void setZcostService(Integer zcostService) {
		this.zcostService = zcostService;
	}

	public Integer getZcostSwLicenses() {
		return zcostSwLicenses;
	}

	public void setZcostSwLicenses(Integer zcostSwLicenses) {
		this.zcostSwLicenses = zcostSwLicenses;
	}

	public Integer getZcostSwMaintenance() {
		return zcostSwMaintenance;
	}

	public void setZcostSwMaintenance(Integer zcostSwMaintenance) {
		this.zcostSwMaintenance = zcostSwMaintenance;
	}

	public Integer getZcostUtility() {
		return zcostUtility;
	}

	public void setZcostUtility(Integer zcostUtility) {
		this.zcostUtility = zcostUtility;
	}

	public Integer getZcurrentAvailability() {
		return zcurrentAvailability;
	}

	public void setZcurrentAvailability(Integer zcurrentAvailability) {
		this.zcurrentAvailability = zcurrentAvailability;
	}

	public Integer getZcurrentCapacity() {
		return zcurrentCapacity;
	}

	public void setZcurrentCapacity(Integer zcurrentCapacity) {
		this.zcurrentCapacity = zcurrentCapacity;
	}

	public Integer getZcurrentPerformance() {
		return zcurrentPerformance;
	}

	public void setZcurrentPerformance(Integer zcurrentPerformance) {
		this.zcurrentPerformance = zcurrentPerformance;
	}

	public Integer getZcurrentMonthlyServiceCost() {
		return zcurrentMonthlyServiceCost;
	}

	public void setZcurrentMonthlyServiceCost(Integer zcurrentMonthlyServiceCost) {
		this.zcurrentMonthlyServiceCost = zcurrentMonthlyServiceCost;
	}

	public Integer getZestBudget() {
		return zestBudget;
	}

	public void setZestBudget(Integer zestBudget) {
		this.zestBudget = zestBudget;
	}

	public Integer getZpostProgramROI() {
		return zpostProgramROI;
	}

	public void setZpostProgramROI(Integer zpostProgramROI) {
		this.zpostProgramROI = zpostProgramROI;
	}

	public Integer getZpreProgramROI() {
		return zpreProgramROI;
	}

	public void setZpreProgramROI(Integer zpreProgramROI) {
		this.zpreProgramROI = zpreProgramROI;
	}

	public Integer getZprevAvailability() {
		return zprevAvailability;
	}

	public void setZprevAvailability(Integer zprevAvailability) {
		this.zprevAvailability = zprevAvailability;
	}

	public Integer getZprevCapacity() {
		return zprevCapacity;
	}

	public void setZprevCapacity(Integer zprevCapacity) {
		this.zprevCapacity = zprevCapacity;
	}

	public Integer getZprevPerformance() {
		return zprevPerformance;
	}

	public void setZprevPerformance(Integer zprevPerformance) {
		this.zprevPerformance = zprevPerformance;
	}

	public Integer getZpriceService() {
		return zpriceService;
	}

	public void setZpriceService(Integer zpriceService) {
		this.zpriceService = zpriceService;
	}

	public Integer getZreleasePackageNum() {
		return zreleasePackageNum;
	}

	public void setZreleasePackageNum(Integer zreleasePackageNum) {
		this.zreleasePackageNum = zreleasePackageNum;
	}

	public Integer getZrevenueService() {
		return zrevenueService;
	}

	public void setZrevenueService(Integer zrevenueService) {
		this.zrevenueService = zrevenueService;
	}

	public String getZserviceDescription() {
		return zserviceDescription;
	}

	public void setZserviceDescription(String zserviceDescription) {
		this.zserviceDescription = zserviceDescription;
	}

	public String getZstakeholdersGroup() {
		return zstakeholdersGroup;
	}

	public void setZstakeholdersGroup(String zstakeholdersGroup) {
		this.zstakeholdersGroup = zstakeholdersGroup;
	}

	public String getZtechnicalApproverGroup() {
		return ztechnicalApproverGroup;
	}

	public void setZtechnicalApproverGroup(String ztechnicalApproverGroup) {
		this.ztechnicalApproverGroup = ztechnicalApproverGroup;
	}

	public String getZvalueProp() {
		return zvalueProp;
	}

	public void setZvalueProp(String zvalueProp) {
		this.zvalueProp = zvalueProp;
	}

	public String getZcpe() {
		return zcpe;
	}

	public void setZcpe(String zcpe) {
		this.zcpe = zcpe;
	}

	public String getZorgPropietaria() {
		return zorgPropietaria;
	}

	public void setZorgPropietaria(String zorgPropietaria) {
		this.zorgPropietaria = zorgPropietaria;
	}

	public String getZtag() {
		return ztag;
	}

	public void setZtag(String ztag) {
		this.ztag = ztag;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}


}
