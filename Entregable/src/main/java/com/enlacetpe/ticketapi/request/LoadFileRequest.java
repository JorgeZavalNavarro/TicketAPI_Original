package com.enlacetpe.ticketapi.request;

public class LoadFileRequest {
	
	private String refNum;
	private String base64;
	private String extension;
	private String nombre;

	public String getRefNum() {
		return refNum;
	}

	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}

	public String getBase64() {
		return base64;
	}

	public String getExtension() {
		return extension;
	}

	public String getNombre() {
		return nombre;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
