package com.enlacetpe.ticketapi.request;

public class ActualizaIPRequest {

	private String ipActualizar;
	private String ipNueva;
	private String usuarioActualiza;

	public String getIpActualizar() {
		return ipActualizar;
	}

	public void setIpActualizar(String ipActualizar) {
		this.ipActualizar = ipActualizar;
	}

	public String getIpNueva() {
		return ipNueva;
	}

	public void setIpNueva(String ipNueva) {
		this.ipNueva = ipNueva;
	}

	/**
	 * @return the usuarioActualiza
	 */
	public String getUsuarioActualiza() {
		return usuarioActualiza;
	}

	/**
	 * @param usuarioActualiza
	 *            the usuarioActualiza to set
	 */
	public void setUsuarioActualiza(String usuarioActualiza) {
		this.usuarioActualiza = usuarioActualiza;
	}

}
