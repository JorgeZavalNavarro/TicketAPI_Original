package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StatusORequest {
	
	@NotNull
	@Size(min=1, max=255)
	private String refNum;
	
	@NotNull
	@Size(min=1, max=100)
	private String sym;
	
	@NotNull
	@Size(min=1, max=10)
	private String creator;
	
	@NotNull
	@Size(min=1, max=500)
	private String comment;
	
	@NotNull
	@Size(min=1, max=500)
	private String justificacion;
	
	@NotNull
	@Size(min=1, max=500)
	private String diagFinal;
	
	
	private String solution;
	
	@NotNull
	@Size(min=1, max=500)
	private String actRealizadas;
	
	@NotNull
	@Size(min=1, max=500)
	private String areaResultora;
	
	@NotNull
	@Size(min=1, max=500)
	private String nivelSoporte;
	
	
	private String regCiuId;
	

	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	
	public String getSym() {
		return sym;
	}
	public void setSym(String sym) {
		this.sym = sym;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	public String getJustificacion() {
		return justificacion;
	}
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}
	public String getDiagFinal() {
		return diagFinal;
	}
	public void setDiagFinal(String diagFinal) {
		this.diagFinal = diagFinal;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getActRealizadas() {
		return actRealizadas;
	}
	public void setActRealizadas(String actRealizadas) {
		this.actRealizadas = actRealizadas;
	}
	public String getAreaResultora() {
		return areaResultora;
	}
	public void setAreaResultora(String areaResultora) {
		this.areaResultora = areaResultora;
	}
	public String getNivelSoporte() {
		return nivelSoporte;
	}
	public void setNivelSoporte(String nivelSoporte) {
		this.nivelSoporte = nivelSoporte;
	}
	public String getRegCiuId() {
		return regCiuId;
	}
	public void setRegCiuId(String regCiuId) {
		this.regCiuId = regCiuId;
	}
	
	
}
