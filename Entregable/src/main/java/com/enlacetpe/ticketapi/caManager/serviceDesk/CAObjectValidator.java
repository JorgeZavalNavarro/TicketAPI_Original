package com.enlacetpe.ticketapi.caManager.serviceDesk;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enlacetpe.ticketapi.caService.serviceDesk.CAObject;

@Component("objValidator")
public class CAObjectValidator {

	@Autowired
	private CAObject objService;

	public String createTicket(int token, String userHandle, String[] argsCreate, String[] propertyValues,
			String[] attributes, StringHolder newRequestHandle, StringHolder newRequestNumber) throws RemoteException {
		return objService.createRequest(token, userHandle, argsCreate, propertyValues, attributes, newRequestHandle,
				newRequestNumber);
	}

	public boolean updateStatus(String refNum, String idStatus, String comment, int token, String shand)
			throws RemoteException {
		return objService.changeStatus(refNum, idStatus, comment, token, shand);
	}

	public String loadFile(int sid, String repositoryHandle, String objectHandle, String description, String fileName)
			throws RemoteException {
		return objService.loadFile(sid, repositoryHandle, objectHandle, description, fileName);
	}

	public String addComment(int sid, String creator, String objectHandle, String description, String logType,
			int timeSpent, boolean internal) throws RemoteException {
		return objService.addComment(sid, creator, objectHandle, description, logType, timeSpent, internal);
	}

	public String updateObject(int sid, java.lang.String objectHandle, java.lang.String[] attrVals,
			java.lang.String[] attributes) throws RemoteException {
		return objService.updateObject(sid, objectHandle, attrVals, attributes);
	}

	public String registrarSolicitud(String[] cadena) throws RemoteException {
		return objService.registrarSolicitud(cadena);
	}
	
	public String transfer(int sid, String creator, String objectHandle, String description, boolean setAssignee,
			String newAssigneeHandle, boolean setGroup, String newGroupHandle, boolean setOrganization,
			String newOrganizationHandle) throws RemoteException {
		return objService.transfer(sid, creator, objectHandle, description, setAssignee, newAssigneeHandle, setGroup,
				newGroupHandle, setOrganization, newOrganizationHandle);
	}
}
