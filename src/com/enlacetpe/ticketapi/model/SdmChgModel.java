package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_chg")
public class SdmChgModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="persid")
	private String persid;
	
	@Column(name="chg_ref_num")
	private String chgRefNum;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="description", columnDefinition="Text")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="active_flag")
	private Integer activeFlag;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="open_date")
	private Date openDate;
	
	@Column(name="open_date_unix")
	private Integer openDateUnix;
	
	@Column(name="last_mod_dt")
	private Date lastModDt;
	
	@Column(name="last_mod_dt_unix")
	private Integer lastModDtUnix;
	
	@Column(name="last_mod_by")
	private String lastModBy;
	
	@Column(name="close_date")
	private Date closeDate;
	
	@Column(name="resolve_date")
	private Date resolveDate;
	
	@Column(name="rootcause")
	private Integer rootcause;
	
	@Column(name="est_total_time")
	private Integer estTotalTime;
	
	@Column(name="actual_total_time")
	private Integer actualTotalTime;
	
	@Column(name="log_agent")
	private String logAgent;
	
	@Column(name="assignee")
	private String assigne;
	
	@Column(name="organization")
	private String organization;
	
	@Column(name="group_id")
	private String groupId;
	
	@Column(name="affected_contact")
	private String affectedContact;
	
	@Column(name="requestor")
	private String requestor;
	
	@Column(name="category")
	private String catgory;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="need_by")
	private Date needBy;
	
	@Column(name="est_comp_date")
	private Date estCompDate;
	
	@Column(name="actual_comp_date")
	private Date actualCompDate;
	
	@Column(name="est_cost")
	private Integer estCost;
	
	@Column(name="actual_cost")
	private Integer actualCost;
	
	@Column(name="justification", columnDefinition="Text")
	private String justificacion;
	
	@Column(name="impact")
	private Integer impact;
	
	@Column(name="parent")
	private Integer parent;
	
	@Column(name="effort",columnDefinition="Text")
	private String effort;
	
	@Column(name="support_lev")
	private String supportLev;
	
	@Column(name="sla_violation")
	private Integer slaViolation;
	
	@Column(name="predicted_sla_viol")
	private Integer predictedSlaViol;
	
	@Column(name="macro_predict_viol")
	private Integer macroPredictViol;
	
	@Column(name="created_via")
	private Integer createdVia;
	
	@Column(name="call_bacl_date")
	private Date callBaclDate;
	
	@Column(name="call_back_flag")
	private Integer callBackFlag;
	
	@Column(name="string1")
	private String string1;
	
	@Column(name="flag1")
	private Integer flag1;
	
	@Column(name="flag2")
	private Integer flag2;
	
	@Column(name="flag3")
	private Integer flag3;
	
	@Column(name="flag4")
	private Integer flag4;
	
	@Column(name="flag5")
	private Integer flag5;
	
	@Column(name="flag6")
	private Integer flag6;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="chgtype")
	private Integer chgtype;
	
	@Column(name="sched_start_date")
	private Date schedStartDate;
	
	@Column(name="sched_end_date")
	private Date schedEndDate;
	
	@Column(name="sched_duration")
	private Integer schedDuration;
	
	@Column(name="actual_start_date")
	private Date actualStartDate;
	
	@Column(name="actual_end_date")
	private Date actualEndDate;
	
	@Column(name="business_case", columnDefinition="text")
	private String businessCase;
	
	@Column(name="cab",columnDefinition="text")
	private String cab;
	
	@Column(name="cab_approval")
	private Integer cabApproval;
	
	@Column(name="closure_code")
	private Integer closureCode;
	
	@Column(name="risk")
	private Integer risk;
	
	@Column(name="external_system_ticket",columnDefinition="Text")
	private String externalSystemTicket;
	
	@Column(name="target_closed_count")
	private Integer targetClosedCount;
	
	@Column(name="target_hold_count")
	private Integer targetHoldCount;
	
	@Column(name="target_resolved_count")
	private Integer targetResolvedCount;
	
	@Column(name="target_start_last")
	private Date targetStartLast;
	
	@Column(name="has_CI")
	private Integer hasCI;
	
	@Column(name="has_ci_planned_change")
	private Integer hasCiPlannedChange;
	
	@Column(name="zcategory_init")
	private String zcategoryInit;
	
	@Column(name="zchg_bus_cls")
	private Integer zchgBusCls;
	
	@Column(name="zurgencia")
	private Integer zurgencia;
	
	@Column(name="zReq_Mon_id")
	private Integer zReqMonId;
	
	@Column(name="zReq_Mon")
	private Integer zReqMon;
	
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

	public String getChgRefNum() {
		return chgRefNum;
	}

	public void setChgRefNum(String chgRefNum) {
		this.chgRefNum = chgRefNum;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Integer getOpenDateUnix() {
		return openDateUnix;
	}

	public void setOpenDateUnix(Integer openDateUnix) {
		this.openDateUnix = openDateUnix;
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

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Date getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(Date resolveDate) {
		this.resolveDate = resolveDate;
	}

	public Integer getRootcause() {
		return rootcause;
	}

	public void setRootcause(Integer rootcause) {
		this.rootcause = rootcause;
	}

	public Integer getEstTotalTime() {
		return estTotalTime;
	}

	public void setEstTotalTime(Integer estTotalTime) {
		this.estTotalTime = estTotalTime;
	}

	public Integer getActualTotalTime() {
		return actualTotalTime;
	}

	public void setActualTotalTime(Integer actualTotalTime) {
		this.actualTotalTime = actualTotalTime;
	}

	public String getLogAgent() {
		return logAgent;
	}

	public void setLogAgent(String logAgent) {
		this.logAgent = logAgent;
	}

	public String getAssigne() {
		return assigne;
	}

	public void setAssigne(String assigne) {
		this.assigne = assigne;
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

	public String getAffectedContact() {
		return affectedContact;
	}

	public void setAffectedContact(String affectedContact) {
		this.affectedContact = affectedContact;
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getCatgory() {
		return catgory;
	}

	public void setCatgory(String catgory) {
		this.catgory = catgory;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getNeedBy() {
		return needBy;
	}

	public void setNeedBy(Date needBy) {
		this.needBy = needBy;
	}

	public Date getEstCompDate() {
		return estCompDate;
	}

	public void setEstCompDate(Date estCompDate) {
		this.estCompDate = estCompDate;
	}

	public Date getActualCompDate() {
		return actualCompDate;
	}

	public void setActualCompDate(Date actualCompDate) {
		this.actualCompDate = actualCompDate;
	}

	public Integer getEstCost() {
		return estCost;
	}

	public void setEstCost(Integer estCost) {
		this.estCost = estCost;
	}

	public Integer getActualCost() {
		return actualCost;
	}

	public void setActualCost(Integer actualCost) {
		this.actualCost = actualCost;
	}

	public String getJustificacion() {
		return justificacion;
	}

	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	public Integer getImpact() {
		return impact;
	}

	public void setImpact(Integer impact) {
		this.impact = impact;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public String getEffort() {
		return effort;
	}

	public void setEffort(String effort) {
		this.effort = effort;
	}

	public String getSupportLev() {
		return supportLev;
	}

	public void setSupportLev(String supportLev) {
		this.supportLev = supportLev;
	}

	public Integer getSlaViolation() {
		return slaViolation;
	}

	public void setSlaViolation(Integer slaViolation) {
		this.slaViolation = slaViolation;
	}

	public Integer getPredictedSlaViol() {
		return predictedSlaViol;
	}

	public void setPredictedSlaViol(Integer predictedSlaViol) {
		this.predictedSlaViol = predictedSlaViol;
	}

	public Integer getMacroPredictViol() {
		return macroPredictViol;
	}

	public void setMacroPredictViol(Integer macroPredictViol) {
		this.macroPredictViol = macroPredictViol;
	}

	public Integer getCreatedVia() {
		return createdVia;
	}

	public void setCreatedVia(Integer createdVia) {
		this.createdVia = createdVia;
	}

	public Date getCallBaclDate() {
		return callBaclDate;
	}

	public void setCallBaclDate(Date callBaclDate) {
		this.callBaclDate = callBaclDate;
	}

	public Integer getCallBackFlag() {
		return callBackFlag;
	}

	public void setCallBackFlag(Integer callBackFlag) {
		this.callBackFlag = callBackFlag;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public Integer getFlag1() {
		return flag1;
	}

	public void setFlag1(Integer flag1) {
		this.flag1 = flag1;
	}

	public Integer getFlag2() {
		return flag2;
	}

	public void setFlag2(Integer flag2) {
		this.flag2 = flag2;
	}

	public Integer getFlag3() {
		return flag3;
	}

	public void setFlag3(Integer flag3) {
		this.flag3 = flag3;
	}

	public Integer getFlag4() {
		return flag4;
	}

	public void setFlag4(Integer flag4) {
		this.flag4 = flag4;
	}

	public Integer getFlag5() {
		return flag5;
	}

	public void setFlag5(Integer flag5) {
		this.flag5 = flag5;
	}

	public Integer getFlag6() {
		return flag6;
	}

	public void setFlag6(Integer flag6) {
		this.flag6 = flag6;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public Integer getChgtype() {
		return chgtype;
	}

	public void setChgtype(Integer chgtype) {
		this.chgtype = chgtype;
	}

	public Date getSchedStartDate() {
		return schedStartDate;
	}

	public void setSchedStartDate(Date schedStartDate) {
		this.schedStartDate = schedStartDate;
	}

	public Date getSchedEndDate() {
		return schedEndDate;
	}

	public void setSchedEndDate(Date schedEndDate) {
		this.schedEndDate = schedEndDate;
	}

	public Integer getSchedDuration() {
		return schedDuration;
	}

	public void setSchedDuration(Integer schedDuration) {
		this.schedDuration = schedDuration;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getBusinessCase() {
		return businessCase;
	}

	public void setBusinessCase(String businessCase) {
		this.businessCase = businessCase;
	}

	public String getCab() {
		return cab;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}

	public Integer getCabApproval() {
		return cabApproval;
	}

	public void setCabApproval(Integer cabApproval) {
		this.cabApproval = cabApproval;
	}

	public Integer getClosureCode() {
		return closureCode;
	}

	public void setClosureCode(Integer closureCode) {
		this.closureCode = closureCode;
	}

	public Integer getRisk() {
		return risk;
	}

	public void setRisk(Integer risk) {
		this.risk = risk;
	}

	public String getExternalSystemTicket() {
		return externalSystemTicket;
	}

	public void setExternalSystemTicket(String externalSystemTicket) {
		this.externalSystemTicket = externalSystemTicket;
	}

	public Integer getTargetClosedCount() {
		return targetClosedCount;
	}

	public void setTargetClosedCount(Integer targetClosedCount) {
		this.targetClosedCount = targetClosedCount;
	}

	public Integer getTargetHoldCount() {
		return targetHoldCount;
	}

	public void setTargetHoldCount(Integer targetHoldCount) {
		this.targetHoldCount = targetHoldCount;
	}

	public Integer getTargetResolvedCount() {
		return targetResolvedCount;
	}

	public void setTargetResolvedCount(Integer targetResolvedCount) {
		this.targetResolvedCount = targetResolvedCount;
	}

	public Date getTargetStartLast() {
		return targetStartLast;
	}

	public void setTargetStartLast(Date targetStartLast) {
		this.targetStartLast = targetStartLast;
	}

	public Integer getHasCI() {
		return hasCI;
	}

	public void setHasCI(Integer hasCI) {
		this.hasCI = hasCI;
	}

	public Integer getHasCiPlannedChange() {
		return hasCiPlannedChange;
	}

	public void setHasCiPlannedChange(Integer hasCiPlannedChange) {
		this.hasCiPlannedChange = hasCiPlannedChange;
	}

	public String getZcategoryInit() {
		return zcategoryInit;
	}

	public void setZcategoryInit(String zcategoryInit) {
		this.zcategoryInit = zcategoryInit;
	}

	public Integer getZchgBusCls() {
		return zchgBusCls;
	}

	public void setZchgBusCls(Integer zchgBusCls) {
		this.zchgBusCls = zchgBusCls;
	}

	public Integer getZurgencia() {
		return zurgencia;
	}

	public void setZurgencia(Integer zurgencia) {
		this.zurgencia = zurgencia;
	}

	public Integer getzReqMonId() {
		return zReqMonId;
	}

	public void setzReqMonId(Integer zReqMonId) {
		this.zReqMonId = zReqMonId;
	}

	public Integer getzReqMon() {
		return zReqMon;
	}

	public void setzReqMon(Integer zReqMon) {
		this.zReqMon = zReqMon;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	

}
