package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoapProxy;

@Service("serverService")
@Transactional
public class CAServerImpl implements CAServer {

    private USD_WebServiceSoap portCA = new USD_WebServiceSoapProxy();
	
	@Override
	public int getServerStatus(int token) throws RemoteException {
		int res = 0;
		res = portCA.serverStatus(token);
		return res;
	}
}
