package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;


import org.springframework.security.access.prepost.PreAuthorize;

import Integracion_TPE_SF_B64_pkg.ResponseWS;

public interface CAObjectSFB64 {

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public ResponseWS createRequest(String ref_num, String name_file, String b64_code) throws RemoteException;

}
