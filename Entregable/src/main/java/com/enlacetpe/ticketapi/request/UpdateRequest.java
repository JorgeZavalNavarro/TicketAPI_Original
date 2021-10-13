package com.enlacetpe.ticketapi.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UpdateRequest {
	
	@NotNull
	@Size(min=1, max=10, message="El ticket no debe estar vacio")
	private String refNum;
	
	private String comment;
	
	@NotNull
	@Size(min=1, max=500, message ="El usuario no debe estar vacio")
	private String usuario;
	
	@Pattern(regexp="^$|^[0-9][0-9]:[0-5][0-9]$",message="Formato ETA incorrecto debe introducir el siguiente formato HH:MM o mandar vacio")
	private String eta;
	
	@Pattern(regexp="^$|^[0-9][0-9]:[0-5][0-9]$",message="Formato ETR incorrecto debe introducir el siguiente formato HH:MM o mandar vacio")
	private String etr;
	
	@Pattern(regexp="^$|^0$|^[\\+-](9[0]|[1-8][0-9]|[0-9]).\\d{0,6}$",  message = "Fomato de latitud incorrecto se debe mandar un rango entre -90.000000 a +90.000000 o vacio o 0")
	private String latitud;
	
	@Pattern(regexp="^$|^0$|^[\\-+](18[0]|(1([0-7])[0-9])|(([1-9])[0-9])||[1-9]).\\d{0,6}$",  message = "Fomato de longitd incorrecto se debe amandar un rango de -180.000000 a +180.000000 o vacio o 0")
	private String longitud;
	
	private String usuarioBot;

	public String getRefNum() {
		return refNum;
	}

	public String getComment() {
		return comment;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getEta() {
		return eta;
	}

	public String getEtr() {
		return etr;
	}

	public String getLatitud() {
		return latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public void setEtr(String etr) {
		this.etr = etr;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "UpdateRequest [refNum=" + refNum + ", comment=" + comment + ", usuario=" + usuario + ", eta=" + eta
				+ ", etr=" + etr + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

	public String getUsuarioBot() {
		return usuarioBot;
	}

	public void setUsuarioBot(String usuarioBot) {
		this.usuarioBot = usuarioBot;
	}
	
	
	

}
