package com.enlacetpe.ticketapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CATicket {

	private String id;
	private String refNum;
	private String tfe;
	private String tenant;
	private String summary;
	private String priority;
	private String category;
	private String status;
	private String assignee;
	private String assigneeFirstName;
	private String asigneeMiddleName;
	private String assigneeLastName;
	private String customer;
	private String customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	private String description;
	private String requestedBy;
	private String group;
	private String urgency; // me falta este dato
	private String impact;
	private String initialDiagnose; // texto
	private String finalDiagnose; // zdiagnose_id zdiagnostico
	private String solution; // escribe el usuario
	private String solutionTime; // hora en la que se soluciono el ticket fecha
									// hora
	private String openTime; // fecha en la que se abrio
	private String lastModTime; // fecha de ultima actualizacion
	private String resolveTime; // fecha en la que se soluciono en curso a
								// resuleto
	private String closeTime; // fecha de cierre resuelto a cerrado
	private String tiempoEnlace;
	private String tiempoCliente;
	private String ci;
	private String proactivoReactivo;
	private String ztiempoFallaProv;
	private String ztiempoFallaTerceros;
	private String slaViolation;
	private String macroPredictViol;
	private String externalSystemTicket;
	private String ip;
	private String organization;
	private String numeroSerie;
	private String tipoDispositivo;

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerMiddleName() {
		return customerMiddleName;
	}

	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAssigneeFirstName() {
		return assigneeFirstName;
	}

	public void setAssigneeFirstName(String assigneeFirstName) {
		this.assigneeFirstName = assigneeFirstName;
	}

	public String getAsigneeMiddleName() {
		return asigneeMiddleName;
	}

	public void setAsigneeMiddleName(String asigneeMiddleName) {
		this.asigneeMiddleName = asigneeMiddleName;
	}

	public String getAssigneeLastName() {
		return assigneeLastName;
	}

	public void setAssigneeLastName(String assigneeLastName) {
		this.assigneeLastName = assigneeLastName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
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

	public String getInitialDiagnose() {
		return initialDiagnose;
	}

	public void setInitialDiagnose(String initialDiagnose) {
		this.initialDiagnose = initialDiagnose;
	}

	public String getFinalDiagnose() {
		return finalDiagnose;
	}

	public void setFinalDiagnose(String finalDiagnose) {
		this.finalDiagnose = finalDiagnose;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getSolutionTime() {
		return solutionTime;
	}

	public void setSolutionTime(String solutionTime) {
		this.solutionTime = solutionTime;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getLastModTime() {
		return lastModTime;
	}

	public void setLastModTime(String lastModTime) {
		this.lastModTime = lastModTime;
	}

	public String getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getTiempoEnlace() {
		return tiempoEnlace;
	}

	public void setTiempoEnlace(String tiempoEnlace) {
		this.tiempoEnlace = tiempoEnlace;
	}

	public String getTiempoCliente() {
		return tiempoCliente;
	}

	public void setTiempoCliente(String tiempoCliente) {
		this.tiempoCliente = tiempoCliente;
	}

	public String getTfe() {
		return tfe;
	}

	public void setTfe(String tfe) {
		this.tfe = tfe;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getProactivoReactivo() {
		return proactivoReactivo;
	}

	public void setProactivoReactivo(String proactivoReactivo) {
		this.proactivoReactivo = proactivoReactivo;
	}

	public String getZtiempoFallaProv() {
		return ztiempoFallaProv;
	}

	public String getZtiempoFallaTerceros() {
		return ztiempoFallaTerceros;
	}

	public String getSlaViolation() {
		return slaViolation;
	}

	public String getMacroPredictViol() {
		return macroPredictViol;
	}

	public void setZtiempoFallaProv(String ztiempoFallaProv) {
		this.ztiempoFallaProv = ztiempoFallaProv;
	}

	public void setZtiempoFallaTerceros(String ztiempoFallaTerceros) {
		this.ztiempoFallaTerceros = ztiempoFallaTerceros;
	}

	public void setSlaViolation(String slaViolation) {
		this.slaViolation = slaViolation;
	}

	public void setMacroPredictViol(String macroPredictViol) {
		this.macroPredictViol = macroPredictViol;
	}

	public String getExternalSystemTicket() {
		return externalSystemTicket;
	}

	public void setExternalSystemTicket(String externalSystemTicket) {
		this.externalSystemTicket = externalSystemTicket;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

}