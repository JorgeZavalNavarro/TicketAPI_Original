package com.enlacetpe.ticketapi.response;

import java.util.Date;

import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonInclude;


public class CARfc{ 

	private String edo;
	private String fchaInicio;
	private String duracion;
	private String fchaTermino;
	private String afectacionClientes;
	
	
	public CARfc(Boolean success, Period period, String string, String date, String integer, String date2, String string2, String string3) {
		super();
		// TODO Auto-generated constructor stub
	}

	public CARfc(boolean success, Period period,  String edo, String fchaInicio, String duracion, String fchaTermino, String afectacionClientes) {
		super();
		
		this.edo = edo;
		this.fchaInicio = fchaInicio;
		this.duracion = duracion;
		this.fchaTermino = fchaTermino;
		this.afectacionClientes = afectacionClientes;
	}



	public CARfc() {
		// TODO Auto-generated constructor stub
	}

	public String getEdo() {
		return edo;
	}

	public void setEdo(String edo) {
		this.edo = edo;
	}
	
	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getAfectacionClientes() {
		return afectacionClientes;
	}

	public void setAfectacionClientes(String afectacionClientes) {
		this.afectacionClientes = afectacionClientes;
	}

	public String getFchaInicio() {
		return fchaInicio;
	}

	public void setFchaInicio(String fchaInicio) {
		this.fchaInicio = fchaInicio;
	}

	public String getFchaTermino() {
		return fchaTermino;
	}

	public void setFchaTermino(String fchaTermino) {
		this.fchaTermino = fchaTermino;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CARfc [edo=");
		builder.append(edo);
		builder.append(", fchaInicio=");
		builder.append(fchaInicio);
		builder.append(", duracion=");
		builder.append(duracion);
		builder.append(", fchaTermino=");
		builder.append(fchaTermino);
		builder.append(", afectacionClientes=");
		builder.append(afectacionClientes);
		builder.append("]");
		return builder.toString();
	}
	
}
