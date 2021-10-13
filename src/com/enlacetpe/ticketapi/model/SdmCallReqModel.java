package com.enlacetpe.ticketapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sdm_call_req")
public class SdmCallReqModel {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="persid")
	private String persid;
	
	@Column(name="ref_num")
	private String refNum;
		
	@Column(name="summary")
	private String summary;
	
	@Column(name="description", columnDefinition="Text")
	private String description;
	
	@Column(name="status")
	private String status;
	
	@Column(name="active_flag")
	private Integer activeFlag;
	
	@Column(name="open_date")
	private Date openDate;
	
	@Column(name="open_date_unix")
	private Integer openDateUnix;
	
	@Column(name="time_spent_sum")
	private Integer timeSpentSum;
	
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
	
	@Column(name="log_agent")
	private String logAgent;
	
	@Column(name="assignee")
	private String assignee;
	
	@Column(name="group_id")
	private String groupId;
	
	@Column(name="customer")
	private String customer;
	
	@Column(name="category")
	private String category;
	
	@Column(name="solution")
	private String solution;
	
	@Column(name="impact")
	private Integer impact;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="urgency")
	private Integer urgency;
	
	@Column(name="severity")
	private Integer severety;
	
	@Column(name="sla_violation")
	private Integer slaViolation;
	
	@Column(name="predicted_sla_viol")
	private Integer predictedSlaViol;
	
	@Column(name="macro_predict_viol")
	private Integer macroPredictViol;
	
	@Column(name="created_via")
	private Integer createdVia;
	
	@Column(name="call_back_flag")
	private Integer callBackFlag;
	
	@Column(name="type")
	private String type;
	
	@Column(name="problem")
	private String problem;
	
	@Column(name="incident_priority")
	private Integer incidentPriority;
	
	@Column(name="change")
	private Integer change;
	
	@Column(name="ticket_avoided")
	private Integer ticketAvoided;
	
	@Column(name="tenant")
	private String tenant;
	
	@Column(name="external_system_ticket", columnDefinition="Text")
	private String externalSystemTicket;
	
	@Column(name="incorrectly_assigned")
	private Integer incorrectlyAssigned;
	
	@Column(name="major_incident")
	private Integer majorIncident;
	
	@Column(name="remote_control_used")
	private Integer remoteControlUsed;
	
	@Column(name="requested_by")
	private String requestedBy;
	
	@Column(name="resolution_code")
	private Integer resolutionCode;
	
	@Column(name="target_closed_last")
	private Date targetClosedLast;
	
	@Column(name="target_resolved_last")
	private Date targetResolvedLast;
	
	@Column(name="target_start_last")
	private Date targetStartLast;
	
	@Column(name="zcategory_init")
	private String zcategoryInit;
	
	@Column(name="zfecha_sol")
	private Date zfechaSol;
	
	@Column(name="zradiobases_id")
	private Integer zradiobasesId;
	
	@Column(name="zDiagnostico_id")
	private Integer zDiagnosticoId;
	
	@Column(name="zsolucion_id")
	private Integer zsolucionId;
	
	@Column(name="zact_realizadas" ,columnDefinition="Text") 
	private String zactRealizadas;
	
	@Column(name="zdiag_inicial", columnDefinition="Text") 
	private String zdiagInicial;
	
	@Column(name="zafectacion")
	private Integer zafectacion;
	
	@Column(name="zregion")
	private String zregion;
	
	@Column(name="heat")
	private Integer heat;
	
	@Column(name="zfalla_imputable_cte")
	private Integer zfallaImputableCte;
	
	@Column(name="zfalla_imputable_tpe")
	private Integer zfallaImputableTpe;
	
	@Column(name="zintrf_trigger_app_id")
	private Integer zintrfTriggerAppId;
	
	@Column(name="ztiempo_falla_cte")
	private Integer ztiempoFallaCte;
	
	@Column(name="ztiempo_falla_tpe")
	private Integer ztiempoFallaTpe;
	
	@Column(name="zCircuito_id")
	private Integer zCircuitoId;
	
	@Column(name="zProveedor_id")
	private Integer zProveedorId;
	
	@Column(name="zRegCiu_id")
	private Integer zRegCiuId;
	
	@Column(name="zResponsables_id")
	private Integer zResponsablesId;
	
	@Column(name="zvalidador_cte")
	private String zvalidadorCte;
	
	@Column(name="ztipo_solicitud")
	private Integer ztipoSolicitud;
	
	@Column(name="zhay_afecta_serv_cte")
	private Integer zhayAfectaServCte;
	
	@Column(name="zuni_negocio")
	private String zuniNegocio;
	
	@Column(name="z_nom_punta_inex")
	private String zNomPuntaInex;
	
	@Column(name="z_punta_inexistente")
	private Integer zPuntaInexistente;
	
	@Column(name="zes_proactivo_reactivo")
	private String zesProactivoReactivo;
	
	@Column(name="zNivel_Soporte")
	private String zNivelSoporte;
	
	@Column(name="zTipo_Soporte")
	private String zTipoSoporte;
	
	@Column(name="zSrv_Afct_id")
	private Integer zSrvAfctId;
	
	@Column(name="affected_rc")
	private String affectedRc;
	
	@Column(name="ztiempo_falla_prov")
	private Integer ztiempoFallaProv;
	
	@Column(name="ztiempo_falla_terceros")
	private Integer ztiempoFallaTerceros;
	
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

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
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

	public Integer getTimeSpentSum() {
		return timeSpentSum;
	}

	public void setTimeSpentSum(Integer timeSpentSum) {
		this.timeSpentSum = timeSpentSum;
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

	public String getLogAgent() {
		return logAgent;
	}

	public void setLogAgent(String logAgent) {
		this.logAgent = logAgent;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Integer getImpact() {
		return impact;
	}

	public void setImpact(Integer impact) {
		this.impact = impact;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getUrgency() {
		return urgency;
	}

	public void setUrgency(Integer urgency) {
		this.urgency = urgency;
	}

	public Integer getSeverety() {
		return severety;
	}

	public void setSeverety(Integer severety) {
		this.severety = severety;
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

	public Integer getCallBackFlag() {
		return callBackFlag;
	}

	public void setCallBackFlag(Integer callBackFlag) {
		this.callBackFlag = callBackFlag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Integer getIncidentPriority() {
		return incidentPriority;
	}

	public void setIncidentPriority(Integer incidentPriority) {
		this.incidentPriority = incidentPriority;
	}

	public Integer getChange() {
		return change;
	}

	public void setChange(Integer change) {
		this.change = change;
	}

	public Integer getTicketAvoided() {
		return ticketAvoided;
	}

	public void setTicketAvoided(Integer ticketAvoided) {
		this.ticketAvoided = ticketAvoided;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getExternalSystemTicket() {
		return externalSystemTicket;
	}

	public void setExternalSystemTicket(String externalSystemTicket) {
		this.externalSystemTicket = externalSystemTicket;
	}

	public Integer getIncorrectlyAssigned() {
		return incorrectlyAssigned;
	}

	public void setIncorrectlyAssigned(Integer incorrectlyAssigned) {
		this.incorrectlyAssigned = incorrectlyAssigned;
	}

	public Integer getMajorIncident() {
		return majorIncident;
	}

	public void setMajorIncident(Integer majorIncident) {
		this.majorIncident = majorIncident;
	}

	public Integer getRemoteControlUsed() {
		return remoteControlUsed;
	}

	public void setRemoteControlUsed(Integer remoteControlUsed) {
		this.remoteControlUsed = remoteControlUsed;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public Integer getResolutionCode() {
		return resolutionCode;
	}

	public void setResolutionCode(Integer resolutionCode) {
		this.resolutionCode = resolutionCode;
	}

	public Date getTargetClosedLast() {
		return targetClosedLast;
	}

	public void setTargetClosedLast(Date targetClosedLast) {
		this.targetClosedLast = targetClosedLast;
	}

	public Date getTargetResolvedLast() {
		return targetResolvedLast;
	}

	public void setTargetResolvedLast(Date targetResolvedLast) {
		this.targetResolvedLast = targetResolvedLast;
	}

	public Date getTargetStartLast() {
		return targetStartLast;
	}

	public void setTargetStartLast(Date targetStartLast) {
		this.targetStartLast = targetStartLast;
	}

	public String getZcategoryInit() {
		return zcategoryInit;
	}

	public void setZcategoryInit(String zcategoryInit) {
		this.zcategoryInit = zcategoryInit;
	}

	public Date getZfechaSol() {
		return zfechaSol;
	}

	public void setZfechaSol(Date zfechaSol) {
		this.zfechaSol = zfechaSol;
	}

	public Integer getZradiobasesId() {
		return zradiobasesId;
	}

	public void setZradiobasesId(Integer zradiobasesId) {
		this.zradiobasesId = zradiobasesId;
	}

	public Integer getzDiagnosticoId() {
		return zDiagnosticoId;
	}

	public void setzDiagnosticoId(Integer zDiagnosticoId) {
		this.zDiagnosticoId = zDiagnosticoId;
	}

	public Integer getZsolucionId() {
		return zsolucionId;
	}

	public void setZsolucionId(Integer zsolucionId) {
		this.zsolucionId = zsolucionId;
	}

	public String getZactRealizadas() {
		return zactRealizadas;
	}

	public void setZactRealizadas(String zactRealizadas) {
		this.zactRealizadas = zactRealizadas;
	}

	public String getZdiagInicial() {
		return zdiagInicial;
	}

	public void setZdiagInicial(String zdiagInicial) {
		this.zdiagInicial = zdiagInicial;
	}

	public Integer getZafectacion() {
		return zafectacion;
	}

	public void setZafectacion(Integer zafectacion) {
		this.zafectacion = zafectacion;
	}

	public String getZregion() {
		return zregion;
	}

	public void setZregion(String zregion) {
		this.zregion = zregion;
	}

	public Integer getHeat() {
		return heat;
	}

	public void setHeat(Integer heat) {
		this.heat = heat;
	}

	public Integer getZfallaImputableCte() {
		return zfallaImputableCte;
	}

	public void setZfallaImputableCte(Integer zfallaImputableCte) {
		this.zfallaImputableCte = zfallaImputableCte;
	}

	public Integer getZfallaImputableTpe() {
		return zfallaImputableTpe;
	}

	public void setZfallaImputableTpe(Integer zfallaImputableTpe) {
		this.zfallaImputableTpe = zfallaImputableTpe;
	}

	public Integer getZintrfTriggerAppId() {
		return zintrfTriggerAppId;
	}

	public void setZintrfTriggerAppId(Integer zintrfTriggerAppId) {
		this.zintrfTriggerAppId = zintrfTriggerAppId;
	}

	public Integer getZtiempoFallaCte() {
		return ztiempoFallaCte;
	}

	public void setZtiempoFallaCte(Integer ztiempoFallaCte) {
		this.ztiempoFallaCte = ztiempoFallaCte;
	}

	public Integer getZtiempoFallaTpe() {
		return ztiempoFallaTpe;
	}

	public void setZtiempoFallaTpe(Integer ztiempoFallaTpe) {
		this.ztiempoFallaTpe = ztiempoFallaTpe;
	}

	public Integer getzCircuitoId() {
		return zCircuitoId;
	}

	public void setzCircuitoId(Integer zCircuitoId) {
		this.zCircuitoId = zCircuitoId;
	}

	public Integer getzProveedorId() {
		return zProveedorId;
	}

	public void setzProveedorId(Integer zProveedorId) {
		this.zProveedorId = zProveedorId;
	}

	public Integer getzRegCiuId() {
		return zRegCiuId;
	}

	public void setzRegCiuId(Integer zRegCiuId) {
		this.zRegCiuId = zRegCiuId;
	}

	public Integer getzResponsablesId() {
		return zResponsablesId;
	}

	public void setzResponsablesId(Integer zResponsablesId) {
		this.zResponsablesId = zResponsablesId;
	}

	public String getZvalidadorCte() {
		return zvalidadorCte;
	}

	public void setZvalidadorCte(String zvalidadorCte) {
		this.zvalidadorCte = zvalidadorCte;
	}

	public Integer getZtipoSolicitud() {
		return ztipoSolicitud;
	}

	public void setZtipoSolicitud(Integer ztipoSolicitud) {
		this.ztipoSolicitud = ztipoSolicitud;
	}

	public Integer getZhayAfectaServCte() {
		return zhayAfectaServCte;
	}

	public void setZhayAfectaServCte(Integer zhayAfectaServCte) {
		this.zhayAfectaServCte = zhayAfectaServCte;
	}

	public String getZuniNegocio() {
		return zuniNegocio;
	}

	public void setZuniNegocio(String zuniNegocio) {
		this.zuniNegocio = zuniNegocio;
	}

	public String getzNomPuntaInex() {
		return zNomPuntaInex;
	}

	public void setzNomPuntaInex(String zNomPuntaInex) {
		this.zNomPuntaInex = zNomPuntaInex;
	}

	public Integer getzPuntaInexistente() {
		return zPuntaInexistente;
	}

	public void setzPuntaInexistente(Integer zPuntaInexistente) {
		this.zPuntaInexistente = zPuntaInexistente;
	}

	public String getZesProactivoReactivo() {
		return zesProactivoReactivo;
	}

	public void setZesProactivoReactivo(String zesProactivoReactivo) {
		this.zesProactivoReactivo = zesProactivoReactivo;
	}

	public String getzNivelSoporte() {
		return zNivelSoporte;
	}

	public void setzNivelSoporte(String zNivelSoporte) {
		this.zNivelSoporte = zNivelSoporte;
	}

	public String getzTipoSoporte() {
		return zTipoSoporte;
	}

	public void setzTipoSoporte(String zTipoSoporte) {
		this.zTipoSoporte = zTipoSoporte;
	}

	public Integer getzSrvAfctId() {
		return zSrvAfctId;
	}

	public void setzSrvAfctId(Integer zSrvAfctId) {
		this.zSrvAfctId = zSrvAfctId;
	}

	public String getAffectedRc() {
		return affectedRc;
	}

	public void setAffectedRc(String affectedRc) {
		this.affectedRc = affectedRc;
	}

	public Integer getZtiempoFallaProv() {
		return ztiempoFallaProv;
	}

	public void setZtiempoFallaProv(Integer ztiempoFallaProv) {
		this.ztiempoFallaProv = ztiempoFallaProv;
	}

	public Integer getZtiempoFallaTerceros() {
		return ztiempoFallaTerceros;
	}

	public void setZtiempoFallaTerceros(Integer ztiempoFallaTerceros) {
		this.ztiempoFallaTerceros = ztiempoFallaTerceros;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	

}
