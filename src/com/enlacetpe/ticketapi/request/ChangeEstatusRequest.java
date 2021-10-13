package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangeEstatusRequest {
	
		@NotNull
		@Size(min=1, max=255)
		private String refNum;
		
		@NotNull
		@Size(min=1, max=100)
		private String estatus;
		
		@NotNull
		@Size(min=1, max=10)
		private String solicitadoPor;
		
		private String comentario;
		
		private String justificacion;
		
		private String diagnostico;
		
		private String solucion;
		
		private String actividadesRealizadas;
		
		private String regCiuId;
		
		private String areaResultora;
		
		private String nivelSoporte;
			

		public String getRefNum() {
			return refNum;
		}

		public String getEstatus() {
			return estatus;
		}

		public String getSolicitadoPor() {
			return solicitadoPor;
		}

		public String getComentario() {
			return comentario;
		}

		public String getJustificacion() {
			return justificacion;
		}

		public String getDiagnostico() {
			return diagnostico;
		}

		public String getSolucion() {
			return solucion;
		}

		public String getActividadesRealizadas() {
			return actividadesRealizadas;
		}

		public String getRegCiuId() {
			return regCiuId;
		}

		public void setRefNum(String refNum) {
			this.refNum = refNum;
		}

		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}

		public void setSolicitadoPor(String solicitadoPor) {
			this.solicitadoPor = solicitadoPor;
		}

		public void setComentario(String comentario) {
			this.comentario = comentario;
		}

		public void setJustificacion(String justificacion) {
			this.justificacion = justificacion;
		}

		public void setDiagnostico(String diagnostico) {
			this.diagnostico = diagnostico;
		}

		public void setSolucion(String solution) {
			this.solucion = solution;
		}

		public void setActividadesRealizadas(String actividadesRealizadas) {
			this.actividadesRealizadas = actividadesRealizadas;
		}

		public void setRegCiuId(String regCiuId) {
			this.regCiuId = regCiuId;
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

		

		
		

		
		
}



