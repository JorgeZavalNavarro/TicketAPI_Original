package com.enlacetpe.ticketapi.caManager.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult;
import com.enlacetpe.ticketapi.caService.serviceDesk.CAQuery;


@Component("queryValidator")
public class CAQueryValidator {
	
	@Autowired
	private CAQuery queryService;
	
	public ListResult doQuery(int token, String obj, String criteria) throws RemoteException {
		return queryService.doQuery(token, obj, criteria);
	}

	public String getList(int token, int list, int init, int end, String[] attributes) throws RemoteException {
		return queryService.getList(token, list, init, end, attributes);
	}
	
	public String doSelect(int token, String objType, String criteria, int maxRows, String[] attributes) throws RemoteException {
		return queryService.doSelect(token, objType, criteria, maxRows, attributes);
	}
}
