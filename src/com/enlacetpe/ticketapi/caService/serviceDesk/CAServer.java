package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.security.access.prepost.PreAuthorize;

public interface CAServer {
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public int getServerStatus(int server) throws RemoteException;	
}
