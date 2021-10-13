package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.ca.www.TotalPlay.ResponseWS;
//import com.ca.www.TotalPlay.TotalPlayProxy;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoapProxy;

@Service("objService")
@Transactional
public class CAObjectImpl implements CAObject {

    private USD_WebServiceSoap portCA = new USD_WebServiceSoapProxy();
    
    
    @Override
    public String createRequest(
    		int token, String userHandle, String[] argsCreate, String[] propertyValues, String[] attributes,StringHolder newRequestHandle,StringHolder newRequestNumber) throws RemoteException {
    	String ticketId = null;
	    ticketId = portCA.createRequest(token, userHandle, argsCreate, propertyValues, "", attributes, newRequestHandle, newRequestNumber);
	    return ticketId; 
    }
    
    @Override
    public boolean changeStatus(String refNum, String idStatus, String comment, int token, String shand) throws RemoteException {
    	boolean res = true;
	    String changeStatus = portCA.changeStatus(token, shand, refNum, comment, idStatus);
	    if(changeStatus.isEmpty()) {
	    	System.out.println("No se obtuvo respuesta de changeStatus");
	    	res= false;
	    }
    	return res;
    }
    
    @Override
    public void createObject(int token, String objectType, String[] attrVals, String[] attributes,StringHolder createObjectResult, StringHolder newHandle) throws RemoteException {
	    portCA.createObject(token, objectType, attrVals, attributes, createObjectResult, newHandle);
    }

	@Override
	public String createChangeObject(int sid, String creatorHandle, String[] attrVals, String[] propertyValues,
			String template, String[] attributes, StringHolder newChangeHandle, StringHolder newChangeNumber)
			throws RemoteException {
			String changeId = null;
			changeId = portCA.createChangeOrder(sid, creatorHandle, attrVals, propertyValues, template, attributes, newChangeHandle, newChangeNumber);
		return changeId;
	}

	@Override
	public String loadFile(int sid, String repositoryHandle, String objectHandle, String description, String fileName)
			throws RemoteException {
			String respuesta = null;
			respuesta = portCA.createAttachment(sid, repositoryHandle, objectHandle, description, fileName);
			return respuesta;
	}

	@Override
	public String addComment(int sid,String creator, String objectHandle, String description, String logType, int timeSpent,
			boolean internal) throws RemoteException{
			String respuesta = null;
			respuesta = portCA.createActivityLog(sid, creator, objectHandle, description, logType, timeSpent, internal);
		return respuesta;
	}

	@Override
	public String updateObject(int sid, String objectHandle, String[] attrVals, String[] attributes)
			throws RemoteException {
			String respuesta = null;
			respuesta = portCA.updateObject(sid, objectHandle, attrVals, attributes);
		return respuesta;
	}

	@Override
	public String registrarSolicitud(String[] cadena) {
			String respuesta = null;
			
		// TODO Auto-generated method stub
		return respuesta;
	}
	
	@Override
	public String transfer(int sid, String creator, String objectHandle, String description, boolean setAssignee,
			String newAssigneeHandle, boolean setGroup, String newGroupHandle, boolean setOrganization,
			String newOrganizationHandle) throws RemoteException {
		String respuesta = null;
		respuesta = portCA.transfer(sid, creator, objectHandle, description, setAssignee, newAssigneeHandle, setGroup,
				newGroupHandle, setOrganization, newOrganizationHandle);
		return respuesta;
	}

}
