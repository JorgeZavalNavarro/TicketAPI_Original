package com.enlacetpe.ticketapi.request;

public class EncodeBase64Request {
	
	private String url;
	private String extension;
	private String nombre;
	
	
	public String getUrl() {
		return url;
	}
	public String getExtension() {
		return extension;
	}
	public String getNombre() {
		return nombre;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
