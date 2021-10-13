package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.security.access.prepost.PreAuthorize;

import com.ca.www.UnicenterServicePlus.ServiceDesk.ListResult;

public interface CAQuery {	

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public ListResult doQuery(int token, String objType, String criteria) throws RemoteException;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String getList(int token, int listId, int init, int end, String[] attributes) throws RemoteException;
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String doSelect(int token, String objType, String criteria, int maxRows, String[] attributes) throws RemoteException;
}
