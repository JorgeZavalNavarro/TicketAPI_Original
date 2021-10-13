package com.enlacetpe.ticketapi.caService.serviceDesk;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoap;
import com.ca.www.UnicenterServicePlus.ServiceDesk.USD_WebServiceSoapProxy;

@Service("logInService")
@Transactional
public class CALogInImpl implements CALogIn {

    private USD_WebServiceSoap portCA = new USD_WebServiceSoapProxy();    
    
    @Override
	public int logIn(String user, String pass) throws RemoteException {
    	int token = 0;
		token = portCA.login(user, pass);
		return token;
	}
	
    @Override
	public boolean logOut(int token) throws RemoteException {
		boolean res = true;
		portCA.logout(token);	
		return res;
	}
    
    @Override
    public String getUserHandle(int token, String user) throws RemoteException {
    	String userHandle = null;
		userHandle = portCA.getHandleForUserid(token, user);
    	return userHandle;
    }
}
