package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="sdm_act_log")
public class SdmActLogModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="persid")
	private String persid;
	
	@Column(name="call_req_id")
	private String callReqId;
	
	@Column(name="last_mod_dt")
	private Date lastModDt;
	
	@Column(name="time_spent")
	private Integer timeSpent;
	
	@Column(name="time_stamp")
	private Date timeStamp;
	
	@Column(name="system_time")
	private Date systemTime;
	
	@Column(name="analyst")
	private String analyst;
	
	@Column(name="description", columnDefinition="Text")
	private String description;
	
	@Column(name="action_desc", columnDefinition="Text")
	private String actionDesc;
	
	@Column(name="type")
	private String type;
	
	@Column(name="date_insert")
	private Date dateInsert;
	
	@Column(name="system_time_unix")
	private Integer systemTimeUnix;
	
//	@Column(name="knowledge_session")
//	private String knowledgeSession;
	
//	@Column(name="knowledge_tool")
//	private String knowledge_tool;
	
//	@Column(name="internal")
//	private String internal;
	
//	@Column(name="tenant")
//	private String tenant;
	
//	@Column(name="rel_ticket_type")
//	private String relTicketType;
	
//	@Column(name="zcoment_padre_ahijo")
//	private Integer zcomentPadreAhijo;
	
//	@Column(name="zClarityLastSync")
//	private Integer zClarityLastSync;
	
//	@Column(name="zcoment_padre_ahijo_ok")
//	private Integer zcomentPadreAhijoOk;

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

	public String getCallReqId() {
		return callReqId;
	}

	public void setCallReqId(String callReqId) {
		this.callReqId = callReqId;
	}

	public Date getLastModDt() {
		return lastModDt;
	}

	public void setLastModDt(Date lastModDt) {
		this.lastModDt = lastModDt;
	}

	public Integer getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(Integer timeSpent) {
		this.timeSpent = timeSpent;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Date getSystemTime() {
		return systemTime;
	}

	public void setSystemTime(Date systemTime) {
		this.systemTime = systemTime;
	}

	public String getAnalyst() {
		return analyst;
	}

	public void setAnalyst(String analyst) {
		this.analyst = analyst;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	public Integer getSystemTimeUnix() {
		return systemTimeUnix;
	}

	public void setSystemTimeUnix(Integer systemTimeUnix) {
		this.systemTimeUnix = systemTimeUnix;
	}

//	public String getKnowledgeSession() {
//		return knowledgeSession;
//	}
//
//	public void setKnowledgeSession(String knowledgeSession) {
//		this.knowledgeSession = knowledgeSession;
//	}

//	public String getKnowledge_tool() {
//		return knowledge_tool;
//	}
//
//	public void setKnowledge_tool(String knowledge_tool) {
//		this.knowledge_tool = knowledge_tool;
//	}

//	public String getInternal() {
//		return internal;
//	}
//
//	public void setInternal(String internal) {
//		this.internal = internal;
//	}

//	public String getTenant() {
//		return tenant;
//	}
//
//	public void setTenant(String tenant) {
//		this.tenant = tenant;
//	}

//	public String getRelTicketType() {
//		return relTicketType;
//	}
//
//	public void setRelTicketType(String relTicketType) {
//		this.relTicketType = relTicketType;
//	}

//	public Integer getZcomentPadreAhijo() {
//		return zcomentPadreAhijo;
//	}
//
//	public void setZcomentPadreAhijo(Integer zcomentPadreAhijo) {
//		this.zcomentPadreAhijo = zcomentPadreAhijo;
//	}

//	public Integer getzClarityLastSync() {
//		return zClarityLastSync;
//	}
//
//	public void setzClarityLastSync(Integer zClarityLastSync) {
//		this.zClarityLastSync = zClarityLastSync;
//	}

//	public Integer getZcomentPadreAhijoOk() {
//		return zcomentPadreAhijoOk;
//	}
//
//	public void setZcomentPadreAhijoOk(Integer zcomentPadreAhijoOk) {
//		this.zcomentPadreAhijoOk = zcomentPadreAhijoOk;
//	}
//	
	
}
