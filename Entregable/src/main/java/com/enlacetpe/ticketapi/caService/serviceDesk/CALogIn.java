package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.security.access.prepost.PreAuthorize;

public interface CALogIn {
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public int logIn(String user, String pass) throws RemoteException;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public boolean logOut(int token) throws RemoteException;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String getUserHandle(int token, String user) throws RemoteException;
}
