package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoapProxy;

@Service("queryService")
@Transactional
public class CAQueryImpl implements CAQuery {

    private USD_WebServiceSoap portCA = new USD_WebServiceSoapProxy();
    
    @Override
	public ListResult doQuery(int token, String objType, String criteria) throws RemoteException {
		ListResult res = null;
		res = portCA.doQuery(token, objType, criteria);
    	return res;
	}
	
	@Override
	public String getList(
			int token, int listId, int init, int end, String[] attributes) throws RemoteException {
		String res = null;
		res = portCA.getListValues(token, listId, init, end, attributes);
    	return res;
	}

	@Override
	public String doSelect(
			int token, String objType, String criteria, int maxRows, String[] attributes) throws RemoteException {
		String res = null;
		res = portCA.doSelect(token, objType, criteria, maxRows, attributes);
		return res;
	}
}
