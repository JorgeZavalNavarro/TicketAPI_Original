package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

import org.springframework.security.access.prepost.PreAuthorize;

//import com.ca.www.TotalPlay.ResponseWS;

public interface CAObject {
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String createRequest(int token, String userHandle, String[] argsCreate, String[] propertyValues, String[] attributes,StringHolder newRequestHandle,StringHolder newRequestNumber) throws RemoteException;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public boolean changeStatus(String refNum, String idStatus, String comment, int token, String shand) throws RemoteException;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public void createObject(int token, String objectType, String[] attrVals, String[] attributes,StringHolder createObjectResult, StringHolder newHandle) throws RemoteException;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String createChangeObject(int sid, String creatorHandle, String[] attrVals, String[] propertyValues, String template, String[] attributes, StringHolder newChangeHandle, StringHolder newChangeNumber)throws RemoteException;
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String loadFile(int sid, String repositoryHandle,String objectHandle,String description, String fileName)throws RemoteException;
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String addComment(int sid,String creator, String objectHandle,String description, String logType, int timeSpent, boolean internal) throws RemoteException;
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String updateObject(int sid, java.lang.String objectHandle, java.lang.String[] attrVals, java.lang.String[] attributes) throws RemoteException;

	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String registrarSolicitud(String[] cadena);
	
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public String transfer(int sid, String creator, String objectHandle, String description, boolean setAssignee, String newAssigneeHandle, boolean setGroup, String newGroupHandle, boolean setOrganization, String newOrganizationHandle) throws RemoteException;
	
	
	
}
