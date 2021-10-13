package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Integracion_TPE_SF_B64.Integracion_TPE_SF_B64Proxy;
import Integracion_TPE_SF_B64_pkg.Integracion_TPE_SF_B64;
import Integracion_TPE_SF_B64_pkg.ResponseWS;

@Service("objServiceSFB64")
@Transactional
public class CAObjectSFB64Impl implements CAObjectSFB64 {

	private Integracion_TPE_SF_B64 b64 = new Integracion_TPE_SF_B64Proxy();

	@Override
	public ResponseWS createRequest(String ref_num, String name_file, String b64_code) throws RemoteException {
		ResponseWS response = new ResponseWS();

		response = b64.create_attmnt(ref_num, name_file, b64_code);

		return response;
	}

}
