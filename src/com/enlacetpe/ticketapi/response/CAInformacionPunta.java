package com.enlacetpe.ticketapi.response;

import org.joda.time.Period;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CAInformacionPunta extends CAResponse {

	private String uuid;
	private String hostName;
	private String resourceName;
	private String ip;
	private Integer inactive;
	private String nombreOrganizacion;

	public CAInformacionPunta() {
		super();
	}

	public CAInformacionPunta(Boolean status, String error) {
		super.setSuccess(success);
		super.setError(error);
	}

	public CAInformacionPunta(Boolean status, Period time, String error, String uuid, String hostName,
			String resourceName, String ip, Integer inactive) {
		super(status, time, error);
		this.uuid = uuid;
		this.hostName = hostName;
		this.resourceName = resourceName;
		this.ip = ip;
		this.setInactive(inactive);
	}

	public String getUuid() {
		return uuid;
	}

	public String getHostName() {
		return hostName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getIp() {
		return ip;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getInactive() {
		return inactive;
	}

	public void setInactive(Integer inactive) {
		this.inactive = inactive;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

}
