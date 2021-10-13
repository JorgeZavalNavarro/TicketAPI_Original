package com.enlacetpe.ticketapi.caManager.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enlacetpe.ticketapi.caService.serviceDesk.CAObjectSFB64;

import Integracion_TPE_SF_B64_pkg.ResponseWS;

@Component("objValidatorSFB64")
public class CAObjectValidatorSFB64 {

	@Autowired
	private CAObjectSFB64 objService;

	public ResponseWS adjuntarArchivoSD(String ref_num, String name_file, String b64_code) throws RemoteException {

		return objService.createRequest(ref_num, name_file, b64_code);
	}

}
