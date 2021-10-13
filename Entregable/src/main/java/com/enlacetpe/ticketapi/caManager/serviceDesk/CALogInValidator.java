package com.enlacetpe.ticketapi.caManager.serviceDesk;

import java.rmi.RemoteException;

import org.aeonbits.owner.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enlacetpe.ticketapi.caService.serviceDesk.AppProps;
import com.enlacetpe.ticketapi.caService.serviceDesk.CALogIn;
import com.enlacetpe.ticketapi.caService.serviceDesk.CAServer;
import com.enlacetpe.ticketapi.util.AES128;

@Component("logInValidator")
public class CALogInValidator {
	
	@Autowired
	private CALogIn logInService;
	
	@Autowired
	private CAServer serverService;
	
	public int getToken() throws RemoteException {
		AppProps props = ConfigFactory.create(AppProps.class);
		String user = props.user();
		String pass = props.pass();
		System.out.println("VALORES DEL LOGIN SD - - - - - " + user + "/" + pass);
		AES128 aes = new AES128();				
		user = aes.decrypt(user);
		pass = aes.decrypt(pass);
		System.out.println("VALORES DEL LOGIN SD - - - - - " + user + "/" + pass);
		int token = logInService.logIn(user, pass);
	
		if(token < 2000)
			token = 0;
		return token;
	}
	
	public String getUserHandle(int token) throws RemoteException {
		AppProps props = ConfigFactory.create(AppProps.class);		
		String user = props.user();
		AES128 encoder = new AES128();				
		user = encoder.decrypt(user);
		return logInService.getUserHandle(token, user);
	}
	
	public boolean closeToken(int token) throws RemoteException {
		return logInService.logOut(token);
	}	
	
	public int getServerStatus(int token) throws RemoteException {
		return serverService.getServerStatus(token);
	}
}
